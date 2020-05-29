package mr.esp.suivi.dto;

import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

import mr.esp.suivi.model.Departement;
import mr.esp.suivi.model.EtablissementPartenaire;

public class MobiliteDto {

	
	   @PastOrPresent
	   @JsonFormat(pattern="dd-MM-yyyy")
	    private Date annee;
	   
	  
	    private Departement departement;
	   
	 
		private Collection <EtablissementPartenaire> ecoles;
		@NotBlank
	    private String TypeMobilite;
		public Date getAnnee() {
			return annee;
		}
		public void setAnnee(Date annee) {
			this.annee = annee;
		}
		public Departement getDepartement() {
			return departement;
		}
		public void setDepartement(Departement departement) {
			this.departement = departement;
		}
		public Collection<EtablissementPartenaire> getEcoles() {
			return ecoles;
		}
		public void setEcoles(Collection<EtablissementPartenaire> ecoles) {
			this.ecoles = ecoles;
		}
		public String getTypeMobilite() {
			return TypeMobilite;
		}
		public void setTypeMobilite(String typeMobilite) {
			TypeMobilite = typeMobilite;
		}
	    
}
