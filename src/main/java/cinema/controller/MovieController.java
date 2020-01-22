package cinema.controller;

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
import cinema.persistence.repository.MovieRepository;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
		
	@Autowired
	MovieRepository movieRepository;
	
	/*
	 * GET --reading movies
	 */
	@GetMapping
	@ResponseBody
	public List<Movie> movies () {
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
