/**
 * 
 */
package br.org.ons.EssentialServices.repository;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import br.org.ons.EssentialServices.model.Actor;
import br.org.ons.EssentialServices.model.iEntity;

/**
 * @author coichedid
 *
 */
public interface iEntityRepository {
	void setEssentialProjectPath(String essentialProjectPath);
	void setRepositoryName(String repositoryName);
}
