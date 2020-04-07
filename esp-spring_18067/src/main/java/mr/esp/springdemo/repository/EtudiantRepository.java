package mr.esp.springdemo.repository;
import org.springframework.data.repository.CrudRepository;

import mr.esp.springdemo.model.Etudiant;

public interface EtudiantRepository  extends CrudRepository<Etudiant, Integer> {

}
