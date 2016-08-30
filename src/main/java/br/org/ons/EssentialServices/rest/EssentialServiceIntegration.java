package br.org.ons.EssentialServices.rest;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import br.org.ons.EssentialServices.model.ApplicationProvider;

import br.org.ons.EssentialServices.model.iEntity;
import br.org.ons.EssentialServices.repository.iEntityRepository;
import br.org.ons.EssentialServices.repository.iRepository;

@Path("/application-providers")
public class EssentialServiceIntegration {
    static final Logger LOGGER = Logger.getLogger(EssentialServiceIntegration.class); 
    // @GET
    // @Produces("text/html")
    // public Response getStartingPage(@Context ServletContext context) {
    //     String essentialProjectPath =  context.getInitParameter("essential_project_path");
    //     String output = "<h1>Hello World!<h1>" +
	// 			"<p>RESTful Service is running ... <br>Ping @ " + new Date().toString() + "</p<br>" +
    //             "essential_project_path " + essentialProjectPath;
    //     return Response.status(200).entity(output).build();
    // }

    @GET
    @Produces("application/json")
    public Response getApplicationProviders(@Context ServletContext ctx) throws JSONException, Exception {
    		LOGGER.debug("API chamada");
        String essentialProjectPath =  ctx.getInitParameter("essential_project_path");
        JSONArray jsonArray = new JSONArray();

//        ApplicationProviderRepository repository = new ApplicationProviderRepository();
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ctx);
        iRepository repository = (iRepository) context.getBean("ApplicationProviderRepository");
        ((iEntityRepository)repository).setEssentialProjectPath(essentialProjectPath);

        Collection<ApplicationProvider> applicationProviders = (Collection<ApplicationProvider>) repository.getSimpleEntities();

        Iterator<Map<String,Object>> instancesI = iEntity.serializeCollection(applicationProviders).iterator();

        while (instancesI.hasNext()) {
            jsonArray.put(instancesI.next());
        }
        return Response.status(200).entity(jsonArray.toString()).build(); 

        // EssentialRepository essential = new EssentialRepository(essentialProjectPath);
        
        // ArrayList<String> slotList = new ArrayList();
        // slotList.add("name");
        // slotList.add("description");
        // slotList.add("ap_supplier");
        // slotList.add("uses_information_representation");

        // Collection<HashMap<String,Object>> instances = essential.getObjInstances("Application_Provider", slotList);
        // Iterator<HashMap<String,Object>> instancesI = instances.iterator();
        // while (instancesI.hasNext()) {
        //     HashMap<String,Object> map = instancesI.next();
        //     jsonArray.put(map);
        // }
        // return Response.status(200).entity(jsonArray.toString()).build();
    }
}