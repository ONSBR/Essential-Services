package br.org.ons.EssentialServices.repository;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;

import br.org.ons.EssentialServices.model.Actor;
import br.org.ons.EssentialServices.model.Stakeholder;
import br.org.ons.EssentialServices.model.iEntity;

public class StakeholderEntityRepositoryImpl extends EntityRepositoryImpl implements iEntityRepository {
	
	private iEntityRepository actorRepository;

	public StakeholderEntityRepositoryImpl() {
		super();
		
		ownTags.put("rolePlayed","actToRoleToRole");
//		ownTags.put("ator","actToRoleFromActor");
		
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
		ArrayList<Stakeholder> stakeholders = new ArrayList<Stakeholder>();
        
        ArrayList<String> slotList = getSimpleTags();
        
        Collection<HashMap<String,Object>> instances = arquiteturaRepository.getObjInstanceMaps(entityObjects, slotList);
        Iterator<HashMap<String,Object>> instancesI = instances.iterator();
        while (instancesI.hasNext()) {
            HashMap<String,Object> map = instancesI.next();
            if (map.containsKey(ownTags.get("rolePlayed")) && map.get(ownTags.get("rolePlayed")) != null) {
            	HashMap<String,Object> translatedMap = translateProperties(map);
                Stakeholder stakeholder = new Stakeholder();
                stakeholder.updateProperties(translatedMap);
                
                //Process Actors
                Collection<Object> actors = arquiteturaRepository.getObjInstancesOfSlot("actToRoleFromActor",map);
                stakeholder.setAtor((Actor)actorRepository.getEntity(actors,0));
                
                stakeholders.add(stakeholder);
            }
        }
        return stakeholders;
	}
	
	@Override
	public ArrayList<? extends iEntity> getDistinctEntities(Collection<Object> entityObjects) throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
	 * @return the actorRepository
	 */
	public iEntityRepository getActorRepository() {
		return actorRepository;
	}

	/**
	 * @param actorRepository the actorRepository to set
	 */
	public void setActorRepository(iEntityRepository actorRepository) {
		this.actorRepository = actorRepository;
	}
	
	@Override
	public iEntity saveEntity(iEntity entity) throws Exception {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
