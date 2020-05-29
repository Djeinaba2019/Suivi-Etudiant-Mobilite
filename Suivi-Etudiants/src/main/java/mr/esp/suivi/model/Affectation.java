package mr.esp.suivi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Affectation {
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Mobilite getMobilite() {
		return mobilite;
	}
	public void setMobilite(Mobilite mobilite) {
		this.mobilite = mobilite;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@OneToOne
 private Etudiant etudiant;
	@OneToOne
 private Mobilite mobilite;
	public Affectation(Etudiant etudiant, Mobilite mobilite) {
		super();
		this.etudiant = etudiant;
		this.mobilite = mobilite;
	}
	public Affectation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
 
}
