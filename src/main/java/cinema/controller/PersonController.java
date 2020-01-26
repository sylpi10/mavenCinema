package cinema.controller;

import java.util.List;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.persistence.entity.Movie;
import cinema.persistence.entity.Person;
import cinema.service.IPersonService;


@RestController
@RequestMapping("/api/persons")
public class PersonController {
	
	@Autowired
	IPersonService personService;
	
	
	@GetMapping
	@ResponseBody
	public List<Person> allPersons () {
		return personService.getAllPerson();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Optional<Person>personById(@PathVariable("id") int idPerson) {
		return personService.getPersonById(idPerson);
	}
	
	@GetMapping("/byName")
	@ResponseBody
	public Set<Person>movieByPartialTitle(@RequestParam("n") String partialName) {
		return personService.getByNameIgnoreCaseContaining(partialName);
	}
	
	@GetMapping("/byBirthdate")
	@ResponseBody
	public Set<Person>getByBirthDateYear(@RequestParam("y") int year) {
		return personService.getByBirthDateYear(year);
	}
}





