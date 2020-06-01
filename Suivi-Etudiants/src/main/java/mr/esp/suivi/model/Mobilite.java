package mr.esp.suivi.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Mobilite {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer id;
		
		@PastOrPresent
		@JsonFormat(pattern="dd-MM-yyyy")
		private Date annee;
		
		
		@OneToOne
	    private Departement departement;
	   
		
	   @OneToOne
		private EtablissementPartenaire ecoles;
	    
	    private String TypeMobilite;
	    
	    

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

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

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

		
		
		public Mobilite(@PastOrPresent
				@JsonFormat(pattern="dd-MM-yyyy") Date annee, Departement departement, EtablissementPartenaire ecoles,
				String typeMobilite) {
			super();
			this.annee = annee;
			this.departement = departement;
			this.ecoles = ecoles;
			TypeMobilite = typeMobilite;
		}

		public Mobilite() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
	   
	   

}
