package pl.watchme.backendmovieapp.dto.dtoMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.watchme.backendmovieapp.domain.entity.Product;
import pl.watchme.backendmovieapp.dto.ProductDTO;
import java.util.function.Function;
@Component
@RequiredArgsConstructor
public class ProductDTOMapper implements Function<Product, ProductDTO> {
    @Override
    public ProductDTO apply(Product product) {
        return new ProductDTO(
                product.getTitle(),
                product.getCategory().getName(),
                product.getDateAdded(),
                 product.getActors(),
                product.getPrice()
        );
    }
}
