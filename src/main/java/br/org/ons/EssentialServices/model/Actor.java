package br.org.ons.EssentialServices.model;

public class Actor extends Entity implements iEntity {

	private String id;
	private String nome;
	private String parentOrganization;
	private String jobPosition;
	
	public Actor() {
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
	 * @return the parentOrganization
	 */
	public String getParentOrganization() {
		return parentOrganization;
	}

	/**
	 * @param parentOrganization the parentOrganization to set
	 */
	public void setParentOrganization(String parentOrganization) {
		this.parentOrganization = parentOrganization;
	}

	/**
	 * @return the jobPosition
	 */
	public String getJobPosition() {
		return jobPosition;
	}

	/**
	 * @param jobPosition the jobPosition to set
	 */
	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}

}
