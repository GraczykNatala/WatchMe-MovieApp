package pl.watchme.backendmovieapp.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TvShowDto {
    ProductDetailsDTO product;
    int seasons;
    int episodes;
}

