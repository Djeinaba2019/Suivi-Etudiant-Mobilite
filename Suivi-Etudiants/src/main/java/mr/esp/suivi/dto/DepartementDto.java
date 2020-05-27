package mr.esp.suivi.dto;

import java.util.Collection;



import mr.esp.suivi.model.Etudiant;

public class DepartementDto {
	private String codeDep;
	public String getCodeDep() {
		return codeDep;
	}

	public void setCodeDep(String codeDep) {
		this.codeDep = codeDep;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	private String nom ;

    private Collection <Etudiant> etudiants;
}
