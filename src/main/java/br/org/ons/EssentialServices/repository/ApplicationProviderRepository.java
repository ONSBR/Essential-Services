package br.org.ons.EssentialServices.repository;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;

import br.org.ons.EssentialServices.model.Actor;
import br.org.ons.EssentialServices.model.ApplicationProvider;
import br.org.ons.EssentialServices.model.FunctionImplementation;
import br.org.ons.EssentialServices.model.Stakeholder;
import br.org.ons.EssentialServices.model.iEntity;

public class ApplicationProviderRepository extends EntityRepository implements iRepository {
	static final Logger LOGGER = Logger.getLogger(ApplicationProviderRepository.class); 
    
    //Composite repositories
	private StakeholderRepository stakeholderRepository;
    private FunctionImplementationRepository functionImplementationRepository;
    
    public ApplicationProviderRepository() {
    	ownTags.put("id","id");
		ownTags.put("nome","name");
		ownTags.put("descricao","description");
		ownTags.put("hospedagem","apDeliveryModel");
		ownTags.put("status","lifecycleStatusApplicationProvider");
		ownTags.put("tipoDeAplicacao","typeOfApplication");
		ownTags.put("tipoDeProduto","apCodebaseStatus");
		ownTags.put("fornecedor","apSupplier");
		ownTags.put("usageLocations","apSiteAccess");
		ownTags.put("propositos","applicationProviderPurpose");
		ownTags.put("techCapsNeed","requiredTechnologyCapabilities");
		ownTags.put("classifications","elementClassifiedBy");
		ownTags.put("owner","apBusinessOwner");
		ownTags.put("ITOwner","apITOwner");
		ownTags.put("ITContact","apITContact");
		
		inversedOwnTags = ownTags.inverse();
    }



	@Override
	public Collection<? extends iEntity> getSimpleEntities() throws Exception{
		Collection<Object> intancesObj = arquiteturaRepository.getObjInstances("Application_Provider");
		ArrayList<? extends iEntity> applicationProviders = getEntities(intancesObj);
		return applicationProviders;
//        Collection<iEntity> applicationProviders = new ArrayList<iEntity>();
//        
//        ArrayList<String> slotList = getSimpleTags();
//        slotList.add("stakeholders");
//        
//        Collection<HashMap<String,Object>> instances = arquiteturaRepository.getObjInstanceMaps("Application_Provider", slotList);
//        Iterator<HashMap<String,Object>> instancesI = instances.iterator();
//        while (instancesI.hasNext()) {
//            HashMap<String,Object> map = instancesI.next();
//            HashMap<String,Object> translatedMap = translateProperties(map);
//            ApplicationProvider applicationProvider = new ApplicationProvider();
//            applicationProvider.updateProperties(translatedMap);
//            
//            //Process Stakeholders
//            Collection<Object> stakeholders = arquiteturaRepository.getObjInstancesOfSlot("stakeholders",map);
//            ArrayList<Stakeholder> stakeholdersList = (ArrayList<Stakeholder>) stakeholderRepository.getEntities(stakeholders);
//            applicationProvider.setStakeholders(stakeholdersList);
//            
//            applicationProviders.add(applicationProvider);
//        }
//        return applicationProviders;
    }
	
	@Override
	public ArrayList<? extends iEntity> getEntities(Collection<Object> entityObjects) throws IllegalAccessException, InvocationTargetException {
		ArrayList<ApplicationProvider> applicationProviders = new ArrayList<ApplicationProvider>();
        
        ArrayList<String> slotList = getSimpleTags();
        slotList.add("stakeholders");
        
        Collection<HashMap<String,Object>> instances = arquiteturaRepository.getObjInstanceMaps(entityObjects, slotList);
        Iterator<HashMap<String,Object>> instancesI = instances.iterator();
        while (instancesI.hasNext()) {
            HashMap<String,Object> map = instancesI.next();
            HashMap<String,Object> translatedMap = translateProperties(map);
            ApplicationProvider applicationProvider = new ApplicationProvider();
            applicationProvider.updateProperties(translatedMap);
            
            //Process Stakeholders
            Collection<Object> stakeholders = arquiteturaRepository.getObjInstancesOfSlot("stakeholders",map);
            ArrayList<Stakeholder> stakeholdersList = (ArrayList<Stakeholder>) stakeholderRepository.getEntities(stakeholders);
            applicationProvider.setStakeholders(stakeholdersList);
            
            //Process FunctionImplementations
            Collection<Object> functionImplementations = arquiteturaRepository.getObjInstancesOfSlot("provides_application_function_implementations", map);
            ArrayList<FunctionImplementation> functionImplementationList = (ArrayList<FunctionImplementation>) functionImplementationRepository.getEntities(functionImplementations);
            applicationProvider.setFunctionImpls(functionImplementationList);
            
            applicationProviders.add(applicationProvider);
        }
        return applicationProviders;
	}

	/**
	 * @return the stakeholderRepository
	 */
	public StakeholderRepository getStakeholderRepository() {
		return stakeholderRepository;
	}

	/**
	 * @param stakeholderRepository the stakeholderRepository to set
	 */
	public void setStakeholderRepository(StakeholderRepository stakeholderRepository) {
		this.stakeholderRepository = stakeholderRepository;
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
	public iEntity getEntity(Collection<Object> entityObjects, int idx) throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}



	/**
	 * @return the functionImplementationRepository
	 */
	public FunctionImplementationRepository getFunctionImplementationRepository() {
		return functionImplementationRepository;
	}



	/**
	 * @param functionImplementationRepository the functionImplementationRepository to set
	 */
	public void setFunctionImplementationRepository(FunctionImplementationRepository functionImplementationRepository) {
		this.functionImplementationRepository = functionImplementationRepository;
	}
}