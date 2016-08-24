package br.org.ons.EssentialServices.repository;

import java.io.*;
import java.lang.Exception;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import java.text.DateFormat;
import java.util.Date;
import edu.stanford.smi.protege.model.*;

/*
 *  * This application just prints out all of the classes in a knowledge base
 *   * and the direct instances of those classes.
 *    */
public class EssentialRepository {
    private String projectPath = "";
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

    public EssentialRepository(String projectPath) throws Exception{
        this.projectPath = projectPath;
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

    public Collection<HashMap<String,Object>> getObjInstances(String className, ArrayList<String> slotList) {
        Collection<Slot> slots = new ArrayList<Slot>();
        Collection<HashMap<String,Object>> instances = new ArrayList<HashMap<String,Object>>();
        Iterator<String> slotListI = slotList.iterator();
        while (slotListI.hasNext()) {
            String key = slotListI.next();
            Slot sl = kb.getSlot(key);
            slots.add(sl);
        }
        Cls cls = kb.getCls(className); 
        Iterator instancesI = cls.getDirectInstances().iterator();
        while (instancesI.hasNext()) {
            // HashMap<String,Object> inst = new HashMap<String,Object>(); 
            Instance instance = (Instance) instancesI.next();
            HashMap<String,Object> inst = getInstanceHashMap(instance,slots);
            // inst.put("Id",instance.getName());
            // Iterator<Map.Entry<String,Slot>> slotSetI = slots.entrySet().iterator();
            // while (slotSetI.hasNext()) {
            //     Map.Entry<String,Slot> map = slotSetI.next();
            //     String k = map.getKey();
            //     Slot s = map.getValue();
            //     String value = (String) instance.getOwnSlotValue(s);
            //     inst.put(k,value);
            // }
            instances.add(inst);
        }
        // Iterator i = kb.getClsNameMatches(className,1).iterator();
        // while (i.hasNext()) {
        //     Cls cls = (Cls) i.next();
            
        // }
        return instances;
    }

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

    public HashMap<String,Object> saveObjInstance(String className, String refId, String instanceName, HashMap<String,Object> ownAttributes) {
        EssentialRepository.ReferencedInstance refInstance = saveInstance(className,refId,instanceName,ownAttributes);
        return getInstanceHashMap(refInstance.instance);
    }

    private HashMap<String,Object> getInstanceHashMap(Instance instance) {
        // HashMap<String,Object> hashMap = new HashMap<String, Object>();
        // hashMap.put("Id",instance.getName());
        Collection<Slot> slots = instance.getOwnSlots();
        // while (slotsI.hasNext()) {
        //     Slot slot = slotsI.next();
        //     String slotName = slot.getName();
        //     String slotType = slot.getValueType().toString().toLowerCase();
        //     Object valueToAdd;
        //     if (slot.getAllowsMultipleValues()) { //That's a collection
        //         Collection list = new ArrayList();
        //         Iterator valuesI = instance.getDirectOwnSlotValues(slot).iterator();
        //         while (valuesI.hasNext()) {
        //             Object value = valuesI.next();
        //             list.add(getInstanceSlotValue(slotType,value));
        //         }
        //         valueToAdd = list;
        //     }
        //     else {
        //         Object value = instance.getDirectOwnSlotValue(slot);
        //         valueToAdd = getInstanceSlotValue(slotType,value);
        //     }
        //     hashMap.put(slotName,valueToAdd);
        // }
        // return hashMap;
        return getInstanceHashMap(instance,slots);
    }

    private HashMap<String,Object> getInstanceHashMap(Instance instance, Collection<Slot> slots) {
        HashMap<String,Object> hashMap = new HashMap<String, Object>();
        hashMap.put("Id",instance.getName());
        Iterator<Slot> slotsI = slots.iterator();
        while (slotsI.hasNext()) {
            Slot slot = slotsI.next();
            String slotName = slot.getName();
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

    private EssentialRepository.ReferencedInstance saveInstance(String className, String refId, String instanceName, HashMap<String,Object> ownAttributes) {
        Slot externalUpdateDate = kb.getSlot("external_update_date");
        EssentialRepository.ReferencedInstance refInstance = getInstance(className, refId);
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

    private EssentialRepository.ReferencedInstance getNewInstance(String className, String refId, String instanceName) {
        EssentialRepository.ReferencedInstance refInstance = new EssentialRepository.ReferencedInstance();
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

    private EssentialRepository.ReferencedInstance getInstance(String className, String refId) {
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
                        EssentialRepository.ReferencedInstance refInstance = new EssentialRepository.ReferencedInstance();
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


}