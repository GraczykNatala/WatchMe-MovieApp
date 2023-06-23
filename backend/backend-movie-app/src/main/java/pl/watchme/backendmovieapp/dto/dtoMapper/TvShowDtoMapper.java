package pl.watchme.backendmovieapp.dto.dtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.watchme.backendmovieapp.domain.entity.TvShow;
import pl.watchme.backendmovieapp.dto.ProductDetailsDTO;
import pl.watchme.backendmovieapp.dto.TvShowDto;

import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class TvShowDtoMapper implements Function<TvShow, TvShowDto> {
    private final ProductDetailsDtoMapper productDetailsDtoMapper;
    @Override
    public TvShowDto apply(TvShow tvShow) {
        ProductDetailsDTO product = productDetailsDtoMapper.apply(tvShow.getProduct());
        return new TvShowDto(
                product,
                tvShow.getSeasons(),
                tvShow.getEpisodes()
        );
    }
}
