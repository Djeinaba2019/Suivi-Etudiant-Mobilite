package mr.esp.springdemo.controller;





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

import mr.esp.springdemo.dto.Etabli_PartenaireDto;
import mr.esp.springdemo.exception.ResourceNotFoundException;
import mr.esp.springdemo.model.Etabli_Partenaire;
import mr.esp.springdemo.repository.Etabli_PartenaireRepository;



@RestController
@RequestMapping(path="/ecole")
public class Etabli_PartenaireController {
	 private static final Logger logger = LoggerFactory.getLogger(Etabli_PartenaireController.class);

	 @Autowired
		private Etabli_PartenaireRepository etabli_PartenaireRepository;
	

		@GetMapping(path="/all")
		public Iterable<Etabli_Partenaire> getAllEtablissements() {
			return etabli_PartenaireRepository.findAll();
		}
		

		@GetMapping(path="/{id}")
		public Etabli_Partenaire getEtablissement(@PathVariable Integer id) {
			return etabli_PartenaireRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Etablissement", "id", id));
		}
		
		@DeleteMapping(path="/{id}")
		public Etabli_Partenaire deleteEtablissement(@PathVariable Integer id) {
			Etabli_Partenaire p = etabli_PartenaireRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Etablissement", "id", id));
			etabli_PartenaireRepository.delete(p);
			return p;
		}
		
		@PostMapping(path="/add")
		public Etabli_Partenaire addEtablissement (@Valid @RequestBody Etabli_PartenaireDto etablissement) {
			
			Etabli_Partenaire e = new Etabli_Partenaire();
			e.setNom(etablissement.getNom());
			e.setEmail(etablissement.getEmail());
			e.setAdresse(etablissement.getAdresse());
			e.setQuotas(etablissement.getQuotas());
			e.setSite_web(etablissement.getSite_web());
			e.setTelephone(etablissement.getTelephone());
			e.setPays(etablissement.getPays());
			e.setVille(etablissement.getVille());
			e.setType_Accords(etablissement.getType_Accords());
			e.setDate_Accords(etablissement.getDate_Accords());
			
			
			Etabli_Partenaire res = etabli_PartenaireRepository.save(e);
			logger.debug("New Etablissement created with id {} !", res.getId());
			return res;
		}
		
		
		
		
		
		
		
		
}
