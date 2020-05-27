package mr.esp.suivi.repository;
import org.springframework.data.repository.CrudRepository;

import mr.esp.suivi.model.Etudiant;

public interface EtudiantRepository  extends CrudRepository<Etudiant, Integer> {

}
