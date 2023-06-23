package pl.watchme.backendmovieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    ProductDetailsDTO product;
    int duration;

}
