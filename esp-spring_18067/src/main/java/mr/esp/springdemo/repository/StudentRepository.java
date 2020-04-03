package mr.esp.springdemo.repository;

import org.springframework.data.repository.CrudRepository;

import mr.esp.springdemo.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
