package cinema.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cinema.persistence.entity.Movie;
import cinema.persistence.entity.Person;

public interface IPersonService {
	
	public List<Person> getAllPerson ();	
	public Optional<Person> getPersonById(int idPerson);
	public Set<Person> getByNameIgnoreCaseContaining(String partialName);
	public Set<Person> getByBirthDateYear(int year);
}
