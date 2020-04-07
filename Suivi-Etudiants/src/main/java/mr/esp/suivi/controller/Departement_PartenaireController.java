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

import mr.esp.suivi.dto.Departement_PartenaireDto;
import mr.esp.suivi.exception.ResourceNotFoundException;
import mr.esp.suivi.model.Departement_Etabli_Partenaire;
import mr.esp.suivi.model.Etabli_Partenaire;
import mr.esp.suivi.repository.Departement_PartenaireRepository;

@RestController
@RequestMapping(path="/departement_partenaire")
public class Departement_PartenaireController {
	
	private static final Logger logger = LoggerFactory.getLogger(Departement_PartenaireController.class);
	
	
	@Autowired
	private Departement_PartenaireRepository dpt_repo;
	
	@GetMapping(path="/all")
	public Iterable<Departement_Etabli_Partenaire> getAllDepartements(){
		return dpt_repo.findAll();
	}
	
	@GetMapping(path="/{id}")
	public Departement_Etabli_Partenaire getDept(@PathVariable Integer id) {
		return dpt_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Departement École Partenaire", "id", id));
	}
	
	@DeleteMapping(path="/{id}")
	public Departement_Etabli_Partenaire deletedpt(@PathVariable Integer id) {
		Departement_Etabli_Partenaire p = dpt_repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Departement École Partenaire", "id", id));
		dpt_repo.delete(p);
		return p;
	}
	
	@PostMapping(path="/add")
	public Departement_Etabli_Partenaire adddepartement(@Valid @RequestBody Departement_PartenaireDto departement) {
		
		Departement_Etabli_Partenaire d = new Departement_Etabli_Partenaire();
		d.setNom_departement(departement.getNom_departement());
		
		Departement_Etabli_Partenaire res = dpt_repo.save(d);
		logger.debug("New Departement created with id {} !", res.getId());
		return res;
		
	}
	
	
	
	

}
