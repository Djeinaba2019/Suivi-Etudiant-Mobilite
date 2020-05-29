package mr.esp.suivi.dto;

import java.util.Collection;

import mr.esp.suivi.model.EtablissementPartenaire;

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



	private String nom ;

    private Collection <EtablissementPartenaire> ecolesPartenaire;

	public Collection<EtablissementPartenaire> getEcolesPartenaire() {
		return ecolesPartenaire;
	}

	public void setEcolesPartenaire(Collection<EtablissementPartenaire> ecolesPartenaire) {
		this.ecolesPartenaire = ecolesPartenaire;
	}
}
