package pl.watchme.backendmovieapp.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name= "tv_show")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TvShow {

        @Id
        @Column(name = "tv_show_id")
        Long id;

        @Min(1)
        @Column(name = "seasons")
        @NotNull
        int seasons;

        @Column(name = "episodes")
        @NotNull
        int episodes;


        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "product_id")
        private Product product;

}
