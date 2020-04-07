package mr.esp.suivi.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mr.esp.suivi.exception.ResourceNotFoundException;
import mr.esp.suivi.model.Specialite_Etabli_Partenaire;
import mr.esp.suivi.repository.Specialite_PartenaireRepository;
import mr.esp.suivi.dto.Specialite_PartenaireDto;

@RestController
@RequestMapping(path="/spe_Partenaire")
public class Specialite_PartenaireController {
	 private static final Logger logger = LoggerFactory.getLogger(Specialite_PartenaireController.class);
	 
	 @Autowired
	 private Specialite_PartenaireRepository spe_repo ;
	 
	 
	 @GetMapping(path="/all")
	 public Iterable<Specialite_Etabli_Partenaire> getAllSpe(){
		 return spe_repo.findAll();
	 }
	 
	 @GetMapping(path="/{id}")
	 public Specialite_Etabli_Partenaire getSpeMobilite(@PathVariable Integer id) {
		 return spe_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Specialité", "id", id));
	 }
	 
	 @DeleteMapping(path="/{id}")
	 public Specialite_Etabli_Partenaire removeSpePartenaire(@PathVariable Integer id) {
		 Specialite_Etabli_Partenaire s = spe_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Specialité", "id", id));
	     spe_repo.delete(s);
		 return s;
	 }
	 
	 @PostMapping(path="/add")
	 public Specialite_Etabli_Partenaire addSpeMobilite(@Valid @RequestBody  Specialite_PartenaireDto spe) {
		 
		 Specialite_Etabli_Partenaire specialite = new Specialite_Etabli_Partenaire();
		 
		 specialite.setNom_Specialite(spe.getNom_Specialite());
		 
		 Specialite_Etabli_Partenaire res = spe_repo.save(specialite);
		 logger.debug("New speciality created with id {} ",res.getId());
		 return res;
	 }
	 
	 
	 
	

}
