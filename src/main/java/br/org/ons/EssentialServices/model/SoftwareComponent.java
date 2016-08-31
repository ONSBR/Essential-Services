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
	
	private String id;
	private String nome;
	private String archLayer;
	private String protocolo;
	
	/**
	 * 
	 */
	public SoftwareComponent() {
		super();
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
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the archLayer
	 */
	public String getArchLayer() {
		return archLayer;
	}

	/**
	 * @param archLayer the archLayer to set
	 */
	public void setArchLayer(String archLayer) {
		this.archLayer = archLayer;
	}

	/**
	 * @return the protocolo
	 */
	public String getProtocolo() {
		return protocolo;
	}

	/**
	 * @param protocolo the protocolo to set
	 */
	public void setProtocolo(String protocolo) {
		this.protocolo = protocolo;
	}

}
