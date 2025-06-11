package com.demo;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.http.exceptions.HttpStatusException;

import java.util.List;
import java.util.Optional;

@Controller("/peliculas")
public class PeliculasController {

    PeliculasRepository peliculasRepository;

    public PeliculasController(PeliculasRepository peliculasRepository) {
        this.peliculasRepository = peliculasRepository;
    }

    @Get
    public Page<Pelicula> getAllPeliculas(Pageable pageable) {
        return peliculasRepository.findAll(pageable);
    }

    @Get("/{id}")
    public @NonNull Optional<Pelicula> getPelicula(Long id) {
        return peliculasRepository.findById(id);
    }

    @Get("/buscar")
    public List<Pelicula> buscar(@QueryValue Optional<String> titulo,
                                 @QueryValue Optional<String> director) {
        return peliculasRepository.findByTituloAndDirectorLike(
                titulo.orElse(""),
                director.orElse("")
        );
    }

    @Post
    public Pelicula addPelicula(@NonNull @Body Pelicula pelicula) {
        return peliculasRepository.save(pelicula);
    }

    @Put("/{id}")
    public Pelicula updatePelicula(Long id, @Body Pelicula pelicula) {
        Optional<Pelicula> existente = peliculasRepository.findById(id);
        if (existente.isPresent()) {
            peliculasRepository.update(id, pelicula.getTitulo(), pelicula.getDirector());
            return peliculasRepository.findById(id).get();
        } else {
            throw new HttpStatusException(HttpStatus.NOT_FOUND, "Película no encontrada");
        }
    }

    @Delete
    public void deleteAllPeliculas() {
        peliculasRepository.deleteAll();
    }

    @Delete("/{id}")
    public void delete(Long id) {
        peliculasRepository.deleteById(id);
    }

}
