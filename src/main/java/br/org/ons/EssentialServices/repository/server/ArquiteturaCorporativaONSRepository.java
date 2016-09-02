package br.org.ons.EssentialServices.repository.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ArquiteturaCorporativaONSRepository {
	
	Collection<Object> getObjInstances(String className);

	Collection<HashMap<String, Object>> getObjInstanceMaps(String className, List<String> slotList);
	Collection<HashMap<String, Object>> getObjInstanceMaps(Collection<Object> instanceObjects, List<String> slotList);
	Map<String,HashMap<String, Object>> getDistinctObjInstanceMaps(Collection<Object> instanceObjects, List<String> slotList);

	Map<String, Object> saveObjInstance(String className, String refId, String instanceName,
			Map<String, Object> ownAttributes);

	/**
	 * @param projectPath the projectPath to set
	 */
	void setProjectPath(String projectPath);

	Collection<Object> getObjInstancesOfSlot(String string, Map<String, Object> map);
	Collection<Object> getObjInstancesOfSlot(String string, Collection<Object> instances);
	
	String getExternalRepositoryName();
	void setExternalRepositoryName(String repositoryName);
	
	Boolean isExternalRepositoryInstanceSet();
}