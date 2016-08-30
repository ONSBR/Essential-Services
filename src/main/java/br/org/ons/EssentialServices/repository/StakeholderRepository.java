package br.org.ons.EssentialServices.repository;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import br.org.ons.EssentialServices.model.Actor;
import br.org.ons.EssentialServices.model.Stakeholder;
import br.org.ons.EssentialServices.model.iEntity;

public class StakeholderRepository extends EntityRepository implements iRepository {
	
	private ActorRepository actorRepository;

	public StakeholderRepository() {
		ownTags.put("rolePlayed","actToRoleToRole");
		ownTags.put("ator","actToRoleFromActor");
		
		inversedOwnTags = ownTags.inverse();
	}
	
	@Override
	public Collection<? extends iEntity> getSimpleEntities() throws Exception{
		return null;
	}
	
	@Override
	public Collection<? extends iEntity> getEntitiesById(Collection<String> ids) throws Exception{
		return null;
	}
	
	@Override
	public iEntity getEntityById(String id) throws Exception{
		return null;
	}

	@Override
	public ArrayList<? extends iEntity> getEntities(Collection<Object> stakeholdersObjects) throws IllegalAccessException, InvocationTargetException {
		ArrayList<Stakeholder> stakeholders = new ArrayList<Stakeholder>();
        
        ArrayList<String> slotList = getSimpleTags();
        
        Collection<HashMap<String,Object>> instances = arquiteturaRepository.getObjInstanceMaps(stakeholdersObjects, slotList);
        Iterator<HashMap<String,Object>> instancesI = instances.iterator();
        while (instancesI.hasNext()) {
            HashMap<String,Object> map = instancesI.next();
            HashMap<String,Object> translatedMap = translateProperties(map);
            Stakeholder stakeholder = new Stakeholder();
            stakeholder.updateProperties(translatedMap);
            
            //Process Actors
            Collection<Object> actors = arquiteturaRepository.getObjInstancesOfSlot("actToRoleFromActor",map);
            stakeholder.setActor((Actor)actorRepository.getEntity(actors,0));
            
            stakeholders.add(stakeholder);
        }
        return stakeholders;
	}

	@Override
	public iEntity getEntity(Collection<Object> entityObjects, int idx) throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
	 * @return the actorRepository
	 */
	public ActorRepository getActorRepository() {
		return actorRepository;
	}

	/**
	 * @param actorRepository the actorRepository to set
	 */
	public void setActorRepository(ActorRepository actorRepository) {
		this.actorRepository = actorRepository;
	}

}
