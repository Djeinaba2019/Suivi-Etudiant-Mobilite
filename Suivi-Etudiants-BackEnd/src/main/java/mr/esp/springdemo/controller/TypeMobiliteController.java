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
import mr.esp.springdemo.dto.TypeMobiliteDto;
import mr.esp.springdemo.exception.ResourceNotFoundException;
import mr.esp.springdemo.model.Departement;
import mr.esp.springdemo.model.TypeMobilite;
import mr.esp.springdemo.repository.TypeMobiliteRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/typeMobilite")
public class TypeMobiliteController {
	private static final Logger logger = LoggerFactory.getLogger(TypeMobiliteController.class);
	
	 @Autowired
		private TypeMobiliteRepository typeMobiliteRepository;

	 
	 
	 @GetMapping(path="/all")
	 public Iterable<TypeMobilite> getAllTypeMobilite()
	 {
		 return typeMobiliteRepository.findAll();
	 }
	 
	 @GetMapping(path="/{id}")
	 public TypeMobilite getTypeMobilite(@PathVariable Integer id) {
			return typeMobiliteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TypeMobilite", "id", id));
		}
	 @DeleteMapping(path="/{id}")
		public TypeMobilite deleteTypeMobilite(@PathVariable Integer id) {
		 TypeMobilite typeMob = typeMobiliteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("TypeMobilite", "id", id));
			typeMobiliteRepository.delete(typeMob);
			return typeMob;
		}

		@PostMapping(path="/add")
		public TypeMobilite addTypeMobilite (@Valid @RequestBody TypeMobiliteDto typeMobDto) {
			TypeMobilite typeMob = new TypeMobilite();
			typeMob.setLibelle(typeMobDto.getLibelle()); 	  
			TypeMobilite typeMob1 = typeMobiliteRepository.save(typeMob);
	  logger.debug("New department created with codeDep {} !", typeMob1.getLibelle());
		return typeMob1;
		}
		
}
