package mr.esp.suivi.dto;

import javax.validation.constraints.NotBlank;

import mr.esp.suivi.model.Etudiant;
import mr.esp.suivi.model.Mobilite;

public class AffectationDto {
	
	public String getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(String etudiant) {
		this.etudiant = etudiant;
	}
	public int getMobilite() {
		return mobilite;
	}
	public void setMobilite(int mobilite) {
		this.mobilite = mobilite;
	}
	@NotBlank
	 private String etudiant;
	
	 private int mobilite;
	public AffectationDto(@NotBlank String etudiant, @NotBlank int mobilite) {
		super();
		this.etudiant = etudiant;
		this.mobilite = mobilite;
	}
	public AffectationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
