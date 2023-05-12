package pl.watchme.backendmovieapp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.watchme.backendmovieapp.domain.entity.Product;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long>//entity type + primary key type
{
}
