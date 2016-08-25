package br.org.ons.EssentialServices.model;

import java.util.HashMap;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public interface iEntity {
    Map<String,Object> toHashMap() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException;
    static Collection<Map<String,Object>> serializeCollection(Collection<iEntity> list) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Collection<Map<String,Object>> hashMaps = new ArrayList<Map<String,Object>>();

        Iterator<iEntity> iterator = list.iterator();

        while(iterator.hasNext()) {
            hashMaps.add(iterator.next().toHashMap());
        }

        return hashMaps;
    }
}