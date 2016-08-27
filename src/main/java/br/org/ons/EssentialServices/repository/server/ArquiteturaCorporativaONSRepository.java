package br.org.ons.EssentialServices.repository.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public interface ArquiteturaCorporativaONSRepository {

	Collection<HashMap<String, Object>> getObjInstances(String className, ArrayList<String> slotList);

	void setExternalRepositoryName(String repositoryName);

	HashMap<String, Object> saveObjInstance(String className, String refId, String instanceName,
			HashMap<String, Object> ownAttributes);

	/**
	 * @param projectPath the projectPath to set
	 */
	void setProjectPath(String projectPath);

}