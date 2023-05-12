package pl.watchme.backendmovieapp.domain.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name= "product")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    Category category;

    @Column(name= "title", nullable = false, updatable = false)
    @NotNull(message = "required")
    String title;

    @Column(name= "description", nullable = false, updatable = false)
    @NotNull(message = "required")
    String description;

    @Column(name= "poster_url", nullable = false, updatable = false)
    @NotNull(message = "required")
    String posterUrl;

    @Column(name= "release_date", nullable = false, updatable = false)
    @NotNull(message = "required")
    Date releaseDate;

    @Column(name= "date_added", nullable = false, updatable = false)
    @NotNull(message = "required")
    @CreationTimestamp
    Date dateAdded;


    @Column(name= "running_time", nullable = false, updatable = false)
    @NotNull(message = "required")
    int runningTime;

    @Column(name= "director", nullable = false, updatable = false)
    @NotNull(message = "required")
    String director;

    @Column(name= "main_actor", nullable = false, updatable = false)
    @NotNull(message = "required")
    String mainActor;










}
