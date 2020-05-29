package mr.esp.suivi.dto;


import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import mr.esp.suivi.model.Departement;
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
    @NotNull
	private int quotas;
	@NotBlank
	private String email;
	@NotBlank
	private String telephone;
	private String Specialite;
	private Collection<Departement> departements;
	
	private String adresse;
	
	private String site_web;

	
	  public String getSpecialite() {
		return Specialite;
	}
	public void setSpecialite(String specialite) {
		Specialite = specialite;
	}
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
	public Collection<Departement> getDepartements() {
		return departements;
	}
	public void setDepartements(Collection<Departement> departements) {
		this.departements = departements;
	}
	public EtablissementPartenaireDto(@NotBlank String nom, @NotBlank String ville, @NotBlank String pays,
			@NotBlank String type_Accords, int quotas, @NotBlank String email, @NotBlank String telephone,
			String specialite, Collection<Departement> departements, String adresse, String site_web) {
		super();
		this.nom = nom;
		this.ville = ville;
		Pays = pays;
		this.type_Accords = type_Accords;
		this.quotas = quotas;
		this.email = email;
		this.telephone = telephone;
		Specialite = specialite;
		this.departements = departements;
		this.adresse = adresse;
		this.site_web = site_web;
	}
	public EtablissementPartenaireDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}
