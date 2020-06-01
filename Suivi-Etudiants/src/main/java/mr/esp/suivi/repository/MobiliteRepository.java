package mr.esp.suivi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import mr.esp.suivi.model.Affectation;
import mr.esp.suivi.model.Mobilite;

public interface MobiliteRepository extends CrudRepository<Mobilite, Integer>  {
	Optional<Mobilite> findById(int id);
}
