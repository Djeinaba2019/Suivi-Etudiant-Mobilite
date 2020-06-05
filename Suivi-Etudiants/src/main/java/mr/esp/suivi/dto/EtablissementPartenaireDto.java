package mr.esp.suivi.dto;


import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
	
	@NotBlank
	private String nom;
	@NotBlank
	private String ville;
	@NotBlank
	private String Pays ;
    @NotNull
	private int quotas;
	@NotBlank
	private String email;
	@NotBlank
	private String telephone;
	
	
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
	
	public EtablissementPartenaireDto(@NotBlank String nom, @NotBlank String ville, @NotBlank String pays,
			 int quotas, @NotBlank String email, @NotBlank String telephone, String adresse, String site_web) {
		super();
		this.nom = nom;
		this.ville = ville;
		Pays = pays;	
		this.quotas = quotas;
		this.email = email;
		this.telephone = telephone;	
		this.adresse = adresse;
		this.site_web = site_web;
	}
	public EtablissementPartenaireDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


}
