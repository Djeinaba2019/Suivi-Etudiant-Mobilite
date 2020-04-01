package mr.esp.suivi.repository;

import org.springframework.data.repository.CrudRepository;

import mr.esp.suivi.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
