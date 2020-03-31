package mr.esp.springdemo.dto;


import javax.validation.constraints.NotBlank;


public class Etabli_PartenaireDto {

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return Pays;
	}
	public void setPays(String pays) {
		Pays = pays;
	}
	public String getType_Accords() {
		return type_Accords;
	}
	public void setType_Accords(String type_Accords) {
		this.type_Accords = type_Accords;
	}
	@NotBlank
	private String nom;
	@NotBlank
	private String ville;
	@NotBlank
	private String Pays ;
	@NotBlank
	private String type_Accords;
}
