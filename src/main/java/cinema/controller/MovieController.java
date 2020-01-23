package cinema.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.persistence.entity.Movie;
import cinema.persistence.entity.Person;
import cinema.persistence.repository.MovieRepository;
import cinema.persistence.repository.PersonRepository;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
		
	@Autowired
	MovieRepository movieRepository;

	@Autowired
	PersonRepository personRepository;
	
	/*
	 * GET --reading movies
	 */
	@GetMapping
	@ResponseBody
	public List<Movie> allMovies () {
		return movieRepository.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Optional<Movie>movieById(@PathVariable("id") int idMovie) {
		return movieRepository.findById(idMovie);
	}
	
	@GetMapping("/byTitle")
	@ResponseBody
	public Set<Movie>movieByPartialTitle(@RequestParam("t") String partialTitle) {
		return movieRepository.findByTitleIgnoreCaseContaining(partialTitle);
	}
	
	@GetMapping("/byYear")
	@ResponseBody
	public Set<Movie>findByYearBetween(@RequestParam("y1") int year1, @RequestParam("y2") int year2 ) {
		return movieRepository.findByYearBetween(year1, year2);
	}
	
	@GetMapping("/byDirector")
	@ResponseBody
	public Set<Movie>findByDirector(@RequestParam ("d") String directorName) {
		return movieRepository.findByDirectorName(directorName );
	}

	@GetMapping("/byDirectorId")
	@ResponseBody
	public Set<Movie>findByDirector(@RequestParam ("d") int idDirector) {
		var optDirector = personRepository.findById(idDirector);
		return optDirector.map(d -> movieRepository.findByDirector(d)).orElseGet(()-> Collections.emptySet());
	}

	@GetMapping("/byActor")
	@ResponseBody
	public Set<Movie>findByActor(@RequestParam ("a") int idActor) {
		return movieRepository.findByActorsIdPerson(idActor );
	}
	
	@GetMapping("/byPerson")
	@ResponseBody
	public Set<Movie>findByActorOrDirector(@RequestParam("a") String actorName, @RequestParam("d") String directorName) {
		return movieRepository.findByActorsNameOrDirectorName( actorName,  directorName );
	}
	
//	@GetMapping("/byActor")
//	@ResponseBody
//	public Set<Movie>findByActor(@RequestParam("a") int idActor) {
//		return movieRepository.findByIdPerson(idActor);
//	}
//	
	
	
	/*
	 * POST --add movies
	 */
	@PostMapping
	@ResponseBody
	public Movie addMovie(@RequestBody Movie movie) {
		Movie movieSaved = movieRepository.save(movie);
		movieRepository.flush();
		return movieSaved;
	}
	
	/**
	 * PUT
	 */
	@PutMapping("/modify")
	@ResponseBody
	public Optional<Movie> modifyMovie(@RequestBody Movie movie) {
		// TODO : somewhere else
		var optMovie = movieRepository.findById(movie.getIdMovie());
		optMovie.ifPresent(m -> {
			m.setTitle(movie.getTitle());
			m.setYear(movie.getYear());
			m.setDuration(movie.getDuration());
			m.setDirector(movie.getDirector());
			movieRepository.flush();
		});
		//
		return optMovie;
	}
	

	@PutMapping("/addActor")
	@ResponseBody
	public Optional<Movie> addActor(@RequestParam("a") int idActor, @RequestParam("m") int idMovie) {
		//TODO: somewhere else
		var optMovie = movieRepository.findById(idMovie);
		var optActor= personRepository.findById(idActor);
		if (optMovie.isPresent() && optActor.isPresent()) {
			optMovie.get().getActors().add(optActor.get());
			movieRepository.flush();
		}
		return optMovie;
	}
	
	@PutMapping("/setDirector")
	@ResponseBody
	public Optional<Movie> setDirector(@RequestParam("a") int idDirector, @RequestParam("m") int idMovie) {
		//TODO: somewhere else
		var optMovie = movieRepository.findById(idMovie);
		var optDirector= personRepository.findById(idDirector);
		if (optMovie.isPresent() && optDirector.isPresent()) {
			optMovie.get().setDirector(optDirector.get());
			movieRepository.flush();
		}
		return optMovie;
	}
	
	
	/**
	 * DELETE
	 */
	@DeleteMapping("/{id}")
	@ResponseBody
	public Optional<Movie> deleteMovie(@PathVariable("id") int idMovie) {
		var movieToDelete = movieRepository.findById(idMovie);
		movieToDelete.ifPresent(m-> {
			movieRepository.delete(m);
			movieRepository.flush();
		});
		return movieToDelete;
	}
	
}
