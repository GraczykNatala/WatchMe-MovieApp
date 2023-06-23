package pl.watchme.backendmovieapp.domain.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name= "product")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {


    @Id
    @Column(name = "product_id")
    Long id;

    @ManyToOne
    @JoinColumn(name="category_id")
    Category category;

    @Column(name= "title", nullable = false, updatable = false)
    @NotNull(message = "required")
    String title;

    @Column(name= "description", nullable = false, updatable = false)
    @NotNull(message = "required")
    String description;

    @Column(name= "release_date", updatable = false)
    @NotNull(message = "required")
    Date releaseDate;

    @Column(name= "date_added", updatable = false)
    @NotNull(message = "required")
    @CreationTimestamp
    Date dateAdded;
    @Column(name= "director", updatable = false)
    @NotNull(message = "required")
    String director;

    @ManyToMany
    @JoinTable(
            name = "product_cast",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Actor> actors;


    @Column(name= "box_office", updatable = false)
    String boxOffice;

    @Column(name= "price", nullable = false)
    @NotNull(message = "required")
    String price;











}
