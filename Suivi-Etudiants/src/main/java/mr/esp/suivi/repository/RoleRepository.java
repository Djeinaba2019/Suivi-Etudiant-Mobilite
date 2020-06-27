package mr.esp.suivi.repository;

import org.springframework.data.repository.CrudRepository;

import mr.esp.suivi.model.Role;


public interface RoleRepository  extends CrudRepository<Role, Integer>{
	
	//public Role findByRoleName(String role);

}
