package cinema.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cinema.persistence.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
