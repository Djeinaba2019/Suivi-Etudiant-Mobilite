package mr.esp.springdemo.model;

import javax.management.relation.Role;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	@Id
	private Integer matricule;
	private String nom_Utilisateur;
	private String email_Utilisateur;
	private Role Utlisateurs;
	public Integer getMatricule() {
		return matricule;
	}
	public void setMatricule(Integer matricule) {
		this.matricule = matricule;
	}
	public String getNom_Utilisateur() {
		return nom_Utilisateur;
	}
	public void setNom_Utilisateur(String nom_Utilisateur) {
		this.nom_Utilisateur = nom_Utilisateur;
	}
	public String getEmail_Utilisateur() {
		return email_Utilisateur;
	}
	public void setEmail_Utilisateur(String email_Utilisateur) {
		this.email_Utilisateur = email_Utilisateur;
	}
	public Role getUtlisateurs() {
		return Utlisateurs;
	}
	public void setUtlisateurs(Role utlisateurs) {
		Utlisateurs = utlisateurs;
	}
}
