/**
 * 
 */
package br.org.ons.EssentialServices.model;

/**
 * @author coichedid
 *
 */
public class Function extends Entity implements iEntity {

	private String nome;
	private String descricao;
	private String behavior;
	private ApplicationCapability applicationCap;
	public Function(){
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
	 * @return the behavior
	 */
	public String getBehavior() {
		return behavior;
	}
	/**
	 * @param behavior the behavior to set
	 */
	public void setBehavior(String behavior) {
		this.behavior = behavior;
	}
	/**
	 * @return the applicationCap
	 */
	public ApplicationCapability getApplicationCap() {
		return applicationCap;
	}
	/**
	 * @param applicationCap the applicationCap to set
	 */
	public void setApplicationCap(ApplicationCapability applicationCap) {
		this.applicationCap = applicationCap;
	}
}
