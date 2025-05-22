package com.demo;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.annotation.*;

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
        var ret = peliculasRepository.findAll();
        return ret;
    }

    @Get("/{id}")
    public @NonNull Optional<Pelicula> getPelicula(Long id) {
        return peliculasRepository.findById(id);
    }

    @Post
    public Pelicula addPelicula(@NonNull @Body Pelicula pelicula) {
        return peliculasRepository.save(pelicula);
    }

    @Delete("/{id}")
    public void delete(Long id) {
        peliculasRepository.deleteById(id);
    }

    @Delete("/{all}")
    public void deleteAllPeliculas() {
        peliculasRepository.deleteAll();
    }
}
