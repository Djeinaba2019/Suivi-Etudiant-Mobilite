package mr.esp.suivi.repository;

import org.springframework.data.repository.CrudRepository;

import mr.esp.suivi.model.Mobilite;
import mr.esp.suivi.model.User;

public interface UserRepository  extends CrudRepository<User, Integer>{

}
