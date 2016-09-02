/**
 * 
 */
package br.org.ons.EssentialServices.repository;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;

import br.org.ons.EssentialServices.model.ApplicationCapability;
import br.org.ons.EssentialServices.model.Function;
import br.org.ons.EssentialServices.model.iEntity;

/**
 * @author coichedid
 *
 */
public class ApplicationCapabilityEntityRepositoryImpl extends EntityRepositoryImpl implements iEntityRepository {

	/**
	 * 
	 */
	public ApplicationCapabilityEntityRepositoryImpl() {
		super();
		ownTags.put("nome","name");
		ownTags.put("descricao","description");
		
		inversedOwnTags = ownTags.inverse();
		
		LOGGER = Logger.getLogger(this.getClass()); 
	}

	/* (non-Javadoc)
	 * @see br.org.ons.EssentialServices.repository.iRepository#getEntitiesById(java.util.Collection)
	 */
	@Override
	public Collection<? extends iEntity> getEntitiesById(Collection<String> ids) throws Exception {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); 
	}

	/* (non-Javadoc)
	 * @see br.org.ons.EssentialServices.repository.iRepository#getEntityById(java.lang.String)
	 */
	@Override
	public iEntity getEntityById(String id) throws Exception {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException(); 
	}

	/* (non-Javadoc)
	 * @see br.org.ons.EssentialServices.repository.iRepository#getEntities(java.util.Collection)
	 */
	@Override
	public ArrayList<? extends iEntity> getEntities(Collection<Object> entityObjects) throws IllegalAccessException, InvocationTargetException {
		ArrayList<ApplicationCapability> applicationCapabilities = new ArrayList<ApplicationCapability>();
        
        ArrayList<String> slotList = getSimpleTags();
        
        Collection<HashMap<String,Object>> instances = arquiteturaRepository.getObjInstanceMaps(entityObjects, slotList);
        Iterator<HashMap<String,Object>> instancesI = instances.iterator();
        while (instancesI.hasNext()) {
            HashMap<String,Object> map = instancesI.next();
            HashMap<String,Object> translatedMap = translateProperties(map);
            ApplicationCapability applicationCapability = new ApplicationCapability();
            applicationCapability.updateProperties(translatedMap);
            
//            //Process Actors
//            Collection<Object> actors = arquiteturaRepository.getObjInstancesOfSlot("actToRoleFromActor",map);
//            stakeholder.setActor((Actor)actorRepository.getEntity(actors,0));
            
            applicationCapabilities.add(applicationCapability);
        }
        return applicationCapabilities;
	}

	@Override
	public ArrayList<? extends iEntity> getDistinctEntities(Collection<Object> entityObjects) throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
	
	@Override
	public iEntity saveEntity(iEntity entity) throws Exception {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
}
