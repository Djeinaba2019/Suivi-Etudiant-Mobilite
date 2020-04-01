package mr.esp.suivi.dto;

import javax.validation.constraints.NotBlank;

public class Type_MobiliteDto {
	
@NotBlank	
private String nom_Mobilite;

public String getNom_Mobilite() {
	return nom_Mobilite;
}

public void setNom_Mobilite(String nom_Mobilite) {
	this.nom_Mobilite = nom_Mobilite;
}



}
