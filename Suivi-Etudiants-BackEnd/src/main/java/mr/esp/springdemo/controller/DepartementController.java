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
import mr.esp.springdemo.dto.DepartementDto;
import mr.esp.springdemo.exception.ResourceNotFoundException;
import mr.esp.springdemo.model.Departement;
import mr.esp.springdemo.repository.DepartementRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/departement")
public class DepartementController {
	private static final Logger logger = LoggerFactory.getLogger(DepartementController.class);
	
	 @Autowired
		private DepartementRepository departementRepository;
	 
	 @GetMapping(path="/all")
	 public Iterable<Departement> getAllDepartement()
	 {
		 return departementRepository.findAll();
	 }
	 
	 @GetMapping(path="/{codeDep}")
	 public Departement getDepartement(@PathVariable String codeDep) {
			return departementRepository.findById(codeDep).orElseThrow(() -> new ResourceNotFoundException("Departement", "codeDep", codeDep));
		}
	 @DeleteMapping(path="/{codeDep}")
		public Departement deleteDepartement(@PathVariable String codeDep) {
			Departement dep = departementRepository.findById(codeDep).orElseThrow(() -> new ResourceNotFoundException("Departement", "codeDep", codeDep));
			departementRepository.delete(dep);
			return dep;
		}

		@PostMapping(path="/add")
		public Departement addDepartement (@Valid @RequestBody DepartementDto departement) {
	  Departement dep = new Departement();
	  dep.setCodeDep(departement.getCodeDep());
	  dep.setNom(departement.getNom());
	  
	  Departement dep1 = departementRepository.save(dep);
	  logger.debug("New department created with codeDep {} !", dep1.getCodeDep());
		return dep1;
		}
		
		
			
}
