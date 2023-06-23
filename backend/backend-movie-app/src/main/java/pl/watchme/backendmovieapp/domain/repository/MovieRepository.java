package pl.watchme.backendmovieapp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.watchme.backendmovieapp.domain.entity.Movie;


public interface MovieRepository extends JpaRepository<Movie, Long>//entity type + primary key type
{
    @Query("SELECT COALESCE(MAX(m.id), 0) FROM Movie m")
    Long findMaxProductId();
}

