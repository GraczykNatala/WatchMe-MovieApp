package pl.watchme.backendmovieapp.dto.dtoMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.watchme.backendmovieapp.domain.entity.Movie;
import pl.watchme.backendmovieapp.dto.MovieDto;
import pl.watchme.backendmovieapp.dto.ProductDTO;
import pl.watchme.backendmovieapp.dto.ProductDetailsDTO;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class MovieDtoMapper implements Function<Movie, MovieDto> {
    private final ProductDetailsDtoMapper productDetailsDtoMapper;
    @Override
    public MovieDto apply(Movie movie) {
        ProductDetailsDTO product = productDetailsDtoMapper.apply(movie.getProduct());
        return new MovieDto(
                product,
                movie.getDuration()
        );
    }
}
