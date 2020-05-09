package mr.esp.suivi.dto;


import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import com.sun.istack.NotNull;

import mr.esp.suivi.model.ImageModel;


public class EtablissementPartenaireDto {
	
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

	@Lob
	@NotBlank
	private ImageModel photo;
	
	public ImageModel getPhoto() {
		return photo;
	}
	
	public void setPhoto(ImageModel photo) {
		this.photo=photo;
	}
	
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
	public EtablissementPartenaireDto(@NotBlank String nom, @NotBlank String ville, @NotBlank String pays,
			String type_Accords, int quotas, @NotBlank String email, @NotBlank String telephone,
			@NotBlank String adresse, @NotBlank String site_web, @NotBlank String specialite , ImageModel photo
			) {
		super();
		this.nom = nom;
		this.ville = ville;
		this.Pays = pays;
		this.type_Accords = type_Accords;
		this.quotas = quotas;
		this.email = email;
		this.telephone = telephone;
		this.adresse = adresse;
		this.site_web = site_web;
		this.Specialite = specialite;
		this.photo=photo;
		
	}
	public EtablissementPartenaireDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
