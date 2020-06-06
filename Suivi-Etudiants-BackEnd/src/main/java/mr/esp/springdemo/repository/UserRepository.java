package mr.esp.springdemo.repository;

import org.springframework.data.repository.CrudRepository;
import mr.esp.springdemo.model.User;
public interface UserRepository extends CrudRepository<User, Integer> {

}