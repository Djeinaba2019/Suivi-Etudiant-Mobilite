package mr.esp.suivi.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Departement")
public class Departement {
	
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
	
	public Collection<EtablissementPartenaire> getEcolesPartenaire() {
		return ecolesPartenaire;
	}
	public void setEcolesPartenaire(Collection<EtablissementPartenaire> ecolesPartenaire) {
		this.ecolesPartenaire = ecolesPartenaire;
	}

	@Id
	private String codeDep;
	private String nom ;
	@OneToMany
    private Collection <EtablissementPartenaire> ecolesPartenaire;
	public Departement(String codeDep, String nom, Collection<EtablissementPartenaire> ecolesPartenaire) {
		super();
		this.codeDep = codeDep;
		this.nom = nom;
		this.ecolesPartenaire = ecolesPartenaire;
	}
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
