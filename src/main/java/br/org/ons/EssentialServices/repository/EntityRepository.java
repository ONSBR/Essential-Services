/**
 * 
 */
package br.org.ons.EssentialServices.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @author coichedid
 *
 */
public class EntityRepository {
	protected BiMap<String, String> ownTags;
    protected BiMap<String,String> inversedOwnTags;
    protected String repositoryName;
    protected String essentialProjectPath;
	/**
	 * 
	 */
	public EntityRepository() {
		ownTags = HashBiMap.create();
	}
	
	protected ArrayList<String> getSimpleTags() {
		Collection<String> values = ownTags.values();
		ArrayList<String> simpleTagsList = new ArrayList<String>(values);
	    return simpleTagsList;
	}
	
	protected HashMap<String,Object> translateProperties(HashMap<String,Object> map) {
		HashMap<String,Object> translatedMap = new HashMap<>();
		
		Iterator<String> keysI = map.keySet().iterator();
		while (keysI.hasNext()) {
			String key = keysI.next();
			if (inversedOwnTags.containsKey(key)) {
				String translatedKey = inversedOwnTags.get(key);
				translatedMap.put(translatedKey, map.get(key));
			}
		}
		return translatedMap;
	}

}
