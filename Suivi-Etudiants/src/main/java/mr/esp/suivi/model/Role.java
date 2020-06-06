package mr.esp.suivi.model;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nomRole;
	
	@OneToMany
	List<User> user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomRole() {
		return nomRole;
	}

	public void setNomRole(String nomRole) {
		this.nomRole = nomRole;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(String nomRole, List<User> user) {
		super();
		this.nomRole = nomRole;
		this.user = user;
	} 
	
	
	
	
	

}
