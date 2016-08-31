/**
 * 
 */
package br.org.ons.EssentialServices.repository;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.Logger;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.mysql.jdbc.NotImplemented;

import br.org.ons.EssentialServices.model.iEntity;
import br.org.ons.EssentialServices.repository.server.ArquiteturaCorporativaONSRepository;

/**
 * @author coichedid
 *
 */
public abstract class EntityRepositoryImpl implements iEntityRepository {
	protected Logger LOGGER;
	
	protected ArquiteturaCorporativaONSRepository arquiteturaRepository;
	
	protected BiMap<String, String> ownTags;
    protected BiMap<String,String> inversedOwnTags;
    protected String repositoryName;
    protected String essentialProjectPath;
    
    protected String entityClass;
    
	/**
	 * 
	 */
	public EntityRepositoryImpl() {
		ownTags = HashBiMap.create();
	}
	
	/**
	 * @return the entityClass
	 */
	public String getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass the entityClass to set
	 */
	public void setEntityClass(String entityClass) {
		this.entityClass = entityClass;
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

	
	public Collection<? extends iEntity> getSimpleEntities() throws Exception {
		Collection<Object> intancesObj = arquiteturaRepository.getObjInstances(entityClass);
		ArrayList<? extends iEntity> entities = getEntities(intancesObj);
		return entities;
	}

	public abstract Collection<? extends iEntity> getEntitiesById(Collection<String> ids) throws Exception;

	public abstract iEntity getEntityById(String id) throws Exception;

	public abstract ArrayList<? extends iEntity> getEntities(Collection<Object> entityObjects) throws IllegalAccessException, InvocationTargetException ;
	
	public abstract ArrayList<? extends iEntity> getDistinctEntities(Collection<Object> entityObjects) throws IllegalAccessException, InvocationTargetException ;

	public iEntity getEntity(Collection<Object> entityObjects, int idx) throws IllegalAccessException, InvocationTargetException {
		ArrayList<? extends iEntity> entities = getEntities(entityObjects);
		return entities.size() >= idx+1?entities.get(idx):null;
	}

}
