package mr.esp.suivi.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import mr.esp.suivi.dto.EtablissementPartenaireDto;
import mr.esp.suivi.exception.ResourceNotFoundException;
import mr.esp.suivi.model.EtablissementPartenaire;
import mr.esp.suivi.model.ImageModel;
import mr.esp.suivi.repository.EtablissementPartenaireRepository;


@RestController
@RequestMapping(path="/ecole")
public class EtablissementPartenaireController {
	 private static final Logger logger = LoggerFactory.getLogger(EtablissementPartenaireController.class);
	 
	 
	 private static String upload_Dir= System.getProperty("user.home")+"/test";
	 
	 String result= null;

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
		
		//controller pour ajouter les données de l'école partenaire
		
		@PostMapping(path="/add")
		public EtablissementPartenaire addEtablissement (@Valid @RequestBody EtablissementPartenaireDto etablissement) throws IOException {
			
			//ImageModel image = new ImageModel(file.getOriginalFilename(),file.getContentType(),file.getBytes());
			
			EtablissementPartenaire e = new EtablissementPartenaire();
			e.setNom(etablissement.getNom());
			e.setQuotas(etablissement.getQuotas());
			e.setEmail(etablissement.getEmail());
			e.setTelephone(etablissement.getTelephone());
			e.setAdresse(etablissement.getAdresse());
			e.setSite_web(etablissement.getSite_web());
			e.setVille(etablissement.getVille());
			e.setPays(etablissement.getPays());
			e.setType_Accords(etablissement.getType_Accords());
			e.setSpecialite(etablissement.getSpecialite());

					
			EtablissementPartenaire res = etabli_PartenaireRepository.save(e);
			logger.debug("New Etablissement created with id {} !", res.getId());
			return res;
		}
		
		
		
	//controller pour ajouter une image d'une école partenaire
		
	@PostMapping(path="/upload", consumes = { "multipart/form-data" })
		public String uploadFile(@RequestPart(name="photo", required = false) MultipartFile file) throws IOException {
			 logger.debug("un fichier sauvegardé");
			 ImageModel image = new ImageModel(file.getOriginalFilename(),file.getContentType(),file.getBytes());
			 try {
			 

				EtablissementPartenaire e = new EtablissementPartenaire();
				e.setPhoto(image);
				EtablissementPartenaire res=etabli_PartenaireRepository.save(e);
				logger.debug("image sauvegarder  !", res.getId());
			 return "success "+file.getOriginalFilename();}
			 catch(Exception e) {
				 return "erreur ";
			 }
			
		} 
		
		
			

		
		
		
		
		
		
}
