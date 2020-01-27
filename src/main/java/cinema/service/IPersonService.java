package cinema.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
<<<<<<< HEAD

import org.springframework.data.jpa.repository.Query;
=======
>>>>>>> 3e4390e761cf8af8b2642aeb7d8044bfef3e7015

import cinema.persistence.entity.Movie;
import cinema.persistence.entity.Person;

public interface IPersonService {
	List<Person> getAllPersons();
	Optional<Person> getPersonById(int idPerson);
	Set<Person> getPersonsByNameEndingWithIgnoreCase(String name);
	Set<Person> getPersonsByNameContainingIgnoreCase(String partialName);
	
	@Query("select p from Person p where extract(year from p.birthdate) = ?1")
	Set<Person> getPersonsByBirthdateYear(int year);
	
	Person addPerson(Person person);
	Optional<Person> modifyPerson(Person person);
	Optional<Person> deletePerson(int idPerson);
	
<<<<<<< HEAD
}
=======
	public List<Person> getAllPerson ();	
	public Optional<Person> getPersonById(int idPerson);
	public Set<Person> getByNameIgnoreCaseContaining(String partialName);
	public Set<Person> getByBirthDateYear(int year);
}
>>>>>>> 3e4390e761cf8af8b2642aeb7d8044bfef3e7015
