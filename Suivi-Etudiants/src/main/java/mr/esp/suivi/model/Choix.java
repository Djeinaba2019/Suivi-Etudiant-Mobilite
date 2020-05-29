package mr.esp.suivi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Choix")
public class Choix {
	@Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
    private Integer id;
	@OneToOne
	private Etudiant entudiant;
	
	 @OneToOne
	private Mobilite mobilite1;
	@OneToOne
	private Mobilite mobilite2;
	@OneToOne
	private Mobilite mobilite3;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Etudiant getEntudiant() {
		return entudiant;
	}
	public void setEntudiant(Etudiant entudiant) {
		this.entudiant = entudiant;
	}
	public Mobilite getMobilite1() {
		return mobilite1;
	}
	public void setMobilite1(Mobilite mobilite1) {
		this.mobilite1 = mobilite1;
	}
	public Mobilite getMobilite2() {
		return mobilite2;
	}
	public void setMobilite2(Mobilite mobilite2) {
		this.mobilite2 = mobilite2;
	}
	public Mobilite getMobilite3() {
		return mobilite3;
	}
	public void setMobilite3(Mobilite mobilite3) {
		this.mobilite3 = mobilite3;
	}
	public Choix(Etudiant entudiant, Mobilite mobilite1, Mobilite mobilite2, Mobilite mobilite3) {
		super();
		this.entudiant = entudiant;
		this.mobilite1 = mobilite1;
		this.mobilite2 = mobilite2;
		this.mobilite3 = mobilite3;
	}
	public Choix() {
		super();
		// TODO Auto-generated constructor stub
	}
	


}
