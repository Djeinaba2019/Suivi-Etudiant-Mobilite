package mr.esp.suivi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mr.esp.suivi.model.Etudiant;
import mr.esp.suivi.model.Mobilite;
import mr.esp.suivi.model.User;

public interface UserRepository  extends CrudRepository<User, Integer>{
	
	@Query("SELECT U FROM User U where U.email= ?1 ")
	public Optional<User> findByEMail(String email);
   

}
