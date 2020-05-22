package mr.esp.springdemo.repository;

import org.springframework.data.repository.CrudRepository;

import mr.esp.springdemo.model.Departement;

public interface DepartementRepository extends CrudRepository<Departement, String>{

}
