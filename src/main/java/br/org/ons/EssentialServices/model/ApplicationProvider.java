package br.org.ons.EssentialServices.model;

import java.util.ArrayList;
import java.util.Collection;


public class ApplicationProvider extends Entity implements iEntity {

    private String id;
    private String Nome;
    private String Descricao;
    private String Hospedagem;
    private String Status;
    private String TipoDeAplicacao;
    private String TipoDeProduto;
    private String Fornecedor;
    private Collection<String> UsageLocations;
    private Collection<String> Propositos;
    private Collection<String> TechCapsNeed;
    private Collection <String>Classifications;
    private String Owner;
    private String ITOwner;
    private String ITContact;
    private ArrayList<SoftwareComponent> SoftwareComponents;
    private ArrayList<FunctionImplementation> FunctionImpls;
    private ArrayList<Stakeholder> Stakeholders;


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
		return Nome;
	}


	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		Nome = nome;
	}


	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return Descricao;
	}


	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}


	/**
	 * @return the hospedagem
	 */
	public String getHospedagem() {
		return Hospedagem;
	}


	/**
	 * @param hospedagem the hospedagem to set
	 */
	public void setHospedagem(String hospedagem) {
		Hospedagem = hospedagem;
	}


	/**
	 * @return the status
	 */
	public String getStatus() {
		return Status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		Status = status;
	}


	/**
	 * @return the tipoDeAplicacao
	 */
	public String getTipoDeAplicacao() {
		return TipoDeAplicacao;
	}


	/**
	 * @param tipoDeAplicacao the tipoDeAplicacao to set
	 */
	public void setTipoDeAplicacao(String tipoDeAplicacao) {
		TipoDeAplicacao = tipoDeAplicacao;
	}


	/**
	 * @return the tipoDeProduto
	 */
	public String getTipoDeProduto() {
		return TipoDeProduto;
	}


	/**
	 * @param tipoDeProduto the tipoDeProduto to set
	 */
	public void setTipoDeProduto(String tipoDeProduto) {
		TipoDeProduto = tipoDeProduto;
	}


	/**
	 * @return the fornecedor
	 */
	public String getFornecedor() {
		return Fornecedor;
	}


	/**
	 * @param fornecedor the fornecedor to set
	 */
	public void setFornecedor(String fornecedor) {
		Fornecedor = fornecedor;
	}


	/**
	 * @return the usageLocations
	 */
	public Collection<String> getUsageLocations() {
		return UsageLocations;
	}


	/**
	 * @param usageLocations the usageLocations to set
	 */
	public void setUsageLocations(Collection<String> usageLocations) {
		UsageLocations = usageLocations;
	}


	/**
	 * @return the propositos
	 */
	public Collection<String> getPropositos() {
		return Propositos;
	}


	/**
	 * @param propositos the propositos to set
	 */
	public void setPropositos(Collection<String> propositos) {
		Propositos = propositos;
	}


	/**
	 * @return the techCapsNeed
	 */
	public Collection<String> getTechCapsNeed() {
		return TechCapsNeed;
	}


	/**
	 * @param techCapsNeed the techCapsNeed to set
	 */
	public void setTechCapsNeed(Collection<String> techCapsNeed) {
		TechCapsNeed = techCapsNeed;
	}


	/**
	 * @return the classifications
	 */
	public Collection<String> getClassifications() {
		return Classifications;
	}


	/**
	 * @param classifications the classifications to set
	 */
	public void setClassifications(Collection<String> classifications) {
		Classifications = classifications;
	}


	/**
	 * @return the owner
	 */
	public String getOwner() {
		return Owner;
	}


	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		Owner = owner;
	}


	/**
	 * @return the iTOwner
	 */
	public String getITOwner() {
		return ITOwner;
	}


	/**
	 * @param iTOwner the iTOwner to set
	 */
	public void setITOwner(String iTOwner) {
		ITOwner = iTOwner;
	}


	/**
	 * @return the iTContact
	 */
	public String getITContact() {
		return ITContact;
	}


	/**
	 * @param iTContact the iTContact to set
	 */
	public void setITContact(String iTContact) {
		ITContact = iTContact;
	}


	/**
	 * @return the softwareComponents
	 */
	public ArrayList<SoftwareComponent> getSoftwareComponents() {
		return SoftwareComponents;
	}


	/**
	 * @param softwareComponents the softwareComponents to set
	 */
	public void setSoftwareComponents(ArrayList<SoftwareComponent> softwareComponents) {
		SoftwareComponents = softwareComponents;
	}


	/**
	 * @return the functionImpls
	 */
	public ArrayList<FunctionImplementation> getFunctionImpls() {
		return FunctionImpls;
	}


	/**
	 * @param functionImpls the functionImpls to set
	 */
	public void setFunctionImpls(ArrayList<FunctionImplementation> functionImpls) {
		FunctionImpls = functionImpls;
	}


	/**
	 * @return the stakeholders
	 */
	public ArrayList<Stakeholder> getStakeholders() {
		return Stakeholders;
	}


	/**
	 * @param stakeholders the stakeholders to set
	 */
	public void setStakeholders(ArrayList<Stakeholder> stakeholders) {
		Stakeholders = stakeholders;
	} 
}