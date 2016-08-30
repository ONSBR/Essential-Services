/**
 * 
 */
package br.org.ons.EssentialServices.repository;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.mysql.jdbc.NotImplemented;

import br.org.ons.EssentialServices.model.iEntity;
import br.org.ons.EssentialServices.repository.server.ArquiteturaCorporativaONSRepository;

/**
 * @author coichedid
 *
 */
public class EntityRepository implements iEntityRepository {
	
	
	protected ArquiteturaCorporativaONSRepository arquiteturaRepository;
	
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
	
	/**
	 * @param arquiteturaRepository the arquiteturaRepository to set
	 */
	public void setArquiteturaRepository(ArquiteturaCorporativaONSRepository arquiteturaRepository) {
		this.arquiteturaRepository = arquiteturaRepository;
	}

	/**
	 * @param repositoryName the repositoryName to set
	 */
	public void setRepositoryName(String repositoryName) {
		this.repositoryName = repositoryName;
	}

	/**
	 * @param essentialProjectPath the essentialProjectPath to set
	 */
	public void setEssentialProjectPath(String essentialProjectPath) {
		this.essentialProjectPath = essentialProjectPath;
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
