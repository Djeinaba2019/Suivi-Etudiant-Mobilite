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

import mr.esp.suivi.dto.ChoixDto;

import mr.esp.suivi.exception.ResourceNotFoundException;
import mr.esp.suivi.model.Choix;

import mr.esp.suivi.repository.ChoixRepository;
import mr.esp.suivi.repository.EtudiantRepository;
import mr.esp.suivi.repository.MobiliteRepository;

@RestController
@RequestMapping(path = "/choix")
public class ChoixController {
	private static final Logger logger = LoggerFactory.getLogger(ChoixController.class);

	@Autowired
	private ChoixRepository choixRepository;
	@Autowired
	private MobiliteRepository mobiliteRepository;
	 @Autowired
		private EtudiantRepository etudiantRepository;
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
		choix1.setEntudiant(etudiantRepository.findById(choixDto.getEtudiantId()).orElseThrow());
		choix1.setMobilite1(mobiliteRepository.findById(choixDto.getMobilite1Id()).orElseThrow());
		choix1.setMobilite2(mobiliteRepository.findById(choixDto.getMobilite2Id()).orElseThrow());
		choix1.setMobilite3(mobiliteRepository.findById(choixDto.getMobilite3Id()).orElseThrow());
		Choix choix2 = choixRepository.save(choix1);
		logger.debug("New Choix created with id {} !", choix2.getId());
		return choix2;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
