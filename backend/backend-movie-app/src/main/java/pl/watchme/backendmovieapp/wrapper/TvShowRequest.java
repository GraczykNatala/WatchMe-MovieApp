package pl.watchme.backendmovieapp.wrapper;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import pl.watchme.backendmovieapp.domain.entity.Movie;
import pl.watchme.backendmovieapp.domain.entity.Product;
import pl.watchme.backendmovieapp.domain.entity.TvShow;
import pl.watchme.backendmovieapp.domain.repository.TvShowRepository;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TvShowRequest {
    TvShow tvShow;
    Product product;

}
