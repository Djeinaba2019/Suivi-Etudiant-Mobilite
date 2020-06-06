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

import com.sun.xml.bind.v2.model.core.ID;

import mr.esp.suivi.dto.EtablissementPartenaireDto;
import mr.esp.suivi.exception.ResourceNotFoundException;
import mr.esp.suivi.model.EtablissementPartenaire;
import mr.esp.suivi.repository.EtablissementPartenaireRepository;

@RestController
@RequestMapping(path="/ecole")
public class EtablissementPartenaireController {
	 private static final Logger logger = LoggerFactory.getLogger(EtablissementPartenaireController.class);

	 @Autowired
		private EtablissementPartenaireRepository etabli_PartenaireRepository;
	
	

		@GetMapping(path="/all")
		public Iterable<EtablissementPartenaire> getAllEtablissements() {
			return etabli_PartenaireRepository.findAll();
		}
		

		@GetMapping(path="/{id}")
		public EtablissementPartenaire getEtablissement(@PathVariable Integer id) {
			return etabli_PartenaireRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Etablissement", "id", id));
		}
		
		
		
		@DeleteMapping(path="/{id}")
		public EtablissementPartenaire deleteEtablissement(@PathVariable Integer id) {
			EtablissementPartenaire p = etabli_PartenaireRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Etablissement", "id", id));
			etabli_PartenaireRepository.delete(p);
			return p;
		}
		
		@PostMapping(path="/add")
		public EtablissementPartenaire addEtablissement (@Valid @RequestBody EtablissementPartenaireDto etablissement) {
			


			
			EtablissementPartenaire e = new EtablissementPartenaire();
			e.setNom(etablissement.getNom());
			e.setEmail(etablissement.getEmail());
			e.setAdresse(etablissement.getAdresse());
			e.setQuotas(etablissement.getQuotas());
			e.setSite_web(etablissement.getSite_web());
			e.setTelephone(etablissement.getTelephone());
			e.setPays(etablissement.getPays());
			e.setVille(etablissement.getVille());

			
			EtablissementPartenaire res = etabli_PartenaireRepository.save(e);
			logger.debug("New Etablissement created with id {} !", res.getNom());
			return res;
		}
		
	
		
		
	

}