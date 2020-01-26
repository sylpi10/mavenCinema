package cinema.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cinema.persistence.entity.Person;
import cinema.persistence.repository.MovieRepository;
import cinema.persistence.repository.PersonRepository;
import cinema.service.IPersonService;


@Service
@Transactional
public class PersonService implements IPersonService{
	
	@Autowired
	MovieRepository movieRepository;

	@Autowired
	PersonRepository personRepository;
	
	@Override
	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}
	
	@Override
	public Optional<Person> getPersonById(int idPerson) {
		return personRepository.findById(idPerson);
	}

	@Override
	public Set<Person> getByNameIgnoreCaseContaining(String partialName) {
		return null;
	}

	@Override
	public Set<Person> getByBirthDateYear(int year) {
		return null;
	}
}
