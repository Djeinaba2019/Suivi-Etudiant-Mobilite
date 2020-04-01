package mr.esp.suivi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Specialite_Etabli_Partenaire {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nom_Specialite;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom_Specialite() {
		return nom_Specialite;
	}

	public void setNom_Specialite(String nom_Specialite) {
		this.nom_Specialite = nom_Specialite;
	}
	
	

}
