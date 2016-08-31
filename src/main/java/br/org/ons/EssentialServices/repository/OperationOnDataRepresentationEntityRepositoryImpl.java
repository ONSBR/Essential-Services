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

import br.org.ons.EssentialServices.model.OperationOnDataRepresentation;
import br.org.ons.EssentialServices.model.UseOfInformationRepresentation;
import br.org.ons.EssentialServices.model.iEntity;

/**
 * @author coichedid
 *
 */
public class OperationOnDataRepresentationEntityRepositoryImpl extends EntityRepositoryImpl
		implements iEntityRepository {

	/**
	 * 
	 */
	public OperationOnDataRepresentationEntityRepositoryImpl() {
		super();
    	
    	ownTags.put("id","id");
		ownTags.put("dataRepresentation","appproToInforepToDatarepToDatarep");
		ownTags.put("created","appProCreatesDataRep");
		ownTags.put("read","appProReadsDataRep");
		ownTags.put("updated","appProUpdatesDataRep");
		ownTags.put("deleted","appProDeletesDataRep");
		ownTags.put("formaDeAquisicao","appProDataAcquisitionMethod");
		
		inversedOwnTags = ownTags.inverse();
		
		LOGGER = Logger.getLogger(this.getClass()); 
	}

	/* (non-Javadoc)
	 * @see br.org.ons.EssentialServices.repository.EntityRepositoryImpl#getEntitiesById(java.util.Collection)
	 */
	@Override
	public Collection<? extends iEntity> getEntitiesById(Collection<String> ids) throws Exception {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see br.org.ons.EssentialServices.repository.EntityRepositoryImpl#getEntityById(java.lang.String)
	 */
	@Override
	public iEntity getEntityById(String id) throws Exception {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see br.org.ons.EssentialServices.repository.EntityRepositoryImpl#getEntities(java.util.Collection)
	 */
	@Override
	public ArrayList<? extends iEntity> getEntities(Collection<Object> entityObjects) throws IllegalAccessException, InvocationTargetException {
		ArrayList<OperationOnDataRepresentation> operationsOnDataRepresentation = new ArrayList<>();
        
        ArrayList<String> slotList = getSimpleTags();
        
        Collection<HashMap<String,Object>> instances = arquiteturaRepository.getObjInstanceMaps(entityObjects, slotList);
        Iterator<HashMap<String,Object>> instancesI = instances.iterator();
        while (instancesI.hasNext()) {
            HashMap<String,Object> map = instancesI.next();
            HashMap<String,Object> translatedMap = translateProperties(map);
            
            OperationOnDataRepresentation operationOnDataRepresentation = new OperationOnDataRepresentation();
            operationOnDataRepresentation.updateProperties(translatedMap);
            
            operationsOnDataRepresentation.add(operationOnDataRepresentation);
        }
        return operationsOnDataRepresentation;
	}

	/* (non-Javadoc)
	 * @see br.org.ons.EssentialServices.repository.EntityRepositoryImpl#getDistinctEntities(java.util.Collection)
	 */
	@Override
	public ArrayList<? extends iEntity> getDistinctEntities(Collection<Object> entityObjects)
			throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

}
