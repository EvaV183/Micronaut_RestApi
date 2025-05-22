package com.application

import com.demo.Pelicula
import com.demo.PeliculasRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton
import jakarta.transaction.Transactional

@Singleton
class Fixtures {

    @Transactional
    Pelicula crearPelicula(String titulo, String director) {
        def pelicula = new Pelicula(titulo: titulo, director: director)
        return peliculasRepository.save(pelicula)
    }

    @Transactional
    void cleanDatabase() {
        peliculasRepository.deleteAll()
    }

    @Inject
    PeliculasRepository peliculasRepository

    int total() {
        return peliculasRepository.count()
    }
}
