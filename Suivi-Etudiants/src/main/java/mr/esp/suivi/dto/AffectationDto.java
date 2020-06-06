package mr.esp.suivi.dto;

import javax.validation.constraints.NotNull;



public class AffectationDto {
	

	public Integer getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Integer etudiant) {
		this.etudiant = etudiant;
	}
	public Integer getMobilite() {
		return mobilite;
	}
	public void setMobilite(Integer mobilite) {
		this.mobilite = mobilite;
	}
	@NotNull
	 private Integer etudiant;
	@NotNull
	 private Integer mobilite;
	public AffectationDto(@NotNull Integer etudiant, @NotNull Integer mobilite) {
		super();
		this.etudiant = etudiant;
		this.mobilite = mobilite;
	}
	public AffectationDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
