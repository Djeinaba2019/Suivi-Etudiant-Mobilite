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


import mr.esp.suivi.dto.EtudiantDto;
import mr.esp.suivi.exception.ResourceNotFoundException;
import mr.esp.suivi.model.Etudiant;

import mr.esp.suivi.repository.EtudiantRepository;

@RestController
@RequestMapping(path="/etudiant")
@CrossOrigin(origins = "http://localhost:4200")
public class EtudiantController {
	private static final Logger logger = LoggerFactory.getLogger(EtudiantController.class);

	 @Autowired
		private EtudiantRepository etudiantRepository;
	

		@GetMapping(path="/all")
		public Iterable<Etudiant> getAllEtudiants() {
			return etudiantRepository.findAll();
		}
		

		@GetMapping(path="/{matricule}")
		public Etudiant getEtudiant(@PathVariable Integer matricule) {
			return etudiantRepository.findById(matricule).orElseThrow(() -> new ResourceNotFoundException("Etudiant", "matricule", matricule));
		}
		
		
		@DeleteMapping(path="/{matricule}")
		public Etudiant deleteEtudiant(@PathVariable Integer matricule) {
			Etudiant p = etudiantRepository.findById(matricule).orElseThrow(() -> new ResourceNotFoundException("Etudiant", "matricule", matricule));
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
			e.setDateDeNaissance(etudiant.getDateDeNaissance());
			e.setNni(etudiant.getNni());
			e.setMatricule(etudiant.getMatricule());
			//e.setPhoto(etudiant.getPhoto());
			e.setDepartement(etudiant.getDepartement());
		
			Etudiant res = etudiantRepository.save(e);
			logger.debug("New etudiant created with Matricule {} !", res.getMatricule());
			return res;
		}
		
		
		
		
		
		
}
