/**
 * 
 */
package br.org.ons.EssentialServices.model;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * @author coichedid
 *
 */
public class Entity implements iEntity {

//	protected HashMap<String,String> simpleTags ;
//	protected HashMap<String,String> complexTags ;
    
	/** 
	 * 
	 */
	public Entity() {
//		simpleTags = new HashMap<String,String>();
//		complexTags = new HashMap<String,String>();
	}

	/* (non-Javadoc)
	 * @see br.org.ons.EssentialServices.model.iEntity#toHashMap()
	 */
	@Override
	public Map<String, Object> toHashMap() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Map<String,Object> map = PropertyUtils.describe(this);
		map.remove("class");
		return map;
//	    Map<String,Object> hashMap = new HashMap<String,Object>();
	    
//	    Iterator<Map.Entry<String,String>> translations = simpleTags.entrySet().iterator();
	    
//	    while (translations.hasNext()) {
//	    		Map.Entry<String, String> kV = translations.next();
//	    		hashMap.put(kV.getKey(), map.get(kV.getValue()));
//	    }
//	    
//	    return hashMap;
	}
	
//	public HashMap<String,String> listSimpleTags() {
//		return simpleTags;
//	}
	
//	public static ArrayList<String> getSimpleTags(iEntity obj) {
//		Collection<String> values = obj.listSimpleTags().values();
//		ArrayList<String> simpleTagsList = new ArrayList<String>(values);
//        return simpleTagsList;
//    }
	
	@Override
	public void updateProperties(HashMap<String,Object> properties) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.populate(this, properties);
	}
}
