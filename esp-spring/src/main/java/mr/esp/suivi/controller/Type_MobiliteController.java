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

import mr.esp.suivi.dto.Type_MobiliteDto;
import mr.esp.suivi.exception.ResourceNotFoundException;
import mr.esp.suivi.model.Type_Mobilite;
import mr.esp.suivi.repository.Type_MobiliteRepository;

@RestController
@RequestMapping(path="/typeMobilité")
public class Type_MobiliteController {
	 private static final Logger logger = LoggerFactory.getLogger(Type_MobiliteController.class);
	 
	 @Autowired
	 private Type_MobiliteRepository type_mobiliteRepository;
	 
	 @GetMapping(path="/all")
	 public Iterable<Type_Mobilite> getAllType(){
		 return type_mobiliteRepository.findAll();
	 }
	 
	 @GetMapping(path="/{id}")
	 public Type_Mobilite getTypeMobilite(@PathVariable Integer id) {
		 return type_mobiliteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Type Mobilité", "id", id));
	 }
	 
	    @DeleteMapping(path="/{id}")
	    public Type_Mobilite removeTypeMob(@PathVariable Integer id) {
	    	Type_Mobilite type = type_mobiliteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Type Mobilité", "id", id));
	    	type_mobiliteRepository.delete(type);
	    	return type;
	    }
	    
	    @PostMapping(path="/add")
	    public Type_Mobilite addTypeMob(@Valid @RequestBody Type_MobiliteDto type_Mob) {
	    	Type_Mobilite type = new Type_Mobilite();
	    	type.setNom_Mobilite(type.getNom_Mobilite());	  
	         
	    	Type_Mobilite TypeMOB = type_mobiliteRepository.save(type);
	    	logger.debug("New Mobility Type created with id {} " , TypeMOB.getId());
	    	return TypeMOB;
	    }
		
		

}
