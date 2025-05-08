package com.demo;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import java.util.List;
import java.util.Optional;

@Controller("/peliculas")
public class PeliculasController {
    PeliculasRepository peliculasRepository;

    public PeliculasController(PeliculasRepository peliculasRepository) {
        this.peliculasRepository = peliculasRepository;
    }

    @Get
    public List<Pelicula> getAllPeliculas() {
        return peliculasRepository.findAll();
    }

    @Get("/{id}")
    public @NonNull Optional<Pelicula> show(Long id) {
        return peliculasRepository.findById(id);
    }

    @Post
    public Pelicula addPelicula(@NonNull Pelicula pelicula) {
        return peliculasRepository.save(pelicula);
    }

    @Delete("/{id}")
    public void delete(Long id) {
        peliculasRepository.deleteById(id);
    }
}
