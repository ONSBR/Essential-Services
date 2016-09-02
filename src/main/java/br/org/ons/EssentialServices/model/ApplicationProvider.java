package br.org.ons.EssentialServices.model;

import java.util.ArrayList;
import java.util.Collection;


public class ApplicationProvider extends Entity implements iEntity {

    private String id;
    private String nome;
    private String descricao;
    private String hospedagem;
    private String status;
    private String tipoDeAplicacao;
    private String tipoDeProduto;
    private String fornecedor;
    private Collection<String> usageLocations;
    private Collection<String> propositos;
    private Collection<String> techCapsNeed;
    private Collection <String>classifications;
    private String owner;
    private String itOwner;
    private String itContact;
    private ArrayList<SoftwareComponent> softwareComponents;
    private ArrayList<FunctionImplementation> functionImpls;
    private ArrayList<Stakeholder> stakeholders;
    private ArrayList<ApplicationService> applicationServices;
    private ArrayList<UseOfInformationRepresentation> usesInformations;


    public ApplicationProvider() {
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
	 * @return the hospedagem
	 */
	public String getHospedagem() {
		return hospedagem;
	}


	/**
	 * @param hospedagem the hospedagem to set
	 */
	public void setHospedagem(String hospedagem) {
		this.hospedagem = hospedagem;
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


	/**
	 * @return the tipoDeAplicacao
	 */
	public String getTipoDeAplicacao() {
		return tipoDeAplicacao;
	}


	/**
	 * @param tipoDeAplicacao the tipoDeAplicacao to set
	 */
	public void setTipoDeAplicacao(String tipoDeAplicacao) {
		this.tipoDeAplicacao = tipoDeAplicacao;
	}


	/**
	 * @return the tipoDeProduto
	 */
	public String getTipoDeProduto() {
		return tipoDeProduto;
	}


	/**
	 * @param tipoDeProduto the tipoDeProduto to set
	 */
	public void setTipoDeProduto(String tipoDeProduto) {
		this.tipoDeProduto = tipoDeProduto;
	}


	/**
	 * @return the fornecedor
	 */
	public String getFornecedor() {
		return fornecedor;
	}


	/**
	 * @param fornecedor the fornecedor to set
	 */
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}


	/**
	 * @return the usageLocations
	 */
	public Collection<String> getUsageLocations() {
		return usageLocations;
	}


	/**
	 * @param usageLocations the usageLocations to set
	 */
	public void setUsageLocations(Collection<String> usageLocations) {
		this.usageLocations = usageLocations;
	}


	/**
	 * @return the propositos
	 */
	public Collection<String> getPropositos() {
		return propositos;
	}


	/**
	 * @param propositos the propositos to set
	 */
	public void setPropositos(Collection<String> propositos) {
		this.propositos = propositos;
	}


	/**
	 * @return the techCapsNeed
	 */
	public Collection<String> getTechCapsNeed() {
		return techCapsNeed;
	}


	/**
	 * @param techCapsNeed the techCapsNeed to set
	 */
	public void setTechCapsNeed(Collection<String> techCapsNeed) {
		this.techCapsNeed = techCapsNeed;
	}


	/**
	 * @return the classifications
	 */
	public Collection<String> getClassifications() {
		return classifications;
	}


	/**
	 * @param classifications the classifications to set
	 */
	public void setClassifications(Collection<String> classifications) {
		this.classifications = classifications;
	}


	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}


	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}


	/**
	 * @return the itOwner
	 */
	public String getItOwner() {
		return itOwner;
	}


	/**
	 * @param itOwner the itOwner to set
	 */
	public void setItOwner(String itOwner) {
		this.itOwner = itOwner;
	}


	/**
	 * @return the itContact
	 */
	public String getItContact() {
		return itContact;
	}


	/**
	 * @param itContact the itContact to set
	 */
	public void setItContact(String itContact) {
		this.itContact = itContact;
	}


	/**
	 * @return the softwareComponents
	 */
	public ArrayList<SoftwareComponent> getSoftwareComponents() {
		return softwareComponents;
	}


	/**
	 * @param softwareComponents the softwareComponents to set
	 */
	public void setSoftwareComponents(ArrayList<SoftwareComponent> softwareComponents) {
		this.softwareComponents = softwareComponents;
	}


	/**
	 * @return the functionImpls
	 */
	public ArrayList<FunctionImplementation> getFunctionImpls() {
		return functionImpls;
	}


	/**
	 * @param functionImpls the functionImpls to set
	 */
	public void setFunctionImpls(ArrayList<FunctionImplementation> functionImpls) {
		this.functionImpls = functionImpls;
	}


	/**
	 * @return the stakeholders
	 */
	public ArrayList<Stakeholder> getStakeholders() {
		return stakeholders;
	}


	/**
	 * @param stakeholders the stakeholders to set
	 */
	public void setStakeholders(ArrayList<Stakeholder> stakeholders) {
		this.stakeholders = stakeholders;
	}


	/**
	 * @return the applicationServices
	 */
	public ArrayList<ApplicationService> getApplicationServices() {
		return applicationServices;
	}


	/**
	 * @param applicationServices the applicationServices to set
	 */
	public void setApplicationServices(ArrayList<ApplicationService> applicationServices) {
		this.applicationServices = applicationServices;
	}


	/**
	 * @return the usesInformations
	 */
	public ArrayList<UseOfInformationRepresentation> getUsesInformations() {
		return usesInformations;
	}


	/**
	 * @param usesInformations the usesInformations to set
	 */
	public void setUsesInformations(ArrayList<UseOfInformationRepresentation> usesInformations) {
		this.usesInformations = usesInformations;
	}


	
}