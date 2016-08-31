package br.org.ons.EssentialServices.repository.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public interface ArquiteturaCorporativaONSRepository {
	
	Collection<Object> getObjInstances(String className);

	Collection<HashMap<String, Object>> getObjInstanceMaps(String className, ArrayList<String> slotList);
	Collection<HashMap<String, Object>> getObjInstanceMaps(Collection<Object> instanceObjects, ArrayList<String> slotList);
	HashMap<String,HashMap<String, Object>> getDistinctObjInstanceMaps(Collection<Object> instanceObjects, ArrayList<String> slotList);

	void setExternalRepositoryName(String repositoryName);

	HashMap<String, Object> saveObjInstance(String className, String refId, String instanceName,
			HashMap<String, Object> ownAttributes);

	/**
	 * @param projectPath the projectPath to set
	 */
	void setProjectPath(String projectPath);

	Collection<Object> getObjInstancesOfSlot(String string, HashMap<String, Object> map);
	Collection<Object> getObjInstancesOfSlot(String string, Collection<Object> instances);
}