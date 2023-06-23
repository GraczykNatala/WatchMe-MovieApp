package pl.watchme.backendmovieapp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.watchme.backendmovieapp.domain.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>//entity type + primary key type
{
    @Query("SELECT COALESCE(MAX(p.id), 0) FROM Product p")
    Long findMaxProductId();
}
