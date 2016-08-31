package br.org.ons.EssentialServices.repository;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;

import br.org.ons.EssentialServices.model.Actor;
import br.org.ons.EssentialServices.model.iEntity;

public class ActorEntityRepositoryImpl extends EntityRepositoryImpl implements iEntityRepository {
	
	

	public ActorEntityRepositoryImpl() {
		super();
		ownTags.put("id","id");
		ownTags.put("nome","name");
		ownTags.put("parentOrganization","isMemberOfActor");
		ownTags.put("jobPosition","actorHasJobs");
		
		inversedOwnTags = ownTags.inverse();
		
		LOGGER = Logger.getLogger(this.getClass()); 
	}
	
	@Override
	public Collection<? extends iEntity> getEntitiesById(Collection<String> ids) throws Exception{
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
	
	@Override
	public iEntity getEntityById(String id) throws Exception{
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); 
	}

	@Override
	public ArrayList<? extends iEntity> getEntities(Collection<Object> entityObjects) throws IllegalAccessException, InvocationTargetException {
		ArrayList<Actor> actors = new ArrayList<Actor>();
        
        ArrayList<String> slotList = getSimpleTags();
        
        Collection<HashMap<String,Object>> instances = arquiteturaRepository.getObjInstanceMaps(entityObjects, slotList);
        Iterator<HashMap<String,Object>> instancesI = instances.iterator();
        while (instancesI.hasNext()) {
            HashMap<String,Object> map = instancesI.next();
            HashMap<String,Object> translatedMap = translateProperties(map);
            
            // Process Parent Organization
            Iterator<Object> parentOrgs = ((Collection<Object>) translatedMap.get("parentOrganization")).iterator();
            if (parentOrgs.hasNext()) {
            	translatedMap.put("parentOrganization", parentOrgs.next());
            }
            
            // Process Job Position
            Iterator<Object> jobs = ((Collection<Object>) translatedMap.get("jobPosition")).iterator();
            if (jobs.hasNext()) {
            	translatedMap.put("jobPosition", jobs.next());
            }
            Actor actor = new Actor();
            actor.updateProperties(translatedMap);
            
            actors.add(actor);
        }
        return actors;
	}

	@Override
	public ArrayList<? extends iEntity> getDistinctEntities(Collection<Object> entityObjects) throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
}
