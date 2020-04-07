package mr.esp.suivi.dto;

import javax.validation.constraints.NotBlank;

public class Departement_PartenaireDto {
	
	@NotBlank
	private String nom_departement;

	public String getNom_departement() {
		return nom_departement;
	}

	public void setNom_departement(String nom_departement) {
		this.nom_departement = nom_departement;
	}
	
	

}
