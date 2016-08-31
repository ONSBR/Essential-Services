/**
 * 
 */
package br.org.ons.EssentialServices.repository.server;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.common.base.CaseFormat;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import edu.stanford.smi.protege.model.Cls;
import edu.stanford.smi.protege.model.Instance;
import edu.stanford.smi.protege.model.KnowledgeBase;
import edu.stanford.smi.protege.model.Project;
import edu.stanford.smi.protege.model.Slot;

/**
 * @author coichedid
 *
 */
public class ArquiteturaCorporativaONSRepositoryImpl implements  ArquiteturaCorporativaONSRepository {
	private static final BiMap<String,String> exceptions;
    static {
    		exceptions = HashBiMap.create();
    		exceptions.put("apITOwner","ap_IT_owner");
    		exceptions.put("apITContact","ap_IT_contact");
    }
	
	static final Logger LOGGER = Logger.getLogger(ArquiteturaCorporativaONSRepositoryImpl.class); 
    private String projectPath;
    private Project project;
    private KnowledgeBase kb;
    private String externalRepositoryName;
    private Instance externalRepositoryInstance;

    private static class ReferencedInstance {
        public Instance instance;
        public Instance reference;
    }

    public static class ValueAttribute {
        public String attributeType;
        public Object value;
        public ValueAttribute(String t, Object v) {
            this.attributeType = t;
            this.value = v;
        }
    }

    public ArquiteturaCorporativaONSRepositoryImpl() {
        
    }
    
    public void init() throws Exception{
    	LOGGER.debug("Initializing repository...");
    	checkConnectivity();
    }
    
    public void destroy() throws Exception{
    	project.dispose();
    }
    
    @Override
    public Collection<Object> getObjInstances(String className) {
      Cls cls = kb.getCls(className); 
      Collection<Instance> instanceObjs = cls.getDirectInstances();
      Collection<Object> intances = new ArrayList<>();
      intances.addAll(instanceObjs);
      return intances;
    }

    /* (non-Javadoc)
	 * @see br.org.ons.EssentialServices.repository.server.ArquiteturaCorporativaONS#getObjInstances(java.lang.String, java.util.ArrayList)
	 */
    @Override
	public Collection<HashMap<String,Object>> getObjInstanceMaps(String className, ArrayList<String> slotList) {
//    	try {
//			checkConnectivity();
//		} catch (Exception e) {
//			return null;
//		}
//        Collection<Slot> slots = new ArrayList<Slot>();
//        Collection<HashMap<String,Object>> instances = new ArrayList<HashMap<String,Object>>();
//        Iterator<String> slotListI = slotList.iterator();
//        while (slotListI.hasNext()) {
//            String key = slotListI.next();
//            String keyConv = convertFormat(key, 1);
//            Slot sl = kb.getSlot(keyConv);
//            if (sl != null){
//            		slots.add(sl);
//            }
//        }
//        Cls cls = kb.getCls(className); 
//        Iterator instancesI = cls.getDirectInstances().iterator();
//        while (instancesI.hasNext()) {
//            Instance instance = (Instance) instancesI.next();
//            HashMap<String,Object> inst = getInstanceHashMap(instance,slots);
//            instances.add(inst);
//        }
//        
//        return instances;
    	Collection<Object> intanceObjs = getObjInstances(className);
    	Collection<HashMap<String,Object>> instances = getObjInstanceMaps(intanceObjs, slotList);
    	return instances;
    }
    
    @Override
	public Collection<HashMap<String, Object>> getObjInstanceMaps(Collection<Object> instancesObjects, ArrayList<String> slotList) {
    	try {
			checkConnectivity();
		} catch (Exception e) {
			return null;
		}
        Collection<Slot> slots = new ArrayList<Slot>();
        Collection<HashMap<String,Object>> instances = new ArrayList<HashMap<String,Object>>();
        Iterator<String> slotListI = slotList.iterator();
        while (slotListI.hasNext()) {
            String key = slotListI.next();
            String keyConv = convertFormat(key, 1);
            Slot sl = kb.getSlot(keyConv);
            if (sl != null){
            		slots.add(sl);
            }
        }
        Iterator instancesI = instancesObjects.iterator();
        while (instancesI.hasNext()) {
            Instance instance = (Instance) instancesI.next();
            HashMap<String,Object> inst = getInstanceHashMap(instance,slots);
            instances.add(inst);
        }
        
        return instances;
	}
    
    @Override
	public HashMap<String,HashMap<String, Object>> getDistinctObjInstanceMaps(Collection<Object> instancesObjects, ArrayList<String> slotList) {
    	try {
			checkConnectivity();
		} catch (Exception e) {
			return null;
		}
        Collection<Slot> slots = new ArrayList<Slot>();
        Slot slotName = kb.getSlot("name");
        HashMap<String,HashMap<String,Object>> instances = new HashMap<>();
        Iterator<String> slotListI = slotList.iterator();
        while (slotListI.hasNext()) {
            String key = slotListI.next();
            String keyConv = convertFormat(key, 1);
            Slot sl = kb.getSlot(keyConv);
            if (sl != null){
            		slots.add(sl);
            }
        }
        Iterator instancesI = instancesObjects.iterator();
        while (instancesI.hasNext()) {
            Instance instance = (Instance) instancesI.next();
            String name = (String)instance.getOwnSlotValue(slotName);
            HashMap<String,Object> inst = getInstanceHashMap(instance,slots);
            instances.put(name,inst);
        }
        
        return instances;
	}

    /* (non-Javadoc)
	 * @see br.org.ons.EssentialServices.repository.server.ArquiteturaCorporativaONS#setExternalRepositoryName(java.lang.String)
	 */
    @Override
	public void setExternalRepositoryName(String repositoryName) {
        boolean found = false;
        externalRepositoryName = repositoryName;
        Iterator<Instance> repositoryI = kb.getCls("External_Repository").getDirectInstances().iterator();
        while (repositoryI.hasNext() && !found) {
            Instance repository = repositoryI.next();
            if (repository.getDirectOwnSlotValue(kb.getSlot("name")) == repositoryName) {
                externalRepositoryInstance = repository;
                found = true;
            }
        }
        if (!found) {
            Instance newRepository = kb.createInstance(null,kb.getCls("External_Repository"));
            newRepository.setOwnSlotValue(kb.getSlot("name"),repositoryName);
            newRepository.setOwnSlotValue(kb.getSlot("description"),repositoryName);
            externalRepositoryInstance = newRepository;
        }
    }

    /* (non-Javadoc)
	 * @see br.org.ons.EssentialServices.repository.server.ArquiteturaCorporativaONS#saveObjInstance(java.lang.String, java.lang.String, java.lang.String, java.util.HashMap)
	 */
    @Override
	public HashMap<String,Object> saveObjInstance(String className, String refId, String instanceName, HashMap<String,Object> ownAttributes) {
    	ArquiteturaCorporativaONSRepositoryImpl.ReferencedInstance refInstance = saveInstance(className,refId,instanceName,ownAttributes);
        return getInstanceHashMap(refInstance.instance);
    }
    
    private void checkConnectivity() throws Exception{
    	if (this.project == null || this.project.getKnowledgeBase() == null ) {
    		openProject();
    	}
    }
    
    private void openProject() throws Exception {
    	Collection errors = new ArrayList();
        this.project = new Project(this.projectPath, errors);
        if (errors.size() == 0) {
            this.kb = project.getKnowledgeBase();
        }
        else {
            String errorsStr = displayErrors(errors);
            throw new Exception(errorsStr);
        }
    }

    private HashMap<String,Object> getInstanceHashMap(Instance instance) {
        Collection<Slot> slots = instance.getOwnSlots();
        return getInstanceHashMap(instance,slots);
    }
    
    private String convertFormat(String str,  int direction) {
    		if (direction == -1) {
    			if (exceptions.containsValue(str)){
    				return exceptions.inverse().get(str);
    			}
    			return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, str);
    		}
    		else if (direction == 1) {
    			if (exceptions.containsKey(str)) {
    				return exceptions.get(str);
    			}
    			return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str);
    		}
    		
    		return str;
    }

    private HashMap<String,Object> getInstanceHashMap(Instance instance, Collection<Slot> slots) {
        HashMap<String,Object> hashMap = new HashMap<String, Object>();
        hashMap.put("id",instance.getName());
        hashMap.put("_instance", instance);
        Iterator<Slot> slotsI = slots.iterator();
        while (slotsI.hasNext()) {
            Slot slot = slotsI.next();
            String slotNameUnderScore = slot.getName();
            String slotName = convertFormat(slotNameUnderScore,-1);
            String slotType = slot.getValueType().toString().toLowerCase();
            Object valueToAdd;
            if (slot.getAllowsMultipleValues()) { //That's a collection
                Collection list = new ArrayList();
                Iterator valuesI = instance.getDirectOwnSlotValues(slot).iterator();
                while (valuesI.hasNext()) {
                    Object value = valuesI.next();
                    list.add(getInstanceSlotValue(slotType,value));
                }
                valueToAdd = list;
            }
            else {
                Object value = instance.getDirectOwnSlotValue(slot);
                valueToAdd = getInstanceSlotValue(slotType,value);
            }
            hashMap.put(slotName,valueToAdd);
        }
        return hashMap;
    }

    private Object getInstanceSlotValue(String slotType, Object value) {
        Object v = value;
        if ("instance".equals(slotType) && value != null) {
            // Instance containedInstance = getInstanceById((String) value);
            String name = getNameSlot((Instance)value);
            v = ((Instance)value).getDirectOwnSlotValue(kb.getSlot(name));
        }
        return v;
    }

    private ArquiteturaCorporativaONSRepositoryImpl.ReferencedInstance saveInstance(String className, String refId, String instanceName, HashMap<String,Object> ownAttributes) {
        Slot externalUpdateDate = kb.getSlot("external_update_date");
        ArquiteturaCorporativaONSRepositoryImpl.ReferencedInstance refInstance = getInstance(className, refId);
        if (refInstance != null) {
            refInstance.reference.setOwnSlotValue(externalUpdateDate,timestamp());
        }
        else {
            refInstance = getNewInstance(className,refId,instanceName);
        }
        saveOwnAttributes(refInstance.instance,ownAttributes);
        return refInstance;
    }

    private void saveOwnAttributes(Instance instance, HashMap<String, Object> ownAttributes) {
        if (instance == null) return;
        Iterator<Map.Entry<String,Object>> attributesI = ownAttributes.entrySet().iterator();
        while (attributesI.hasNext()) {
            Map.Entry<String,Object> attribute = attributesI.next();
            Object value = attribute.getValue();
            String key = attribute.getKey();
            saveSlot(instance, key, value);
        }
    }

    private void saveSlot(Instance instance, String slotName, Object value) {
        Slot slot = kb.getSlot(slotName);
        String slotType = slot.getValueType().toString().toLowerCase();
        if (slot != null) {
            if (value instanceof Collection) {
                Iterator newValuesI = ((Collection)value).iterator();
                if (newValuesI.hasNext()) {
                    if (slot.getAllowsMultipleValues()) {
                        //Cleaning collection
                        Iterator valuesI = instance.getDirectOwnSlotValues(slot).iterator();
                        while (valuesI.hasNext()) {
                            instance.removeOwnSlotValue(slot,valuesI.next());
                        }
                        // Adding the new collection
                        while (newValuesI.hasNext()) {
                            Object v = newValuesI.next();
                            if ("instance".equals(slotType)) {
                                v = getInstanceById((String) value);
                            }
                            instance.addOwnSlotValue(slot,v);
                        }
                    }
                    else { // it's not a collection add first value
                        Object v = newValuesI.next();
                        if ("instance".equals(slotType)) {
                            v = getInstanceById((String) value);
                        }
                        instance.setOwnSlotValue(slot,v);
                    }
                }
            }
            else {
                Object v = value;
                if ("instance".equals(slotType)) {
                    v = getInstanceById((String) value);
                }
                if (slot.getAllowsMultipleValues()) {
                    Iterator valuesI = instance.getDirectOwnSlotValues(slot).iterator();
                    while (valuesI.hasNext()) {
                        if (v == valuesI.next()) return;
                    }
                    instance.addOwnSlotValue(slot,v);
                }
                else {
                    instance.setOwnSlotValue(slot,v);
                }
            }
        }
    }

    private String timestamp() {
        return DateFormat.getDateTimeInstance().format(new Date());
    }

    private Instance getNewReferenceInstance(String refId) {
        Instance reference = kb.createInstance(null, kb.getCls("External_Instance_Reference"));
        reference.setOwnSlotValue(kb.getSlot("name"), externalRepositoryName + "::" + refId);
        reference.addOwnSlotValue(kb.getSlot("external_repository_reference"), externalRepositoryInstance);
        reference.setOwnSlotValue(kb.getSlot("external_instance_reference"), refId);
        reference.setOwnSlotValue(kb.getSlot("external_update_date"), timestamp());
        return reference;
    }

    private ArquiteturaCorporativaONSRepositoryImpl.ReferencedInstance getNewInstance(String className, String refId, String instanceName) {
    	ArquiteturaCorporativaONSRepositoryImpl.ReferencedInstance refInstance = new ArquiteturaCorporativaONSRepositoryImpl.ReferencedInstance();
        refInstance.instance = kb.createInstance(null, kb.getCls(className));
        refInstance.reference = getNewReferenceInstance(refId);
        String name = getNameSlot(refInstance.instance);
        refInstance.instance.setOwnSlotValue(kb.getSlot(name), instanceName);
        refInstance.instance.addOwnSlotValue(kb.getSlot("external_repository_instance_reference"), refInstance.reference);
        return refInstance;
    }

    private Instance getInstanceById(String id) {
        return kb.getInstance(id);
    }

    private ArquiteturaCorporativaONSRepositoryImpl.ReferencedInstance getInstance(String className, String refId) {
        Iterator<Instance> instancesI = kb.getCls(className).getDirectInstances().iterator();
        Slot externalRefSlot = kb.getSlot("external_repository_instance_reference");
        Slot externalRefIdSlot = kb.getSlot("external_instance_reference");

        while (instancesI.hasNext()) {
            Instance instance = instancesI.next();
            Iterator<Instance> externalRefI = instance.getDirectOwnSlotValues(externalRefSlot).iterator();
            if (externalRefI.hasNext()) {
                Instance ref = getExternalReferenceInstance(externalRefI);
                if (ref != null) {
                    String externalRefId = (String)ref.getDirectOwnSlotValue(externalRefIdSlot);
                    if (refId == externalRefId) {
                    	ArquiteturaCorporativaONSRepositoryImpl.ReferencedInstance refInstance = new ArquiteturaCorporativaONSRepositoryImpl.ReferencedInstance();
                        refInstance.instance = instance;
                        refInstance.reference = ref;
                        return refInstance;
                    };
                }
            }
        }
        return null;
    }

    private Instance getExternalReferenceInstance(Iterator<Instance> iter) {
        Slot externalRepositoryRefSlot = kb.getSlot("external_repository_reference");
        while (iter.hasNext()) {
            Instance ref = iter.next();
            if (ref.getDirectOwnSlotValue(externalRepositoryRefSlot) == externalRepositoryInstance) return ref;
        }
        return null;
    }

    private String getNameSlot(Instance instance) {
        String aCorrectNameSlot = "name";

	    Iterator<Slot> slots = instance.getOwnSlots().iterator();
        while(slots.hasNext()) {
            Slot slot = slots.next();
            if ("relation_name".equals(slot.getName())) aCorrectNameSlot = "relation_name";
            if (":relation_name".equals(slot.getName())) aCorrectNameSlot = ":relation_name";
        }
        return aCorrectNameSlot;
    }

    private static String displayErrors(Collection errors) {
        Iterator i = errors.iterator();
        StringBuilder builder = new StringBuilder();
        while (i.hasNext()) {
            builder.append("Error: " + i.next() + "\n");
        }
        return builder.toString();
    }

	/* (non-Javadoc)
	 * @see br.org.ons.EssentialServices.repository.server.ArquiteturaCorporativaONS#setProjectPath(java.lang.String)
	 */
	@Override
	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}

	@Override
	public Collection<Object> getObjInstancesOfSlot(String slotName, HashMap<String, Object> map) {
		Instance instance = (Instance) map.get("_instance");
		String keyConv = convertFormat(slotName, 1);
        Slot slot = kb.getSlot(keyConv);
		Collection<Object> objInstances = instance.getOwnSlotValues(slot);
		return objInstances;
	}
	
	@Override
	public Collection<Object> getObjInstancesOfSlot(String slotName, Collection<Object> instances) {
		Iterator it = instances.iterator();
		Collection<Object> objInstances = new ArrayList<>();
		Slot slot = kb.getSlot(convertFormat(slotName, 1));
		
		while (it.hasNext()){
			Instance instance = (Instance) it.next();
			Iterator<Object> objOwnInstancesIt = instance.getOwnSlotValues(slot).iterator();
			while(objOwnInstancesIt.hasNext()){
				Object ownInstance = objOwnInstancesIt.next();
				objInstances.add(ownInstance);
			}
		}
		return objInstances;
	}

}
