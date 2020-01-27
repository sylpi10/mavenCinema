package cinema.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.persistence.entity.Person;
import cinema.service.IPersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {
	
	@Autowired
	IPersonService PersonService;
	
	// Methodes Get
	@GetMapping
	@ResponseBody
	public List<Person> allPersons() {
		return PersonService.getAllPersons();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Optional<Person> PersonById(@RequestParam("id") int idPerson) {
		return PersonService.getPersonById(idPerson);
	}
	
	@GetMapping("/byEndName")
	@ResponseBody
	public Set<Person> PersonByNameEnding(@RequestParam("n") String name) {
		return PersonService.getPersonsByNameEndingWithIgnoreCase(name);
	}
	
	@GetMapping("/byNameContaining")
	@ResponseBody
	public Set<Person> PersonByNameContaining(@RequestParam("n") String partialName) {
		return PersonService.getPersonsByNameContainingIgnoreCase(partialName);
	}
	
	@GetMapping("/byBirtdateYear")
	@ResponseBody
	public Set<Person> PersonByBirthdateYear(@RequestParam("y") int year) {
		return PersonService.getPersonsByBirthdateYear(year);
	}
	
	// Methodes Put, Post, Delete
	@PostMapping
	@ResponseBody 
	public Person addPerson(@RequestParam("p") Person person) {
		return PersonService.addPerson(person);
	}
	
	@PutMapping("/modify")
	@ResponseBody 
	public Optional<Person> modifyPerson(@RequestParam("m") Person person) {
		return PersonService.modifyPerson(person);
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody 
	public Optional<Person> deletePerson(@RequestParam("id") int idPerson) {
		return PersonService.deletePerson(idPerson);
	}
	
}



