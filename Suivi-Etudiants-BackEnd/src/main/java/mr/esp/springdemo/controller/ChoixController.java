package mr.esp.springdemo.controller;

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

import mr.esp.springdemo.dto.ChoixDto;
import mr.esp.springdemo.dto.DepartementDto;
import mr.esp.springdemo.exception.ResourceNotFoundException;
import mr.esp.springdemo.model.Choix;
import mr.esp.springdemo.model.Departement;
import mr.esp.springdemo.repository.ChoixRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/Choix")
public class ChoixController {
	private static final Logger logger = LoggerFactory.getLogger(ChoixController.class);

	@Autowired
	private ChoixRepository choixRepository;
	
	@GetMapping(path = "/all")
	public Iterable<Choix> getAllChoix() {
		return choixRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public Choix getChoix(@PathVariable Integer id) {
		return choixRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Choix", "id", id));
	}
	
	@DeleteMapping(path = "/{id}")
	public Choix deleteChoix(@PathVariable Integer id) {
		Choix choix = choixRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Choix", "id", id));
		choixRepository.delete(choix);
		return choix;
	}
	
	@PostMapping(path = "/add")
	public Choix addChoix(@Valid @RequestBody ChoixDto choixDto) {
		Choix choix1 = new Choix();
		choix1.setEntudiant(choixDto.getEntudiant());
		choix1.setMobilite1(choixDto.getMobilite1());
		choix1.setMobilite2(choixDto.getMobilite2());
		choix1.setMobilite3(choixDto.getMobilite3());
		Choix choix2 = choixRepository.save(choix1);
		logger.debug("New Choix created with id {} !", choix2.getId());
		return choix2;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
