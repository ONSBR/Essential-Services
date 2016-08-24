package br.org.ons.EssentialServices.rest;

import java.lang.Exception;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.servlet.ServletContext;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import br.org.ons.EssentialServices.repository.EssentialRepository;

@Path("/application-providers")
public class EssentialServiceIntegration {
    
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
    public Response getApplicationProviders(@Context ServletContext context) throws JSONException, Exception {
        String essentialProjectPath =  context.getInitParameter("essential_project_path");
        JSONArray jsonArray = new JSONArray();
        EssentialRepository essential = new EssentialRepository(essentialProjectPath);
        
        ArrayList<String> slotList = new ArrayList();
        slotList.add("name");
        slotList.add("description");
        slotList.add("ap_supplier");
        slotList.add("uses_information_representation");

        Collection<HashMap<String,Object>> instances = essential.getObjInstances("Application_Provider", slotList);
        Iterator<HashMap<String,Object>> instancesI = instances.iterator();
        while (instancesI.hasNext()) {
            HashMap<String,Object> map = instancesI.next();
            jsonArray.put(map);
        }
        return Response.status(200).entity(jsonArray.toString()).build();
    }
}