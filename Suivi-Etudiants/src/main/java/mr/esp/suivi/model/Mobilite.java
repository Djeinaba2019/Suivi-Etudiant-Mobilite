package mr.esp.suivi.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Mobilite {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer id;
	
	   @Temporal(TemporalType.DATE)
		private Date annee;
	   
	   @OneToOne
	    private Departement departement;
	   
	   @OneToMany
		private Collection <EtablissementPartenaire> ecoles;
	    
	    private String TypeMobilite;
	    
	    

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

		
		
		public Mobilite(Date annee, Departement departement, Collection<EtablissementPartenaire> ecoles,
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
