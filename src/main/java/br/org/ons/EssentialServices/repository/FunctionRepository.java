/**
 * 
 */
package br.org.ons.EssentialServices.repository;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import br.org.ons.EssentialServices.model.ApplicationCapability;
import br.org.ons.EssentialServices.model.Function;
import br.org.ons.EssentialServices.model.FunctionImplementation;
import br.org.ons.EssentialServices.model.iEntity;

/**
 * @author coichedid
 *
 */
public class FunctionRepository extends EntityRepository implements iRepository {
	
	private ApplicationCapabilityRepository applicationCapabilityRepository;

	/**
	 * 
	 */
	public FunctionRepository() {
		ownTags.put("nome","name");
		ownTags.put("descricao","description");
		ownTags.put("behavior","applicationFunctionBehaviour");
		
		inversedOwnTags = ownTags.inverse();
	}

	/* (non-Javadoc)
	 * @see br.org.ons.EssentialServices.repository.iRepository#getSimpleEntities()
	 */
	@Override
	public Collection<? extends iEntity> getSimpleEntities() throws Exception {
		Collection<Object> intancesObj = arquiteturaRepository.getObjInstances("Application_Function");
		ArrayList<? extends iEntity> functions = getEntities(intancesObj);
		return functions;
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
		ArrayList<Function> functions = new ArrayList<Function>();
        
        ArrayList<String> slotList = getSimpleTags();
        
        Collection<HashMap<String,Object>> instances = arquiteturaRepository.getObjInstanceMaps(entityObjects, slotList);
        Iterator<HashMap<String,Object>> instancesI = instances.iterator();
        while (instancesI.hasNext()) {
            HashMap<String,Object> map = instancesI.next();
            HashMap<String,Object> translatedMap = translateProperties(map);
            Function function = new Function();
            function.updateProperties(translatedMap);
            
            //Process Application Capabilities
            Collection<Object> capabilities = arquiteturaRepository.getObjInstancesOfSlot("typeOfApplicationCapability",map);
            function.setApplicationCap((ApplicationCapability)applicationCapabilityRepository.getEntity(capabilities,0));
            
            functions.add(function);
        }
        return functions;
	}

	/* (non-Javadoc)
	 * @see br.org.ons.EssentialServices.repository.iRepository#getEntity(java.util.Collection, int)
	 */
	@Override
	public iEntity getEntity(Collection<Object> entityObjects, int idx) throws IllegalAccessException, InvocationTargetException {
		ArrayList<? extends iEntity> entities = getEntities(entityObjects);
		return entities.size() >= idx+1?entities.get(idx):null;
	}

	/**
	 * @return the applicationCapabilityRepository
	 */
	public ApplicationCapabilityRepository getApplicationCapabilityRepository() {
		return applicationCapabilityRepository;
	}

	/**
	 * @param applicationCapabilityRepository the applicationCapabilityRepository to set
	 */
	public void setApplicationCapabilityRepository(ApplicationCapabilityRepository applicationCapabilityRepository) {
		this.applicationCapabilityRepository = applicationCapabilityRepository;
	}

}
