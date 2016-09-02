/**
 * 
 */
package br.org.ons.EssentialServices.repository;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import br.org.ons.EssentialServices.model.SoftwareComponent;
import br.org.ons.EssentialServices.model.iEntity;

/**
 * @author coichedid
 *
 */
public class SoftwareComponentEntityRepositoryImpl extends EntityRepositoryImpl implements iEntityRepository {

	/**
	 * 
	 */
	public SoftwareComponentEntityRepositoryImpl() {
		super();
		
		ownTags.put("id","id");
		ownTags.put("nome","name");
		ownTags.put("archLayer","softwareArchitectureLayer");
		ownTags.put("protocolo","softwareInteractionTechProtocol");
		
		inversedOwnTags = ownTags.inverse();
		
		LOGGER = Logger.getLogger(this.getClass()); 
	}

	/* (non-Javadoc)
	 * @see br.org.ons.EssentialServices.repository.EntityRepository#getEntitiesById(java.util.Collection)
	 */
	@Override
	public Collection<? extends iEntity> getEntitiesById(Collection<String> ids) throws Exception {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see br.org.ons.EssentialServices.repository.EntityRepository#getEntityById(java.lang.String)
	 */
	@Override
	public iEntity getEntityById(String id) throws Exception {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see br.org.ons.EssentialServices.repository.EntityRepository#getEntities(java.util.Collection)
	 */
	@Override
	public ArrayList<? extends iEntity> getEntities(Collection<Object> entityObjects) throws IllegalAccessException, InvocationTargetException {
		ArrayList<SoftwareComponent> softwareComponents = new ArrayList<>();
        
        ArrayList<String> slotList = getSimpleTags();
        
        Collection<HashMap<String,Object>> instances = arquiteturaRepository.getObjInstanceMaps(entityObjects, slotList);
        Iterator<HashMap<String,Object>> instancesI = instances.iterator();
        while (instancesI.hasNext()) {
            HashMap<String,Object> map = instancesI.next();
            HashMap<String,Object> translatedMap = translateProperties(map);
            
            SoftwareComponent softwareComponent = new SoftwareComponent();
            softwareComponent.updateProperties(translatedMap);
            
            softwareComponents.add(softwareComponent);
        }
        return softwareComponents;
	}
	
	@Override
	public ArrayList<? extends iEntity> getDistinctEntities(Collection<Object> entityObjects) throws IllegalAccessException, InvocationTargetException {
		ArrayList<SoftwareComponent> softwareComponents = new ArrayList<>();
        
        List<String> slotList = getSimpleTags();
        
        Map<String,HashMap<String,Object>> instances = arquiteturaRepository.getDistinctObjInstanceMaps(entityObjects, slotList);
        Iterator<Map.Entry<String,HashMap<String,Object>>> instancesI = instances.entrySet().iterator();
        while (instancesI.hasNext()) {
            HashMap<String,Object> map = instancesI.next().getValue();
            HashMap<String,Object> translatedMap = translateProperties(map);
            
            SoftwareComponent softwareComponent = new SoftwareComponent();
            softwareComponent.updateProperties(translatedMap);
            
            softwareComponents.add(softwareComponent);
        }
        return softwareComponents;
	}
	
	@Override
	public iEntity saveEntity(iEntity entity) throws Exception {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
