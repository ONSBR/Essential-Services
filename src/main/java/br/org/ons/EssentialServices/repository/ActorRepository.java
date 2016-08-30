package br.org.ons.EssentialServices.repository;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import br.org.ons.EssentialServices.model.Actor;
import br.org.ons.EssentialServices.model.iEntity;

public class ActorRepository extends EntityRepository implements iRepository {
	
	

	public ActorRepository() {
		ownTags.put("id","id");
		ownTags.put("nome","name");
		ownTags.put("parentOrganization","isMemberOfActor");
		ownTags.put("jobPosition","actorHasJobs");
		
		inversedOwnTags = ownTags.inverse();
	}
	
	@Override
	public Collection<? extends iEntity> getSimpleEntities() throws Exception{
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
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
	public ArrayList<? extends iEntity> getEntities(Collection<Object> actorsObjects) throws IllegalAccessException, InvocationTargetException {
		ArrayList<Actor> actors = new ArrayList<Actor>();
        
        ArrayList<String> slotList = getSimpleTags();
        
        Collection<HashMap<String,Object>> instances = arquiteturaRepository.getObjInstanceMaps(actorsObjects, slotList);
        Iterator<HashMap<String,Object>> instancesI = instances.iterator();
        while (instancesI.hasNext()) {
            HashMap<String,Object> map = instancesI.next();
            HashMap<String,Object> translatedMap = translateProperties(map);
            
            Iterator<Object> parentOrgs = ((Collection<Object>) translatedMap.get("parentOrganization")).iterator();
            if (parentOrgs.hasNext()) {
            	translatedMap.put("parentOrganization", parentOrgs.next());
            }
            
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
	public iEntity getEntity(Collection<Object> actorsObjects, int idx) throws IllegalAccessException, InvocationTargetException {
		ArrayList<? extends iEntity> actors = getEntities(actorsObjects);
		return actors.size() >= idx+1?actors.get(idx):null;
	}

}
