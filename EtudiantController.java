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
import mr.esp.springdemo.dto.EtudiantDto;
import mr.esp.springdemo.exception.ResourceNotFoundException;
import mr.esp.springdemo.model.Etabli_Partenaire;
import mr.esp.springdemo.model.Etudiant;
import mr.esp.springdemo.repository.Etabli_PartenaireRepository;
import mr.esp.springdemo.repository.EtudiantRepository;



@RestController
@RequestMapping(path="/etudiant")
public class EtudiantController {
	private static final Logger logger = LoggerFactory.getLogger(EtudiantController.class);

	 @Autowired
		private EtudiantRepository etudiantRepository;
	

		@GetMapping(path="/all")
		public Iterable<Etudiant> getAllEtudiants() {
			return etudiantRepository.findAll();
		}
		

		@GetMapping(path="/{matricule}")
		public Etudiant getEtudiant(@PathVariable Integer id) {
			return etudiantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Etudiant", "id", id));
		}
		
		
		@DeleteMapping(path="/{id}")
		public Etudiant deleteEtudiant(@PathVariable Integer id) {
			Etudiant p = etudiantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Etablissement", "id", id));
			etudiantRepository.delete(p);
			return p;
		}
		

		@PostMapping(path="/add")
		public Etudiant addEtudiant (@Valid @RequestBody EtudiantDto etudiant) {
			
			Etudiant e = new Etudiant();
			e.setNom(etudiant.getNom());
			e.setPrenom(etudiant.getPrenom());
			e.setEmail(etudiant.getEmail());
			e.setTelephone(etudiant.getTelephone());
			e.setDateDeNaissence(etudiant.getDateDeNaissence());
			e.setNni(etudiant.getNni());
			e.setMatricule(etudiant.getMatricule());
			e.setPhoto(etudiant.getPhoto());
			Etudiant res = etudiantRepository.save(e);
			logger.debug("New etudiant created with Matricule {} !", res.getMatricule());
			return res;
		}
		
		
		
		
		
		
}
