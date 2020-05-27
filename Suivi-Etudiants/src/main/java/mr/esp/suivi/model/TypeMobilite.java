package mr.esp.suivi.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TypeMobilite")
public class TypeMobilite {
	@Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
    private Integer typeMobilite_Id;
	
	public Integer getTypeMobilite_Id() {
		return typeMobilite_Id;
	}
	public void setTypeMobilite_Id(Integer typeMobilite_Id) {
		this.typeMobilite_Id = typeMobilite_Id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Collection<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(Collection<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	@Column(name = "libelle")
	 private String libelle;
	@OneToMany
	    private Collection <Etudiant> etudiants;
}
