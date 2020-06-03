package mr.esp.suivi.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Departement")
public class Departement {
	@Id
	private String codeDep;
	
	private String nom ;
	
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

	
	@OneToMany
    private Collection <EtablissementPartenaire> ecolesPartenaire;
	
	
	
	public Departement(String codeDep, String nom) {
		super();
		this.codeDep = codeDep;
		this.nom = nom;
		
	}
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
