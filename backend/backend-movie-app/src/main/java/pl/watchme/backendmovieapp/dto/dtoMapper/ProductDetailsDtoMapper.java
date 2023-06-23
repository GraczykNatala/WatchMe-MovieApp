package pl.watchme.backendmovieapp.dto.dtoMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.watchme.backendmovieapp.domain.entity.Product;
import pl.watchme.backendmovieapp.dto.ProductDTO;
import pl.watchme.backendmovieapp.dto.ProductDetailsDTO;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class ProductDetailsDtoMapper implements Function<Product, ProductDetailsDTO> {


    @Override
    public ProductDetailsDTO apply(Product product) {
        return new ProductDetailsDTO(
                product.getTitle(),
                product.getCategory().getName(),
                product.getDescription(),
                product.getDateAdded(),
                product.getDirector(),
                product.getActors(),
                product.getPrice()
        );
    }
}
