package mr.esp.suivi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import mr.esp.suivi.model.Departement;
import mr.esp.suivi.model.EtablissementPartenaire;

public interface DepartementRepository extends CrudRepository<Departement, String>{
	
	Optional<Departement> findById(String codeDep);
	
}
