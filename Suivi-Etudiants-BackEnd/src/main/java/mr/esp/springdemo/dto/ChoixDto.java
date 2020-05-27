package mr.esp.springdemo.dto;


import mr.esp.springdemo.model.Etudiant;
import mr.esp.springdemo.model.Mobilite;

public class ChoixDto {

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

	private Integer id;
		
		private Etudiant entudiant;
		
		private Mobilite mobilite1;
	
		private Mobilite mobilite2;
	
		private Mobilite mobilite3;
}
