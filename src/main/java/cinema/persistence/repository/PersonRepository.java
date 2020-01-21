package cinema.persistence.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import cinema.persistence.entity.Movie;
import cinema.persistence.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{
	
	Set<Person> findByName(String name);
}
