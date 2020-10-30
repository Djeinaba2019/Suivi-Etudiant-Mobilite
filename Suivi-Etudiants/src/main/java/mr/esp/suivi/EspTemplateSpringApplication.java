package mr.esp.suivi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import mr.esp.suivi.model.Etudiant;
import mr.esp.suivi.repository.EtudiantRepository;


@SpringBootApplication
public class EspTemplateSpringApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EspTemplateSpringApplication.class, args);
	
	}

}
