/**
 * 
 */
package br.org.ons.EssentialServices.model;

import java.util.List;

/**
 * @author coichedid
 *
 */
public class UseOfInformationRepresentation extends Entity implements iEntity {

	private String id;
	private String informationUsed;
	private String created;
	private String read;
	private String updated;
	private String deleted;
	private Boolean persisted;
	private List<OperationOnDataRepresentation> dataOperated;
	/**
	 * 
	 */
	public UseOfInformationRepresentation() {
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
	 * @return the informationUsed
	 */
	public String getInformationUsed() {
		return informationUsed;
	}
	/**
	 * @param informationUsed the informationUsed to set
	 */
	public void setInformationUsed(String informationUsed) {
		this.informationUsed = informationUsed;
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
	/**
	 * @return the persisted
	 */
	public Boolean getPersisted() {
		return persisted;
	}
	/**
	 * @param persisted the persisted to set
	 */
	public void setPersisted(Boolean persisted) {
		this.persisted = persisted;
	}
	/**
	 * @return the dataOperated
	 */
	public List<OperationOnDataRepresentation> getDataOperated() {
		return dataOperated;
	}
	/**
	 * @param dataOperated the dataOperated to set
	 */
	public void setDataOperated(List<OperationOnDataRepresentation> dataOperated) {
		this.dataOperated = dataOperated;
	}

}
