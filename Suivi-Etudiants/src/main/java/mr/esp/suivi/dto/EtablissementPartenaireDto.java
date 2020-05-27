package mr.esp.suivi.dto;


import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

import mr.esp.suivi.model.Etudiant;


public class EtablissementPartenaireDto {
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return Pays;
	}
	public void setPays(String pays) {
		Pays = pays;
	}
	public String getType_Accords() {
		return type_Accords;
	}
	public void setType_Accords(String type_Accords) {
		this.type_Accords = type_Accords;
	}
	@NotBlank
	private String nom;
	@NotBlank
	private String ville;
	@NotBlank
	private String Pays ;
	@NotBlank
	private String type_Accords;
	@PastOrPresent
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date date_Accords;
	private int quotas;
	@NotBlank
	private String email;
	@NotBlank
	private String telephone;
	
	public Date getDate_Accords() {
		return date_Accords;
	}
	public void setDate_Accords(Date date_Accords) {
		this.date_Accords = date_Accords;
	}
	private String adresse;
	
	private String site_web;

	
	  public int getQuotas() { return quotas; } public void setQuotas(int quotas) {
	  this.quotas = quotas; }
	 
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getSite_web() {
		return site_web;
	}
	public void setSite_web(String site_web) {
		this.site_web = site_web;
	}
	private Collection<Etudiant> etudiants;

	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
}
