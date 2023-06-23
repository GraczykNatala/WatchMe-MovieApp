package pl.watchme.backendmovieapp.controller;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.watchme.backendmovieapp.domain.entity.*;
import pl.watchme.backendmovieapp.domain.repository.*;
import pl.watchme.backendmovieapp.dto.MovieDto;
import pl.watchme.backendmovieapp.dto.ProductDTO;
import pl.watchme.backendmovieapp.dto.ProductDetailsDTO;
import pl.watchme.backendmovieapp.dto.TvShowDto;
import pl.watchme.backendmovieapp.dto.dtoMapper.MovieDtoMapper;
import pl.watchme.backendmovieapp.dto.dtoMapper.ProductDTOMapper;
import pl.watchme.backendmovieapp.dto.dtoMapper.ProductDetailsDtoMapper;
import pl.watchme.backendmovieapp.dto.dtoMapper.TvShowDtoMapper;
import pl.watchme.backendmovieapp.wrapper.MovieRequest;
import pl.watchme.backendmovieapp.wrapper.TvShowRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/admin")
public class MoviesAdminController {
    private final ProductRepository productRepository;
    private final MovieRepository movieRepository;
    private final TvShowRepository tvShowRepository;
    private final  ProductCategoryRepository categoryRepository;
    private final ProductDTOMapper productDTOMapper;
    private final MovieDtoMapper movieDtoMapper;
    private final TvShowDtoMapper tvShowDtoMapper;
    private final ProductDetailsDtoMapper productDetailsDtoMapper;
    public MoviesAdminController(ProductRepository productRepository, MovieRepository movieRepository,
                                 TvShowRepository tvShowRepository, ProductCategoryRepository categoryRepository,
                                  ProductDTOMapper productDTOMapper,
                                 MovieDtoMapper movieDtoMapper, TvShowDtoMapper tvShowDtoMapper,
                                 ProductDetailsDtoMapper productDetailsDtoMapper) {
        this.productRepository = productRepository;
        this.movieRepository = movieRepository;
        this.tvShowRepository = tvShowRepository;
        this.categoryRepository = categoryRepository;
        this.productDTOMapper = productDTOMapper;
        this.movieDtoMapper = movieDtoMapper;
        this.tvShowDtoMapper = tvShowDtoMapper;
        this.productDetailsDtoMapper = productDetailsDtoMapper;
    }
    @GetMapping("/movies")
    public ResponseEntity<List<MovieDto>> getMovies() {
        List<MovieDto> movies = movieRepository
                .findAll()
                .stream()
                .map(movieDtoMapper)
                .collect(Collectors.toList());
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }
    @GetMapping("/tvshows")
    public ResponseEntity<List<TvShowDto>> getTvShows() {
        List<TvShowDto> tvshows= tvShowRepository
                .findAll()
                .stream()
                .map(tvShowDtoMapper)
                .collect(Collectors.toList());
        return new ResponseEntity<>(tvshows, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getProducts() {
        List<ProductDTO> products = productRepository.findAll()
                .stream()
                .map(productDTOMapper)
                .collect(Collectors.toList());
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    private void addProductWithCategory(Product product) {
        long nextProductId = productRepository.findMaxProductId () + 1;
        product.setId(nextProductId);

        Category existingCategory = categoryRepository.findById(product.getCategory().getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid ID"));

        product.setCategory(existingCategory);
    }

    @PostMapping("/addmovie")
    public ResponseEntity<Movie> addMovie(@RequestBody MovieRequest request) {

        Movie movie = request.getMovie();
        long nextMovietId = movieRepository.findMaxProductId () + 1;
        movie.setId(nextMovietId);

        Product product = request.getProduct();
       addProductWithCategory(product);
        productRepository.save(product);

        movie.setProduct(product);
        movieRepository.save(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }
    @PostMapping("/addtvshow")
    public ResponseEntity<TvShow> addTvShow(@RequestBody TvShowRequest request) {

        TvShow tvShow = request.getTvShow();
        long nextId = tvShowRepository.findMaxProductId () + 1; // Pobranie maksymalnego ID i zwiększenie o 1
        tvShow.setId(nextId);

        Product product = request.getProduct();
        addProductWithCategory(product);
        productRepository.save(product);

        tvShow.setProduct(product);
        tvShowRepository.save(tvShow);
        return new ResponseEntity<>(tvShow, HttpStatus.CREATED);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDetailsDTO> getProduct(@PathVariable Long id) {
        Optional<ProductDetailsDTO> productDetailsDto = productRepository.findById(id).map(productDetailsDtoMapper);
        return productDetailsDto
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        return productRepository.findById(id)
                .map(student -> {
                    productRepository.delete(student);
                    return ResponseEntity.ok().build();
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
