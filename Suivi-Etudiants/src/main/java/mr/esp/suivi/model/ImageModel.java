package mr.esp.suivi.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;



@Entity
public class ImageModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nom;
	
	private String type;
	
	
	@Lob
	private byte[] image;

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public ImageModel(String nom,String type, byte[] image) {
		super();
		this.nom = nom;
		this.type = type;
		this.image = image;
	}

	public ImageModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
