package pl.watchme.backendmovieapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.watchme.backendmovieapp.domain.entity.Actor;

import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailsDTO {
    String title;
    String category;
    String description;
    Date dateAdded;
    String director;
    List<Actor> actors;
    String price;
}
