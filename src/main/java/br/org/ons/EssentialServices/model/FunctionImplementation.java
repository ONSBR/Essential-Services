package br.org.ons.EssentialServices.model;

import java.util.Collection;

public class FunctionImplementation extends Entity implements iEntity {
	private String id;
    private String name;
    private String description;
    private String inverseOfDeliversAppFuncImpl;
    private String appFuncImplProtocol;
    private Collection<String> usesInformationRepresentation;

	public FunctionImplementation() {
		super();
		simpleTags.put("Nome","name");
		simpleTags.put("Descricao","description");
		simpleTags.put("Id","id");
		simpleTags.put("SoftwareComponent","inverseOfDeliversAppFuncImpl");
		simpleTags.put("Protocolo","appFuncImplProtocol");
		simpleTags.put("InformationUsed","usesInformationRepresentation");
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the inverseOfDeliversAppFuncImpl
	 */
	public String getInverseOfDeliversAppFuncImpl() {
		return inverseOfDeliversAppFuncImpl;
	}

	/**
	 * @param inverseOfDeliversAppFuncImpl the inverseOfDeliversAppFuncImpl to set
	 */
	public void setInverseOfDeliversAppFuncImpl(String inverseOfDeliversAppFuncImpl) {
		this.inverseOfDeliversAppFuncImpl = inverseOfDeliversAppFuncImpl;
	}

	/**
	 * @return the appFuncImplProtocol
	 */
	public String getAppFuncImplProtocol() {
		return appFuncImplProtocol;
	}

	/**
	 * @param appFuncImplProtocol the appFuncImplProtocol to set
	 */
	public void setAppFuncImplProtocol(String appFuncImplProtocol) {
		this.appFuncImplProtocol = appFuncImplProtocol;
	}

	/**
	 * @return the usesInformationRepresentation
	 */
	public Collection<String> getUsesInformationRepresentation() {
		return usesInformationRepresentation;
	}

	/**
	 * @param usesInformationRepresentation the usesInformationRepresentation to set
	 */
	public void setUsesInformationRepresentation(Collection<String> usesInformationRepresentation) {
		this.usesInformationRepresentation = usesInformationRepresentation;
	}

}
