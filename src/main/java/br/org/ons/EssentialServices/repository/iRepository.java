/**
 * 
 */
package br.org.ons.EssentialServices.repository;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import br.org.ons.EssentialServices.model.iEntity;

/**
 * @author coichedid
 *
 */
public interface iRepository {
	Collection<? extends iEntity> getSimpleEntities() throws Exception;
	Collection<? extends iEntity> getEntitiesById(Collection<String> ids) throws Exception;
	iEntity getEntityById(String id) throws Exception;
	ArrayList<? extends iEntity> getEntities(Collection<Object> entityObjects) throws IllegalAccessException, InvocationTargetException;
	iEntity getEntity(Collection<Object> entityObjects, int idx) throws IllegalAccessException, InvocationTargetException;
}