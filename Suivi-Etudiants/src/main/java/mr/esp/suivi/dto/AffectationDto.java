package mr.esp.suivi.dto;

import javax.validation.constraints.NotBlank;

import mr.esp.suivi.model.Etudiant;
import mr.esp.suivi.model.Mobilite;

public class AffectationDto {
	
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Mobilite getMobilite() {
		return mobilite;
	}
	public void setMobilite(Mobilite mobilite) {
		this.mobilite = mobilite;
	}
	@NotBlank
	 private Etudiant etudiant;
	@NotBlank
	 private Mobilite mobilite;

}
