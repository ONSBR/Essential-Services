/**
 * 
 */
package br.org.ons.EssentialServices.model;

/**
 * @author coichedid
 *
 */
public class OperationOnDataRepresentation extends Entity implements iEntity {

	private String id;
	private String dataRepresentation;
	private String formaDeAquisicao;
	private String created;
	private String read;
	private String updated;
	private String deleted;
	/**
	 * 
	 */
	public OperationOnDataRepresentation() {
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
	 * @return the dataRepresentation
	 */
	public String getDataRepresentation() {
		return dataRepresentation;
	}
	/**
	 * @param dataRepresentation the dataRepresentation to set
	 */
	public void setDataRepresentation(String dataRepresentation) {
		this.dataRepresentation = dataRepresentation;
	}
	/**
	 * @return the formaDeAquisicao
	 */
	public String getFormaDeAquisicao() {
		return formaDeAquisicao;
	}
	/**
	 * @param formaDeAquisicao the formaDeAquisicao to set
	 */
	public void setFormaDeAquisicao(String formaDeAquisicao) {
		this.formaDeAquisicao = formaDeAquisicao;
	}
	/**
	 * @return the created
	 */
	public String getCreated() {
		return created;
	}
	/**
	 * @param created the created to set
	 */
	public void setCreated(String created) {
		this.created = created;
	}
	/**
	 * @return the read
	 */
	public String getRead() {
		return read;
	}
	/**
	 * @param read the read to set
	 */
	public void setRead(String read) {
		this.read = read;
	}
	/**
	 * @return the updated
	 */
	public String getUpdated() {
		return updated;
	}
	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	/**
	 * @return the deleted
	 */
	public String getDeleted() {
		return deleted;
	}
	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}

}
