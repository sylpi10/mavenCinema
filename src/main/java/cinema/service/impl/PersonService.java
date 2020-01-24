package cinema.service.impl;

import java.util.List;
import java.util.Optional;

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
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}
	
	@Override
	public Optional<Person> getPersonById(int idPerson) {
		// TODO Auto-generated method stub
		return personRepository.findById(idPerson);
	}
}
