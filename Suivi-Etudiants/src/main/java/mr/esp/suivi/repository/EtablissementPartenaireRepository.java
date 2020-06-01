package mr.esp.suivi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import mr.esp.suivi.model.Departement;
import mr.esp.suivi.model.EtablissementPartenaire;

public interface EtablissementPartenaireRepository extends CrudRepository<EtablissementPartenaire, String> {

		
	@Query("SELECT E FROM EtablissementPartenaire E where E.nom= ?1 ")
	public Optional<EtablissementPartenaire> findByName(String nom);
	
}
