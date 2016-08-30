/**
 * 
 */
package br.org.ons.EssentialServices.model;

/**
 * @author coichedid
 *
 */
public class Stakeholder extends Entity implements iEntity {

	private Actor ator;
	private String rolePlayed;
	/**
	 * 
	 */
	public Stakeholder() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the ator
	 */
	public Actor getAtor() {
		return ator;
	}
	/**
	 * @param ator the ator to set
	 */
	public void setActor(Actor ator) {
		this.ator = ator;
	}
	/**
	 * @return the rolePlayed
	 */
	public String getRolePlayed() {
		return rolePlayed;
	}
	/**
	 * @param rolePlayed the rolePlayed to set
	 */
	public void setRolePlayed(String rolePlayed) {
		this.rolePlayed = rolePlayed;
	}

}
