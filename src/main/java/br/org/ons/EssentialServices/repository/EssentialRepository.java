package br.org.ons.EssentialServices.repository;

import java.io.*;
import java.lang.Exception;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Map;
import edu.stanford.smi.protege.model.*;

/*
 *  * This application just prints out all of the classes in a knowledge base
 *   * and the direct instances of those classes.
 *    */
public class EssentialRepository {
    private String projectPath = "";
    private Project project;
    private KnowledgeBase kb;
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

    public Collection<HashMap<String,String>> getInstances(ArrayList<String> slotList) {
        HashMap<String,Slot> slots = new HashMap<String,Slot>();
        Collection<HashMap<String,String>> instances = new ArrayList<HashMap<String,String>>();
        Iterator<String> slotListI = slotList.iterator();
        while (slotListI.hasNext()) {
            String key = slotListI.next();
            Slot sl = kb.getSlot(key);
            slots.put(key,sl);
        }
        Iterator i = kb.getClsNameMatches("Application_Provider",1).iterator();
        while (i.hasNext()) {
            Cls cls = (Cls) i.next();
            Iterator j = cls.getDirectInstances().iterator();
            while (j.hasNext()) {
                HashMap<String,String> inst = new HashMap<String,String>(); 
                Instance instance = (Instance) j.next();
                inst.put("Id",instance.getName());
                Set<Map.Entry<String,Slot>> slotSet = slots.entrySet();
                Iterator<Map.Entry<String,Slot>> slotSetI = slotSet.iterator();
                while (slotSetI.hasNext()) {
                    Map.Entry<String,Slot> map = slotSetI.next();
                    String k = map.getKey();
                    Slot s = map.getValue();
                    String value = (String) instance.getOwnSlotValue(s);
                    inst.put(k,value);
                }
                instances.add(inst);
            }
        }
        return instances;
    }

    // public static void main(String[] args ){
        
	//     Slot sl = kb.getSlot("name");
    //         //Iterator i = kb.getClses().iterator();
    //         Iterator i = kb.getClsNameMatches("Application_Provider",1).iterator();
    //         while (i.hasNext()) {
    //             Cls cls = (Cls) i.next();
    //             System.out.println("Class: " + cls.getName());
    //             Iterator j = cls.getDirectInstances().iterator();
    //             while (j.hasNext()) {
    //                    Instance instance = (Instance) j.next();
    //                 System.out.println("  Instance: " + instance.getName());
	// 	       String name = (String)instance.getOwnSlotValue(sl);
	// 	       System.out.println("  Name: " + name);
    //             }
    //         }
    //     } else {
    //         String errors = displayErrors(errors);
    //         throw new Exception(errors);
    //     }
    //     waitForContinue();
    // }

    private static String displayErrors(Collection errors) {
        Iterator i = errors.iterator();
        StringBuilder builder = new StringBuilder();
        while (i.hasNext()) {
            builder.append("Error: " + i.next() + "\n");
        }
        return builder.toString();
    }

    // private static void waitForContinue() {
    //     System.out.println("Press <Enter> to continue");
    //     try {
    //         System.in.read();
    //        } catch (Exception e) {}
    // }
}
