package cinema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.persistence.entity.Movie;
import cinema.persistence.repository.MovieRepository;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
		
	@Autowired
	MovieRepository movieRepository;
	
	@GetMapping
	@ResponseBody
	public List<Movie> movies () {
		return movieRepository.findAll();
	}
	
}
