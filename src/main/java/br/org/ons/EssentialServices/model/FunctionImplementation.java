package br.org.ons.EssentialServices.model;

import java.util.Collection;

public class FunctionImplementation extends Entity implements iEntity {
	private String id;
    private String nome;
    private String descricao;
    private String softwareComponent;
    private String protocolo;
    private Collection<String> informationUsed;
    private Function function;

	public FunctionImplementation() {
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
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the softwareComponent
	 */
	public String getSoftwareComponent() {
		return softwareComponent;
	}

	/**
	 * @param softwareComponent the softwareComponent to set
	 */
	public void setSoftwareComponent(String softwareComponent) {
		this.softwareComponent = softwareComponent;
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

	/**
	 * @return the informationUsed
	 */
	public Collection<String> getInformationUsed() {
		return informationUsed;
	}

	/**
	 * @param informationUsed the informationUsed to set
	 */
	public void setInformationUsed(Collection<String> informationUsed) {
		this.informationUsed = informationUsed;
	}

	/**
	 * @return the function
	 */
	public Function getFunction() {
		return function;
	}

	/**
	 * @param function the function to set
	 */
	public void setFunction(Function function) {
		this.function = function;
	}

}
