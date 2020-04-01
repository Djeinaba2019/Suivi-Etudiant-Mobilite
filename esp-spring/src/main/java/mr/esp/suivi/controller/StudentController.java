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

import mr.esp.suivi.dto.StudentsDto;
import mr.esp.suivi.exception.ResourceNotFoundException;
import mr.esp.suivi.model.Student;
import mr.esp.suivi.repository.StudentRepository;

@RestController
@RequestMapping(path="/student")
public class StudentController {
	
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@GetMapping(path="/all")
	public Iterable<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	@GetMapping(path="/{id}")
	public Student getStudent(@PathVariable Integer id) {
		return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));
	}
	
	@DeleteMapping(path="/{id}")
	public Student deleteStudent(@PathVariable Integer id) {
		Student p = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Patient", "id", id));
		studentRepository.delete(p);
		return p;
	}
	
	@PostMapping(path="/add")
	public Student addPatient (@Valid @RequestBody StudentsDto student) {
		
		Student s = new Student();
		s.setName(student.getName());
		s.setSurname(student.getSurname());
		s.setDateOfBirth(student.getDateOfBirth());
		
		Student res = studentRepository.save(s);
		logger.debug("New student created with id {} !", res.getId());
		return res;
	}

}
