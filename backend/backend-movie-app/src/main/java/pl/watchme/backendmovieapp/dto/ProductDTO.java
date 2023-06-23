package pl.watchme.backendmovieapp.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import pl.watchme.backendmovieapp.domain.entity.Actor;
import pl.watchme.backendmovieapp.domain.entity.Category;
import pl.watchme.backendmovieapp.domain.entity.ProductCast;

import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    String title;
    String category;
    Date dateAdded;
    List<Actor> actors;
    String price;
}
