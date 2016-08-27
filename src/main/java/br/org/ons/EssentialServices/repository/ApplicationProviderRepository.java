package br.org.ons.EssentialServices.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;

import br.org.ons.EssentialServices.model.ApplicationProvider;
import br.org.ons.EssentialServices.model.iEntity;
import br.org.ons.EssentialServices.repository.server.EssentialRepository;

public class ApplicationProviderRepository extends EntityRepository {
	static final Logger LOGGER = Logger.getLogger(ApplicationProviderRepository.class); 
    
    
	
	
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

    public Collection<iEntity> getSimpleApplicationProviders() throws Exception{
        Collection<iEntity> applicationProviders = new ArrayList<iEntity>();
//        EssentialRepository essential = new EssentialRepository(essentialProjectPath); 
        
        ArrayList<String> slotList = getSimpleTags();
        
        Collection<HashMap<String,Object>> instances = arquiteturaRepository.getObjInstances("Application_Provider", slotList);
//        Collection<HashMap<String,Object>> instances = essential.getObjInstances("Application_Provider", slotList);
        Iterator<HashMap<String,Object>> instancesI = instances.iterator();
        while (instancesI.hasNext()) {
            HashMap<String,Object> map = instancesI.next();
            HashMap<String,Object> translatedMap = translateProperties(map);
            ApplicationProvider applicationProvider = new ApplicationProvider();
            applicationProvider.updateProperties(translatedMap);
            applicationProviders.add(applicationProvider);
        }
        return applicationProviders;
    }
}