package mr.esp.suivi.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mr.esp.suivi.dto.AffectationDto;
import mr.esp.suivi.exception.ResourceNotFoundException;
import mr.esp.suivi.model.Affectation;
import mr.esp.suivi.repository.AffectationRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/affectation")
public class AffectationController {
	private static final Logger logger = LoggerFactory.getLogger(AffectationController.class);

	@Autowired
	private AffectationRepository affectationRepository;
	
	@GetMapping(path = "/all")
	public Iterable<Affectation> getAllAffectation() {
		return affectationRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public Affectation getAffectation(@PathVariable Integer id) {
		return affectationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Choix", "id", id));
	}
	
	@DeleteMapping(path = "/{id}")
	public Affectation deleteAffectation(@PathVariable Integer id) {
		Affectation affectation = affectationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Affectation", "id", id));
		affectationRepository.delete(affectation);
		return affectation;
	}
	
	@PostMapping(path = "/add")
	public Affectation addAffectation(@Valid @RequestBody AffectationDto affectationDto) {
		Affectation affectation = new Affectation();
		affectation.setEtudiant(affectationDto.getEtudiant());
		affectation.setMobilite(affectationDto.getMobilite());
		Affectation affectation1 = affectationRepository.save(affectation);
		logger.debug("New Affectation1 created with id {} !", affectation1.getId());
		return affectation1;
	}
	
}
