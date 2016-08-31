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
import br.org.ons.EssentialServices.model.FunctionImplementation;
import br.org.ons.EssentialServices.model.iEntity;

/**
 * @author coichedid
 *
 */
public class FunctionEntityRepositoryImpl extends EntityRepositoryImpl implements iEntityRepository {
	
	private iEntityRepository applicationCapabilityRepository;

	/**
	 * 
	 */
	public FunctionEntityRepositoryImpl() {
		super();
		ownTags.put("nome","name");
		ownTags.put("descricao","description");
		ownTags.put("behavior","applicationFunctionBehaviour");
		
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
	
	@Override
	public ArrayList<? extends iEntity> getDistinctEntities(Collection<Object> entityObjects) throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
	 * @return the applicationCapabilityRepository
	 */
	public iEntityRepository getApplicationCapabilityRepository() {
		return applicationCapabilityRepository;
	}

	/**
	 * @param applicationCapabilityRepository the applicationCapabilityRepository to set
	 */
	public void setApplicationCapabilityRepository(iEntityRepository applicationCapabilityRepository) {
		this.applicationCapabilityRepository = applicationCapabilityRepository;
	}

}
