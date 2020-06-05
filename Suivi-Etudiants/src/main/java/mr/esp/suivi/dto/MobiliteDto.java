package mr.esp.suivi.dto;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

import mr.esp.suivi.model.Departement;
import mr.esp.suivi.model.EtablissementPartenaire;

public class MobiliteDto {

	
	   @PastOrPresent
	   @JsonFormat(pattern="yyyy")
	    private Date annee;
	   
		@NotBlank
		private String ecole ;
		
		
		@NotBlank
		private String departement;
		
		@NotBlank
		private String TypeMobilite;
		
		
		
		
		public String getDepartement() {
			return departement;
		}
		public void setDepartement(String departement) {
			this.departement = departement;
		}
		
		
	    
		
		public String getecole() {
			return ecole;
		}
		public void setId_ecole(String ecoles) {
			this.ecole = ecoles;
		}
		public Date getAnnee() {
			return annee;
		}
		public void setAnnee(Date annee) {
			this.annee = annee;
		}
		
	
		public String getTypeMobilite() {
			return TypeMobilite;
		}
		public void setTypeMobilite(String typeMobilite) {
			TypeMobilite = typeMobilite;
		}
		
		
		
		
		
		
		public MobiliteDto(@PastOrPresent Date annee,  @NotBlank String ecole,
				@NotBlank String departement, String typeMobilite) {
			super();
			this.annee = annee;
			this.ecole = ecole;
			this.departement = departement;
			TypeMobilite = typeMobilite;
		}
		public MobiliteDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
	    
}
