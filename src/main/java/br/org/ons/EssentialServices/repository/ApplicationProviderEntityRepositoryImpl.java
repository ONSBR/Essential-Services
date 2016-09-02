package br.org.ons.EssentialServices.repository;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

import br.org.ons.EssentialServices.model.ApplicationProvider;
import br.org.ons.EssentialServices.model.ApplicationService;
import br.org.ons.EssentialServices.model.FunctionImplementation;
import br.org.ons.EssentialServices.model.SoftwareComponent;
import br.org.ons.EssentialServices.model.Stakeholder;
import br.org.ons.EssentialServices.model.UseOfInformationRepresentation;
import br.org.ons.EssentialServices.model.iEntity;

public class ApplicationProviderEntityRepositoryImpl extends EntityRepositoryImpl implements iEntityRepository {
	
    
    //Composite repositories
	private iEntityRepository stakeholderRepository;
    private iEntityRepository functionImplementationRepository;
    private iEntityRepository softwareComponentRepository;
    private iEntityRepository applicationServiceRepository;
    private iEntityRepository useOfInformationRepresentationRepository;
    
    public ApplicationProviderEntityRepositoryImpl() {
    	super();
    	
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
		ownTags.put("itOwner","apITOwner");
		ownTags.put("itContact","apITContact");
		
		inversedOwnTags = ownTags.inverse();
		
		LOGGER = Logger.getLogger(this.getClass()); 
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
	public ArrayList<? extends iEntity> getEntities(Collection<Object> entityObjects) throws IllegalAccessException, InvocationTargetException {
		ArrayList<ApplicationProvider> applicationProviders = new ArrayList<ApplicationProvider>();
        
        ArrayList<String> slotList = getSimpleTags();
//        slotList.add("stakeholders");
        
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
            
            //Process SoftwareComponents
            Collection<Object> softwareComponents = arquiteturaRepository.getObjInstancesOfSlot("inverse_of_delivers_app_func_impl", functionImplementations);
            ArrayList<SoftwareComponent> softwareComponentList = (ArrayList<SoftwareComponent>)softwareComponentRepository.getDistinctEntities(softwareComponents);
            applicationProvider.setSoftwareComponents(softwareComponentList);
            
            //Process ApplicationServices
            Collection<Object> applicationServices = arquiteturaRepository.getObjInstancesOfSlot("provides_application_services", map);
            ArrayList<ApplicationService> applicationServiceList = (ArrayList<ApplicationService>) applicationServiceRepository.getEntities(applicationServices);
            applicationProvider.setApplicationServices(applicationServiceList);
            
            //Process Uses of Information Representation
            Collection<Object> usesOfInformationRepresentation = arquiteturaRepository.getObjInstancesOfSlot("uses_information_representation", map);
            ArrayList<UseOfInformationRepresentation> useOfInformationRepresentationList = (ArrayList<UseOfInformationRepresentation>) useOfInformationRepresentationRepository.getEntities(usesOfInformationRepresentation);
            applicationProvider.setUsesInformations(useOfInformationRepresentationList);
            
            applicationProviders.add(applicationProvider);
        }
        return applicationProviders;
	}
	
	@Override
	public ArrayList<? extends iEntity> getDistinctEntities(Collection<Object> entityObjects) throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();
	}
	
	/**
	 * @return the functionImplementationRepository
	 */
	public iEntityRepository getFunctionImplementationRepository() {
		return functionImplementationRepository;
	}

	/**
	 * @param functionImplementationRepository the functionImplementationRepository to set
	 */
	public void setFunctionImplementationRepository(iEntityRepository functionImplementationRepository) {
		this.functionImplementationRepository = functionImplementationRepository;
	}
	
	/**
	 * @return the stakeholderRepository
	 */
	public iEntityRepository getStakeholderRepository() {
		return stakeholderRepository;
	}

	/**
	 * @param stakeholderRepository the stakeholderRepository to set
	 */
	public void setStakeholderRepository(iEntityRepository stakeholderRepository) {
		this.stakeholderRepository = stakeholderRepository;
	}

	/**
	 * @return the softwareComponentRepository
	 */
	public iEntityRepository getSoftwareComponentRepository() {
		return softwareComponentRepository;
	}

	/**
	 * @param softwareComponentRepository the softwareComponentRepository to set
	 */
	public void setSoftwareComponentRepository(iEntityRepository softwareComponentRepository) {
		this.softwareComponentRepository = softwareComponentRepository;
	}

	/**
	 * @return the applicationServiceRepository
	 */
	public iEntityRepository getApplicationServiceRepository() {
		return applicationServiceRepository;
	}

	/**
	 * @param applicationServiceRepository the applicationServiceRepository to set
	 */
	public void setApplicationServiceRepository(iEntityRepository applicationServiceRepository) {
		this.applicationServiceRepository = applicationServiceRepository;
	}

	/**
	 * @return the useOfInformationRepresentationRepository
	 */
	public iEntityRepository getUseOfInformationRepresentationRepository() {
		return useOfInformationRepresentationRepository;
	}

	/**
	 * @param useOfInformationRepresentationRepository the useOfInformationRepresentationRepository to set
	 */
	public void setUseOfInformationRepresentationRepository(iEntityRepository useOfInformationRepresentationRepository) {
		this.useOfInformationRepresentationRepository = useOfInformationRepresentationRepository;
	}

	@Override
	public iEntity saveEntity(iEntity entity) throws Exception {
		LOGGER.debug("Save Entity");
		ApplicationProvider applicationProvider = (ApplicationProvider) entity;
		
		Map<String,Object> map = applicationProvider.toHashMap();
		LOGGER.debug("Application map size " + map.size());
		Map<String,Object> ownAttributes = getEntityOwnAttributes(map);
		LOGGER.debug("Application ownAttributes size " + ownAttributes.size());
		//Removing Id from attributes: this is not valid at Essential Metamodel
		ownAttributes.remove("id");

		Map<String,Object> savedEntityMap = arquiteturaRepository.saveObjInstance(entityClass, applicationProvider.getId(), applicationProvider.getNome(), ownAttributes);
		return entity;
	}
}