package pl.watchme.backendmovieapp.wrapper;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import pl.watchme.backendmovieapp.domain.entity.Movie;
import pl.watchme.backendmovieapp.domain.entity.Product;
import pl.watchme.backendmovieapp.dto.dtoMapper.ProductDetailsDtoMapper;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MovieRequest {
    Movie movie;
    Product product;

}
