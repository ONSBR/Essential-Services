/**
 * 
 */
package br.org.ons.EssentialServices.model;

import java.util.List;

/**
 * @author coichedid
 *
 */
public class ApplicationService extends Entity implements iEntity {

	private String nome;
	private String descricao;
	private List<String> applicationCapabilities;
	private String status;
	/**
	 * 
	 */
	public ApplicationService() {
		super();
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
	 * @return the applicationCapabilities
	 */
	public List<String> getApplicationCapabilities() {
		return applicationCapabilities;
	}
	/**
	 * @param applicationCapabilities the applicationCapabilities to set
	 */
	public void setApplicationCapabilities(List<String> applicationCapabilities) {
		this.applicationCapabilities = applicationCapabilities;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
