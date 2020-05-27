package mr.esp.springdemo.model;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

private String type_Accords;


@Temporal(TemporalType.DATE)
private Date date_Accords;

public Date getDate_Accords() {
	return date_Accords;
}

public void setDate_Accords(Date date_Accords) {
	this.date_Accords = date_Accords;
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

public String getType_Accords() {
	return type_Accords;
}

public void setType_Accords(String type_Accords) {
	this.type_Accords = type_Accords;
}

    public Collection<Etudiant> getEtudiants() {
	return etudiants;
}

public void setEtudiants(Collection<Etudiant> etudiants) {
	this.etudiants = etudiants;
}

	@OneToMany
    private Collection<Etudiant> etudiants;
    

}
