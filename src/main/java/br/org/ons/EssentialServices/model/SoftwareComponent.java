/**
 * 
 */
package br.org.ons.EssentialServices.model;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author coichedid
 *
 */
public class SoftwareComponent extends Entity implements iEntity {
	
	private String name;
	private String id;
	private String softwareArchitectureLayer;
	private String softwareInteractionTechProtocol;
	
	/**
	 * 
	 */
	public SoftwareComponent() {
		super();
		simpleTags.put("Nome","name");
		simpleTags.put("Id","id");
		simpleTags.put("ArchLayer","softwareArchitectureLayer");
		simpleTags.put("Protocolo"," softwareInteractionTechProtocol");
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the softwareArchitectureLayer
	 */
	public String getSoftwareArchitectureLayer() {
		return softwareArchitectureLayer;
	}

	/**
	 * @param softwareArchitectureLayer the softwareArchitectureLayer to set
	 */
	public void setSoftwareArchitectureLayer(String softwareArchitectureLayer) {
		this.softwareArchitectureLayer = softwareArchitectureLayer;
	}

	/**
	 * @return the softwareInteractionTechProtocol
	 */
	public String getSoftwareInteractionTechProtocol() {
		return softwareInteractionTechProtocol;
	}

	/**
	 * @param softwareInteractionTechProtocol the softwareInteractionTechProtocol to set
	 */
	public void setSoftwareInteractionTechProtocol(String softwareInteractionTechProtocol) {
		this.softwareInteractionTechProtocol = softwareInteractionTechProtocol;
	}

}
