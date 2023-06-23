package pl.watchme.backendmovieapp.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Entity
@Table(name= "movie")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Movie {
    @Id
    @Column(name = "movie_id")
    Long id;

    @Min(40)
    @Max(180)
    @Column(name = "duration")
    int duration;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
