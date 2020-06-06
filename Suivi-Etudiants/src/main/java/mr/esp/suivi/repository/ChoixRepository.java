package mr.esp.suivi.repository;

import org.springframework.data.repository.CrudRepository;

import mr.esp.suivi.model.Choix;
import mr.esp.suivi.model.Etudiant;
import mr.esp.suivi.model.Mobilite;



public interface ChoixRepository extends CrudRepository<Choix, Integer> {

	

	public Choix findByEntudiant_Matricule(Integer matricule);


	
	
}
