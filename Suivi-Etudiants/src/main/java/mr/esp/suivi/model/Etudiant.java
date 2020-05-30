package mr.esp.suivi.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Etudiant")

public class Etudiant {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer matricule;

	public Integer getMatricule() {
		return matricule;
	}

	public void setMatricule(Integer matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNni() {
		return nni;
	}

	public void setNni(String nni) {
		this.nni = nni;
	}

	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dateDeNaissance;
	private String telephone;
	private String email;
	private String nni;


	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	@OneToOne
	private Departement departement;

	public Etudiant(String nom, String prenom, Date dateDeNaissance, String telephone, String email,
			String nni, Departement departement) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.telephone = telephone;
		this.email = email;
		this.nni = nni;
		this.departement = departement;
	}

	public Etudiant() {
		super();
		// TODO Auto-generated constructor stub
	}
	



}
