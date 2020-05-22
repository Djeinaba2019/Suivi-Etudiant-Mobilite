package mr.esp.springdemo.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

import mr.esp.springdemo.model.Departement;
import mr.esp.springdemo.model.Etabli_Partenaire;
import mr.esp.springdemo.model.ImageModel;
import mr.esp.springdemo.model.TypeMobilite;

public class EtudiantDto {
	
	private Integer matricule;
	@PastOrPresent
	@JsonFormat(pattern="dd-MM-yyyy")
	    private Date dateDeNaissance;
	public Integer getMatricule() {
		return matricule;
	}
	public void setMatricule(Integer matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}
	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNni() {
		return nni;
	}
	public void setNni(String nni) {
		this.nni = nni;
	}
	@NotBlank
	private String nom;
	public TypeMobilite getTypeMobilite() {
		return typeMobilite;
	}
	public void setTypeMobilite(TypeMobilite typeMobilite) {
		this.typeMobilite = typeMobilite;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public Etabli_Partenaire getChoix1() {
		return choix1;
	}
	public void setChoix1(Etabli_Partenaire choix1) {
		this.choix1 = choix1;
	}
	public Etabli_Partenaire getChoix2() {
		return choix2;
	}
	public void setChoix2(Etabli_Partenaire choix2) {
		this.choix2 = choix2;
	}
	public Etabli_Partenaire getChoix3() {
		return choix3;
	}
	public void setChoix3(Etabli_Partenaire choix3) {
		this.choix3 = choix3;
	}
	@NotBlank
	private String prenom;
	 private String telephone;
	 @NotBlank
	 private String email;
	    private String nni;
	    
	  private ImageModel image;
	    public ImageModel getImage() {
		return image;
	}
	public void setImage(ImageModel image) {
		this.image = image;
	}
		private TypeMobilite typeMobilite;
	   
        private Departement departement;
	    
		private Etabli_Partenaire choix1;
	   
		private Etabli_Partenaire choix2;
	    
		private Etabli_Partenaire choix3;
}
