/**
 * 
 */
package br.org.ons.EssentialServices.model;

/**
 * @author coichedid
 *
 */
public class ApplicationCapability extends Entity implements iEntity {

	private String nome;
	private String descricao;
	/**
	 * 
	 */
	public ApplicationCapability() {
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

}
