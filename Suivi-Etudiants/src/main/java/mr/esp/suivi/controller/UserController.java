package mr.esp.suivi.controller;

import java.util.Arrays;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mr.esp.suivi.dto.UserDto;
import mr.esp.suivi.exception.ResourceNotFoundException;
import mr.esp.suivi.model.EtablissementPartenaire;
import mr.esp.suivi.model.Etudiant;
import mr.esp.suivi.model.User;
import mr.esp.suivi.repository.EtudiantRepository;
import mr.esp.suivi.repository.RoleRepository;
import mr.esp.suivi.repository.UserRepository;


@RestController
@RequestMapping(path="/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository ;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	
	
	
	@GetMapping(path="/all")
	public Iterable<User> getAllEtablissements() {
		return userRepository.findAll();
	}
	
	@GetMapping(path="/{id}")
	public User getEtablissement(@PathVariable Integer id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Etablissement", "id", id));
	}
	
	
	@DeleteMapping(path="/{id}")
	public User deleteEtablissement(@PathVariable Integer id) {
		User u = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Etablissement", "id", id));
		userRepository.delete(u);
		return u;
	}
	
	@PostMapping(path="/register")
	public User registrationUser(@Valid @RequestBody UserDto userDto) {		
		//String email = userDto.getEmail();
		
		//verification de l'existance du mail dans la table etudiant
	//	Etudiant etudiant = new Etudiant();
	//	etudiant = etudiantRepository.findByEMail(email).orElseThrow();
		
		User user = new User();
		
		//if(etudiant != null) 	
		//user = userRepository.findByEMail(email).orElseThrow();
			
			/*if(userRepository.findByEMail(email).orElseThrow() != null) {
				logger.info("il y'a un utilisateur avec ce mail " +email);	
			}else {*/
			//sinon on inscrit étudiant 
			//user=register(userDto);
			//User user = new User();

			user.setUsername(userDto.getUsername());
			user.setEmail(userDto.getEmail());
			//String hashedPassword = passwordEncoder.encode(userDto.getPassword());
			user.setPassword(userDto.getPassword());
			user.setEnabled(userDto.isEnabled());
			
			//user.setRoles(Arrays.asList(roleRepository.findByRoleName("Etudiant")));
			
			User user1=userRepository.save(user);	//}
		
		logger.debug("New User created with id {} !", user.getEmail());
		return user1;
		
		
	
		
		
	}
	
	
	
	
/*	public User register(UserDto userDto) {
		User user = new User();
		
		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		//String hashedPassword = passwordEncoder.encode(userDto.getPassword());
		user.setPassword(userDto.getPassword());
		user.setEnabled(userDto.isEnabled());
		
		//user.setRoles(Arrays.asList(roleRepository.findByRoleName("Etudiant")));
		
		userRepository.save(user);
		
		return user;
		
		
	}*/
	
	

}
