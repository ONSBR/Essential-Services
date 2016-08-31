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

import br.org.ons.EssentialServices.model.ApplicationService;
import br.org.ons.EssentialServices.model.OperationOnDataRepresentation;
import br.org.ons.EssentialServices.model.UseOfInformationRepresentation;
import br.org.ons.EssentialServices.model.iEntity;

/**
 * @author coichedid
 *
 */
public class UseOfInformationRepresentationEntityRepositoryImpl extends EntityRepositoryImpl implements iEntityRepository {

	private iEntityRepository operationOnDataRepresentationEntityRepository;
	/**
	 * 
	 */
	public UseOfInformationRepresentationEntityRepositoryImpl() {
		super();
    	
    	ownTags.put("id","id");
		ownTags.put("informationUsed","appProToInforepToInforep");
		ownTags.put("created","appProCreatesInfoRep");
		ownTags.put("read","appProReadsInfoRep");
		ownTags.put("updated","appProUpdatesInfoRep");
		ownTags.put("deleted","appProDeletesInfoRep");
		ownTags.put("persisted","appProPersistsInfoRep");
		
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
		ArrayList<UseOfInformationRepresentation> usesOfInformationRepresentation = new ArrayList<>();
        
        ArrayList<String> slotList = getSimpleTags();
        
        Collection<HashMap<String,Object>> instances = arquiteturaRepository.getObjInstanceMaps(entityObjects, slotList);
        Iterator<HashMap<String,Object>> instancesI = instances.iterator();
        while (instancesI.hasNext()) {
            HashMap<String,Object> map = instancesI.next();
            HashMap<String,Object> translatedMap = translateProperties(map);
            
            UseOfInformationRepresentation useOfInformationRepresentation = new UseOfInformationRepresentation();
            useOfInformationRepresentation.updateProperties(translatedMap);
            
           //Process Operations on Data
            Collection<Object> operationsOnDataRepresentation = arquiteturaRepository.getObjInstancesOfSlot("operated_data_reps", map);
            ArrayList<OperationOnDataRepresentation> operationOnDataRepresentationList = (ArrayList<OperationOnDataRepresentation>) operationOnDataRepresentationEntityRepository.getEntities(operationsOnDataRepresentation);
            useOfInformationRepresentation.setDataOperated(operationOnDataRepresentationList);
            
            usesOfInformationRepresentation.add(useOfInformationRepresentation);
        }
        return usesOfInformationRepresentation;
	}

	/* (non-Javadoc)
	 * @see br.org.ons.EssentialServices.repository.EntityRepositoryImpl#getDistinctEntities(java.util.Collection)
	 */
	@Override
	public ArrayList<? extends iEntity> getDistinctEntities(Collection<Object> entityObjects) throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
	 * @return the operationOnDataEntityRepository
	 */
	public iEntityRepository getOperationOnDataRepresentationEntityRepository() {
		return operationOnDataRepresentationEntityRepository;
	}

	/**
	 * @param operationOnDataEntityRepository the operationOnDataEntityRepository to set
	 */
	public void setOperationOnDataRepresentationEntityRepository(iEntityRepository operationOnDataRepresentationEntityRepository) {
		this.operationOnDataRepresentationEntityRepository = operationOnDataRepresentationEntityRepository;
	}

}
