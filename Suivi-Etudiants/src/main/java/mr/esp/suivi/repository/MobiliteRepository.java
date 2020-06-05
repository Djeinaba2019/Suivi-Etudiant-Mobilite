package mr.esp.suivi.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mr.esp.suivi.model.Affectation;
import mr.esp.suivi.model.Mobilite;

public interface MobiliteRepository extends CrudRepository<Mobilite, Integer>  {
	Optional<Mobilite> findById(int id);
	
	

	Iterable<Mobilite> findByAnneeAndDepartement_CodeDep(Date annee, String codeDep);

	

	
}
