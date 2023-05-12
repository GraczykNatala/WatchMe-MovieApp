package pl.watchme.backendmovieapp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.watchme.backendmovieapp.domain.entity.Category;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "category",path = "category") //zmiana adresu url na product-category
public interface ProductCategoryRepository extends JpaRepository<Category, Long> {

}
