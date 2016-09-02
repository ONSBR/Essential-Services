package br.org.ons.EssentialServices.rest;

import java.util.Collection;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import br.org.ons.EssentialServices.model.ApplicationProvider;
import br.org.ons.EssentialServices.repository.iEntityRepository;

@SuppressWarnings("unchecked")
@Path("/application-providers")
public class EssentialServiceIntegration {
    static final Logger LOGGER = Logger.getLogger(EssentialServiceIntegration.class); 
    
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Collection<ApplicationProvider> getApplicationProviders(@Context ServletContext ctx) throws JSONException, Exception {
    	LOGGER.debug("Real path vazio " + ctx.getRealPath(""));
    	LOGGER.debug("Real path ./ " + ctx.getRealPath("./"));
    	LOGGER.debug(System.getProperty("protege.dir"));
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ctx);
        iEntityRepository repository = (iEntityRepository) context.getBean("ApplicationProviderEntityRepositoryImpl");

		Collection<ApplicationProvider> applicationProviders = (Collection<ApplicationProvider>) repository.getSimpleEntities();
        return applicationProviders;
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Consumes(MediaType.APPLICATION_JSON)
    public ApplicationProvider saveApplicationProvider(@Context ServletContext ctx, ApplicationProvider applicationProvider) throws JSONException, Exception {
    	WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ctx);
        iEntityRepository repository = (iEntityRepository) context.getBean("ApplicationProviderEntityRepositoryImpl");
        repository.saveEntity(applicationProvider);
    	return applicationProvider;
    }
}