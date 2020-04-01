package mr.esp.suivi.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Type_Mobilite {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nom_Mobilite;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom_Mobilite() {
		return nom_Mobilite;
	}

	public void setNom_Mobilite(String nom_Mobilite) {
		this.nom_Mobilite = nom_Mobilite;
	}
}
