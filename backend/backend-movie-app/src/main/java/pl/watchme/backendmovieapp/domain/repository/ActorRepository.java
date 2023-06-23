package pl.watchme.backendmovieapp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.watchme.backendmovieapp.domain.entity.Actor;



public interface ActorRepository extends JpaRepository<Actor, Long>//entity type + primary key type
{
    @Query("SELECT COALESCE(MAX(a.id), 0) FROM Actor a")
    Long findMaxProductId();
}


