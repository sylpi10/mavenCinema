package cinema.persistence.entity.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import cinema.persistence.entity.Movie;
import cinema.persistence.repository.MovieRepository;

@DataJpaTest
class TestMovie {

	@Autowired
	MovieRepository repoMovie;
	
	@Autowired
	EntityManager entityManager;
	
	@Test
	void testInsert() {
		Movie joker = new Movie("Joker", 2019);
		repoMovie.save(joker);
		var id = joker.getIdMovie();
		System.out.println("id new movie = " + id);
		assertNotNull(id);
	}
	
	@Test
	void testSelectAll() {
		//given
		List<Movie> data = List.of(
				new Movie("Joker", 2019),	
				new Movie("The departed", 2006, 136),	
				new Movie("The godfather", 1972, 220),	
				new Movie("Apocalypse now", 1979),	
				new Movie("Taxi driver", 1976),	
				new Movie("Raging bull", 1980),	
				new Movie("Interstellar", 2014)
				);
		data.forEach(entityManager::persist);
		//when
		var dataRead = repoMovie.findAll();
		//then
		dataRead.forEach(System.out::println);
	}
}
