package mr.esp.suivi.dto;

import javax.validation.constraints.NotBlank;

public class Specialite_PartenaireDto {
	
	@NotBlank
	private String nom_Specialite;

	public String getNom_Specialite() {
		return nom_Specialite;
	}

	public void setNom_Specialite(String nom_Specialite) {
		this.nom_Specialite = nom_Specialite;
	}
	
	

}
