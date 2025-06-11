package com.application


import com.demo.PeliculasRepository
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest
class PeliculasRepositorySpec extends Specification {
    @Inject
    @Client("/")
    HttpClient client

    @Inject
    Fixtures fixtures

    void setup() {
        fixtures.cleanDatabase()
    }

    @Inject
    PeliculasRepository peliculasRepository

    void "Test que guarda la pelicula usando el metodo save"() {
        when:
        def pelicula = peliculasRepository.save("Oppenheimer", "Christopher Nolan")

        then:
        pelicula != null
        pelicula.id != null
        pelicula.titulo == "Oppenheimer"
        pelicula.director == "Christopher Nolan"
    }
}
