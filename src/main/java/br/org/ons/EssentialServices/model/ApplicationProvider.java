package br.org.ons.EssentialServices.model;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import  org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import java.util.Map;
import java.util.Set;


public class ApplicationProvider implements iEntity {
    private static final HashMap<String,String> simpleTags ;
    
    static {
    		simpleTags = new HashMap<String,String>();
    		simpleTags.put("Nome","name");
    		simpleTags.put("Descricao","description");
    		simpleTags.put("Hospedagem","apDeliveryModel");
    		simpleTags.put("Id","id");
    		simpleTags.put("Status","lifecycleStatusApplicationProvider");
    		simpleTags.put("TipoDeAplicacao","typeOfApplication");
    		simpleTags.put("TipoDeProduto","apCodebaseStatus");
    		simpleTags.put("Fornecedor","apSupplier");
    		simpleTags.put("UsageLocations","apSiteAccess");
    		simpleTags.put("Propositos","applicationProviderPurpose");
    		simpleTags.put("TechCapsNeed","requiredTechnologyCapabilities");
    		simpleTags.put("Classifications","elementClassifiedBy");
    		simpleTags.put("Owner","apBusinessOwner");
    		simpleTags.put("ITOwner","apITOwner");
    		simpleTags.put("ITContact","apITContact");
    }

    private String id;
    private String name;
    private String description;
    private String apDeliveryModel;
    private String lifecycleStatusApplicationProvider;
    private String typeOfApplication;
    private String apCodebaseStatus;
    private String apSupplier;
    private Collection apSiteAccess;
    private Collection applicationProviderPurpose;
    private Collection requiredTechnologyCapabilities;
    private Collection elementClassifiedBy;
    private String apBusinessOwner;
    private String apITOwner;
    private String apITContact;


    public ApplicationProvider() {

    } 

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    /**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the apDeliveryModel
	 */
	public String getApDeliveryModel() {
		return apDeliveryModel;
	}

	/**
	 * @param apDeliveryModel the apDeliveryModel to set
	 */
	public void setApDeliveryModel(String apDeliveryModel) {
		this.apDeliveryModel = apDeliveryModel;
	}

	/**
	 * @return the lifecycleStatusApplicationProvider
	 */
	public String getLifecycleStatusApplicationProvider() {
		return lifecycleStatusApplicationProvider;
	}

	/**
	 * @param lifecycleStatusApplicationProvider the lifecycleStatusApplicationProvider to set
	 */
	public void setLifecycleStatusApplicationProvider(String lifecycleStatusApplicationProvider) {
		this.lifecycleStatusApplicationProvider = lifecycleStatusApplicationProvider;
	}

	/**
	 * @return the typeOfApplication
	 */
	public String getTypeOfApplication() {
		return typeOfApplication;
	}

	/**
	 * @param typeOfApplication the typeOfApplication to set
	 */
	public void setTypeOfApplication(String typeOfApplication) {
		this.typeOfApplication = typeOfApplication;
	}

	/**
	 * @return the apCodebaseStatus
	 */
	public String getApCodebaseStatus() {
		return apCodebaseStatus;
	}

	/**
	 * @param apCodebaseStatus the apCodebaseStatus to set
	 */
	public void setApCodebaseStatus(String apCodebaseStatus) {
		this.apCodebaseStatus = apCodebaseStatus;
	}

	/**
	 * @return the apSupplier
	 */
	public String getApSupplier() {
		return apSupplier;
	}

	/**
	 * @param apSupplier the apSupplier to set
	 */
	public void setApSupplier(String apSupplier) {
		this.apSupplier = apSupplier;
	}

	/**
	 * @return the apSiteAccess
	 */
	public Collection getApSiteAccess() {
		return apSiteAccess;
	}

	/**
	 * @param apSiteAccess the apSiteAccess to set
	 */
	public void setApSiteAccess(Collection apSiteAccess) {
		this.apSiteAccess = apSiteAccess;
	}

	/**
	 * @return the applicationProviderPurpose
	 */
	public Collection getApplicationProviderPurpose() {
		return applicationProviderPurpose;
	}

	/**
	 * @param applicationProviderPurpose the applicationProviderPurpose to set
	 */
	public void setApplicationProviderPurpose(Collection applicationProviderPurpose) {
		this.applicationProviderPurpose = applicationProviderPurpose;
	}

	/**
	 * @return the requiredTechnologyCapabilities
	 */
	public Collection getRequiredTechnologyCapabilities() {
		return requiredTechnologyCapabilities;
	}

	/**
	 * @param requiredTechnologyCapabilities the requiredTechnologyCapabilities to set
	 */
	public void setRequiredTechnologyCapabilities(Collection requiredTechnologyCapabilities) {
		this.requiredTechnologyCapabilities = requiredTechnologyCapabilities;
	}

	/**
	 * @return the elementClassifiedBy
	 */
	public Collection getElementClassifiedBy() {
		return elementClassifiedBy;
	}

	/**
	 * @param elementClassifiedBy the elementClassifiedBy to set
	 */
	public void setElementClassifiedBy(Collection elementClassifiedBy) {
		this.elementClassifiedBy = elementClassifiedBy;
	}

	/**
	 * @return the apBusinessOwner
	 */
	public String getApBusinessOwner() {
		return apBusinessOwner;
	}

	/**
	 * @param apBusinessOwner the apBusinessOwner to set
	 */
	public void setApBusinessOwner(String apBusinessOwner) {
		this.apBusinessOwner = apBusinessOwner;
	}

	/**
	 * @return the apITOwner
	 */
	public String getApITOwner() {
		return apITOwner;
	}

	/**
	 * @param apITOwner the apITOwner to set
	 */
	public void setApITOwner(String apITOwner) {
		this.apITOwner = apITOwner;
	}

	/**
	 * @return the apITContact
	 */
	public String getApITContact() {
		return apITContact;
	}

	/**
	 * @param apITContact the apITContact to set
	 */
	public void setApITContact(String apITContact) {
		this.apITContact = apITContact;
	}

	public static ArrayList<String> getSimpleTags() {
		Collection<String> values = simpleTags.values();
		ArrayList<String> simpleTagsList = new ArrayList<String>(values);
        return simpleTagsList;
    }

    public Map<String,Object> toHashMap() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Map<String,Object> map = PropertyUtils.describe(this);
        Map<String,Object> hashMap = new HashMap<String,Object>();
        
        Iterator<Map.Entry<String,String>> translations = simpleTags.entrySet().iterator();
        
        while (translations.hasNext()) {
        		Map.Entry<String, String> kV = translations.next();
        		hashMap.put(kV.getKey(), map.get(kV.getValue()));
        }
        
        return hashMap;
    }
    
    public void updateProperties(HashMap<String,Object> properties) throws IllegalAccessException, InvocationTargetException {
    		BeanUtils.populate(this, properties);
    }
}