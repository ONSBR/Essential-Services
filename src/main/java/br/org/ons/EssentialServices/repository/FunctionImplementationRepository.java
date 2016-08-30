/**
 * 
 */
package br.org.ons.EssentialServices.repository;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import br.org.ons.EssentialServices.model.Actor;
import br.org.ons.EssentialServices.model.ApplicationProvider;
import br.org.ons.EssentialServices.model.Function;
import br.org.ons.EssentialServices.model.FunctionImplementation;
import br.org.ons.EssentialServices.model.Stakeholder;
import br.org.ons.EssentialServices.model.iEntity;

/**
 * @author coichedid
 *
 */
public class FunctionImplementationRepository extends EntityRepository implements iRepository {
	
	private FunctionRepository functionRepository;

	/**
	 * 
	 */
	public FunctionImplementationRepository() {
		ownTags.put("id","id");
		ownTags.put("nome","name");
		ownTags.put("descricao","description");
		ownTags.put("softwareComponent","inverseOfDeliversAppFuncImpl");
		ownTags.put("protocolo","appFuncImplProtocol");
		ownTags.put("informationUsed","usesInformationRepresentation");
		
		inversedOwnTags = ownTags.inverse();
	}

	@Override
	public Collection<? extends iEntity> getSimpleEntities() throws Exception {
		Collection<Object> intancesObj = arquiteturaRepository.getObjInstances("Application_Function_Implementation");
		ArrayList<? extends iEntity> functionImplementations = getEntities(intancesObj);
		return functionImplementations;
	}
	
	@Override
	public ArrayList<? extends iEntity> getEntities(Collection<Object> entityObjects) throws IllegalAccessException, InvocationTargetException {
		ArrayList<FunctionImplementation> functionImplementations = new ArrayList<FunctionImplementation>();
        
        ArrayList<String> slotList = getSimpleTags();
        
        Collection<HashMap<String,Object>> instances = arquiteturaRepository.getObjInstanceMaps(entityObjects, slotList);
        Iterator<HashMap<String,Object>> instancesI = instances.iterator();
        while (instancesI.hasNext()) {
            HashMap<String,Object> map = instancesI.next();
            HashMap<String,Object> translatedMap = translateProperties(map);
            FunctionImplementation functionImplementation = new FunctionImplementation();
            functionImplementation.updateProperties(translatedMap);
            
            //Process Functions
            Collection<Object> functions = arquiteturaRepository.getObjInstancesOfSlot("implementsApplicationFunction",map);
            functionImplementation.setFunction((Function)functionRepository.getEntity(functions,0));
            
            functionImplementations.add(functionImplementation);
        }
        return functionImplementations;
	}

	@Override
	public Collection<? extends iEntity> getEntitiesById(Collection<String> ids) throws Exception {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public iEntity getEntityById(String id) throws Exception {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	@Override
	public iEntity getEntity(Collection<Object> entityObjects, int idx)
			throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}

	/**
	 * @return the functionRepository
	 */
	public FunctionRepository getFunctionRepository() {
		return functionRepository;
	}

	/**
	 * @param functionRepository the functionRepository to set
	 */
	public void setFunctionRepository(FunctionRepository functionRepository) {
		this.functionRepository = functionRepository;
	}

}
