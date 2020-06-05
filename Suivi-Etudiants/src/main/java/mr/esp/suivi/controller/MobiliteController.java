package mr.esp.suivi.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;  

import java.util.Optional;

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
import mr.esp.suivi.dto.MobiliteDto;
import mr.esp.suivi.exception.ResourceNotFoundException;
import mr.esp.suivi.model.Departement;
import mr.esp.suivi.model.EtablissementPartenaire;
import mr.esp.suivi.model.Mobilite;
import mr.esp.suivi.repository.DepartementRepository;
import mr.esp.suivi.repository.EtablissementPartenaireRepository;
import mr.esp.suivi.repository.MobiliteRepository;

@RestController
@RequestMapping(path="/mobilite")
public class MobiliteController {
	private static final Logger logger = LoggerFactory.getLogger(MobiliteController.class);

	 @Autowired
		private MobiliteRepository mobiliteRepository;
	 @Autowired
	 	private EtablissementPartenaireRepository ecoleRepo;
	 @Autowired
	 	private DepartementRepository depRepo;
        
	 
	 @GetMapping(path="/all")
		public Iterable<Mobilite> getAllMobilites() {
			return mobiliteRepository.findAll();
		}
	 

	 @GetMapping(path="/mobilite_{date}/{codeDep}")
	 Iterable<Mobilite> getMobilitebyDep(@PathVariable String date, @PathVariable String codeDep) throws ParseException {
		    Date annee=new SimpleDateFormat("yyyy").parse(date);  
		return mobiliteRepository.findByAnneeAndDepartement_CodeDep(annee, codeDep);
	 }
	 
		@GetMapping(path="/{id}")
		public Mobilite getMobilite(@PathVariable Integer id) {
			return mobiliteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Mobilite", "id", id));
		}
		
		
		@DeleteMapping(path="/{id}")
		public Mobilite deleteMobilite(@PathVariable Integer id) {
			Mobilite mobilite = mobiliteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Mobilite", "id", id));
			mobiliteRepository.delete(mobilite);
			return mobilite;
		}
		
		@PostMapping(path="/add")
		public Mobilite addMobilite(@Valid @RequestBody MobiliteDto mobiliteDto) {
			
			
			
          Mobilite mob = new Mobilite();
          mob.setTypeMobilite(mobiliteDto.getTypeMobilite());
          mob.setAnnee(mobiliteDto.getAnnee());
          mob.setDepartement(depRepo.findById(mobiliteDto.getDepartement()).orElseThrow());
          String ecole =mobiliteDto.getecole();
          mob.setEcoles(ecoleRepo.findByName(ecole).orElseThrow());
          
		  Mobilite mobilite = mobiliteRepository.save(mob);
			logger.debug("New Mobilite created with id {} !", mobilite.getId());
			return mobilite;
		}
		
		
	 
	 
	 
	 
	 
	 
}
