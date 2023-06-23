package pl.watchme.backendmovieapp.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Table(name= "actor")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Actor {


    @JsonIgnore
    @Id
    @Column(name= "actor_id", updatable = false)
    private Long id;

    @Column(name= "first_name", updatable = false)
    String firstName;
    @Column(name= "last_name", updatable = false)
    String lastName;

   @JsonIgnore
    @ManyToMany(mappedBy = "actors")
    private List<Product> products;
}
