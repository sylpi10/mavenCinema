package cinema.controller;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
}





=======

import org.springframework.web.bind.annotation.GetMapping;

import cinema.persistence.entity.Person;

public class PersonController {
	
}
>>>>>>> 0f40c87b4b1b9753286deaf516b164fbdcf465d3
