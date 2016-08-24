package br.org.ons.EssentialServices.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collection;

public class ApplicationProvider implements iEntity {
    private static final String[] simpleTags = {"name", "description"};

    private String name;
    private String description;


    public ApplicationProvider() {

    } 


    public ApplicationProvider(HashMap<String,Object> hashMap) {
        this.name = (String)hashMap.get("name");
        this.description = (String)hashMap.get("description");
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

    public static ArrayList<String> getSimpleTags() {
        return new ArrayList<String>(Arrays.asList(simpleTags));
    }

    public HashMap<String,Object> toHashMap() {
        HashMap<String,Object> hashMap = new HashMap<String,Object>();
        hashMap.put("name", this.name);
        hashMap.put("description", this.description);
        return hashMap;
    }
}