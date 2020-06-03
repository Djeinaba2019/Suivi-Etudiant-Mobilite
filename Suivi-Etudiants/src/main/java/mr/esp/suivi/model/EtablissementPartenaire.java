package mr.esp.suivi.model;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class EtablissementPartenaire {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer id;

private String nom;

private int quotas;

private String email;

private String telephone;

private String adresse;

private String site_web;

private String ville;

private String Pays ;

@OneToOne(
	    cascade = CascadeType.ALL)
private ImageModel photo;





public ImageModel getPhoto() {
	return photo;
}

public void setPhoto(ImageModel photo) {
	this.photo = photo;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
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


	@OneToMany
    private Collection<Departement> departements;

	public Collection<Departement> getDepartements() {
		return departements;
	}

	public void setDepartements(Collection<Departement> departements) {
		this.departements = departements;
	}

	public EtablissementPartenaire(String nom, int quotas, String email, String telephone, String adresse,
			String site_web, String ville, String pays, ImageModel photo,
			Collection<Departement> departements) {
		super();
		this.nom = nom;
		this.quotas = quotas;
		this.email = email;
		this.telephone = telephone;
		this.adresse = adresse;
		this.site_web = site_web;
		this.ville = ville;
		Pays = pays;
		this.photo = photo;
		this.departements = departements;
	}

	public EtablissementPartenaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    

}