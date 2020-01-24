package cinema.service;

import java.util.List;
import java.util.Optional;

import cinema.persistence.entity.Person;

public interface IPersonService {
	
	public List<Person> getAllPerson ();	
	public Optional<Person> getPersonById(int idPerson);
}
