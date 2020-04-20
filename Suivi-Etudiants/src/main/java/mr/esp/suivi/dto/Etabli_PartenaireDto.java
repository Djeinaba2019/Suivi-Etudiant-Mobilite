package mr.esp.suivi.dto;


import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;


public class Etabli_PartenaireDto {
	
	@NotBlank
	private String nom;
	@NotBlank
	private String ville;
	@NotBlank
	private String Pays ;
	private String type_Accords;
	@NotNull
	private int quotas;
	@NotBlank
	private String email;
	@NotBlank
	private String telephone;
	@NotBlank
	private String adresse;
	@NotBlank
	private String site_web;
	@NotBlank
	private String Specialite;
	
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
	
	public String getSpecialite() {
		return Specialite;
	}
	public void setSpecialite(String specialite) {
		Specialite = specialite;
	}
	
	public int getQuotas() {
		return quotas;
	}
	public void setQuotas(int quotas) {
		this.quotas = quotas;
	}
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
}
