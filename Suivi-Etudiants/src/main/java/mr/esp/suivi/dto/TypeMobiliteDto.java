package mr.esp.suivi.dto;

import java.util.Collection;

import javax.validation.constraints.NotBlank;

import mr.esp.suivi.model.Etudiant;

public class TypeMobiliteDto {
	@NotBlank
	 private String libelle;
	
	 public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	private Collection <Etudiant> etudiants;
}
