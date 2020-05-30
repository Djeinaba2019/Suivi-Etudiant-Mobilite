package mr.esp.suivi.dto;

import java.util.Collection;
import java.util.Date;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

import mr.esp.suivi.model.Departement;
import mr.esp.suivi.model.EtablissementPartenaire;

public class MobiliteDto {

	
	   @PastOrPresent
	   @JsonFormat(pattern="dd-MM-yyyy")
	    private Date annee;
	   
	   	@OneToOne
	    private Departement departement;
	   
	    @OneToOne
		private EtablissementPartenaire ecoles;
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
		
		public EtablissementPartenaire getEcoles() {
			return ecoles;
		}
		public void setEcoles(EtablissementPartenaire ecoles) {
			this.ecoles = ecoles;
		}
		public String getTypeMobilite() {
			return TypeMobilite;
		}
		public void setTypeMobilite(String typeMobilite) {
			TypeMobilite = typeMobilite;
		}
		public MobiliteDto(@PastOrPresent Date annee, Departement departement,
				EtablissementPartenaire ecoles, @NotBlank String typeMobilite) {
			super();
			this.annee = annee;
			this.departement = departement;
			this.ecoles = ecoles;
			TypeMobilite = typeMobilite;
		}
		public MobiliteDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
	    
}
