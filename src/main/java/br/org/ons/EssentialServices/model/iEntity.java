package br.org.ons.EssentialServices.model;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public interface iEntity {
    HashMap<String,Object> toHashMap();
    static Collection<HashMap<String,Object>> serializeCollection(Collection<iEntity> list) {
        Collection<HashMap<String,Object>> hashMaps = new ArrayList<HashMap<String,Object>>();

        Iterator<iEntity> iterator = list.iterator();

        while(iterator.hasNext()) {
            hashMaps.add(iterator.next().toHashMap());
        }

        return hashMaps;
    }
}