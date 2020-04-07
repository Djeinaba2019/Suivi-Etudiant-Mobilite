package mr.esp.suivi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Departement_Etabli_Partenaire {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nom_departement;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom_departement() {
		return nom_departement;
	}

	public void setNom_departement(String nom_departement) {
		this.nom_departement = nom_departement;
	}

	
}
