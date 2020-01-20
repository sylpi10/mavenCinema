package cinema.persistence.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import cinema.persistence.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	Set<Movie> findByTitle(String title);
}
