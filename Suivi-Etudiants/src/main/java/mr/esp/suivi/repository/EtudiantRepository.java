package mr.esp.suivi.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mr.esp.suivi.model.EtablissementPartenaire;
import mr.esp.suivi.model.Etudiant;

public interface EtudiantRepository  extends CrudRepository<Etudiant, Integer> {
	
	@Query("SELECT E FROM Etudiant E where E.email= ?1 ")
	public Optional<Etudiant> findByEMail(String email);

}
