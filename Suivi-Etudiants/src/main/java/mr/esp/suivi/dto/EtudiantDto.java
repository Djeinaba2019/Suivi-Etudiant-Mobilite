package mr.esp.suivi.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

import mr.esp.suivi.model.Departement;
import mr.esp.suivi.model.EtablissementPartenaire;
import mr.esp.suivi.model.ImageModel;


public class EtudiantDto {
	@NotBlank
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
	@NotBlank
	private Departement departement;
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
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
	
}
