package pl.watchme.backendmovieapp.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;


@Entity
@Table(name= "product_cast")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCast {

        @Id
        @Column(name= "product_cast_id", updatable = false)
        Long id;

        @ManyToOne
        @JoinColumn(name = "product_id")
        Product product;

        @ManyToOne
        @JoinColumn(name = "actor_id")
        Actor actor;
    }

