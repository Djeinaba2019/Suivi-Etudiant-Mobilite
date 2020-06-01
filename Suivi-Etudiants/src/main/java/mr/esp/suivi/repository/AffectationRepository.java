package mr.esp.suivi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import mr.esp.suivi.model.Affectation;
import mr.esp.suivi.model.Departement;

public interface AffectationRepository extends CrudRepository<Affectation, Integer> {
	

}
