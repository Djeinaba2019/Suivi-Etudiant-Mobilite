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
			e.setChoix1(etudiant.getChoix1());
			e.setChoix2(etudiant.getChoix2());
			e.setChoix3(etudiant.getChoix3());
			e.setDepartement(etudiant.getDepartement());
			e.setTypeMobilite(etudiant.getTypeMobilite());
			Etudiant res = etudiantRepository.save(e);
			logger.debug("New etudiant created with Matricule {} !", res.getMatricule());
			return res;
		}
		
		
		
		
		
		
}
