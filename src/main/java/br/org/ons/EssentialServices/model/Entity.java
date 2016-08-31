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
    
	/** 
	 * 
	 */
	public Entity() {
	}

	/* (non-Javadoc)
	 * @see br.org.ons.EssentialServices.model.iEntity#toHashMap()
	 */
	@Override
	public Map<String, Object> toHashMap() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Map<String,Object> map = PropertyUtils.describe(this);
		map.remove("class");
		return map;
	}
	
	@Override
	public void updateProperties(HashMap<String,Object> properties) throws IllegalAccessException, InvocationTargetException {
		BeanUtils.populate(this, properties);
	}
}
