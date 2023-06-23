package pl.watchme.backendmovieapp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.watchme.backendmovieapp.domain.entity.Movie;
import pl.watchme.backendmovieapp.domain.entity.TvShow;


public interface TvShowRepository extends JpaRepository<TvShow, Long>//entity type + primary key type
{
    @Query("SELECT COALESCE(MAX(t.id), 0) FROM TvShow t")
    Long findMaxProductId();
}
