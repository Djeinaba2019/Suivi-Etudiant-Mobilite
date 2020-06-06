package mr.esp.springdemo.dto;

import javax.management.relation.Role;
import javax.validation.constraints.NotBlank;

public class UserDto{
	@NotBlank
private int id_Utilisateur;
private int nom_Utilisateur;
private String  mot_de_passe;
private String  Email_esp;
private Role role;
public int getId_Utilisateur() {
	return id_Utilisateur;
}
public String getEmail_esp() {
	return Email_esp;
}
public void setEmail_esp(String email_esp) {
	Email_esp = email_esp;
}
public void setId_Utilisateur(int id_Utilisateur) {
	this.id_Utilisateur = id_Utilisateur;
}
public int getNom_Utilisateur() {
	return nom_Utilisateur;
}
public void setNom_Utilisateur(int nom_Utilisateur) {
	this.nom_Utilisateur = nom_Utilisateur;
}
public String getMot_de_passe() {
	return mot_de_passe;
}
public void setMot_de_passe(String mot_de_passe) {
	this.mot_de_passe = mot_de_passe;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
}
