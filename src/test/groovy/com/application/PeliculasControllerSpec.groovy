package com.application

import com.demo.Pelicula
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.core.type.Argument
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

import jakarta.inject.Inject

@MicronautTest(transactional = false)
class PeliculasControllerSpec extends Specification {

    @Inject
    @Client("/")
    HttpClient client

    @Inject
    Fixtures fixtures

    void setup() {
        fixtures.cleanDatabase()
    }

    void "Test que devuelve todas las peliculas de la DB"() {
        given:
        fixtures.crearPelicula("Matrix", "Wachowski")
        fixtures.crearPelicula("Inception", "Nolan")

        when:
        def response = client.toBlocking().exchange(HttpRequest.GET("/peliculas"), Argument.listOf(Pelicula))
        List<Pelicula> rsp = response.body()

        then:
        rsp != null
        rsp.size() == 2 // debe haber las 2 que hemos insertado
        rsp.find { it.titulo == "Matrix" && it.director == "Wachowski" }
        rsp.find { it.titulo == "Inception" && it.director == "Nolan" }
    }

    void "Test de Peliculas con una DB vacía"() {
        when:
        List<Pelicula> rsp = client.toBlocking().retrieve(HttpRequest.GET("/peliculas"), Argument.listOf(Pelicula))

        then:
        rsp != null
        rsp.isEmpty();
    }

    void "Test Peliculas devuelve la pelicula insertada"() {
        given:
        def peli = new Pelicula(titulo: "blablabla", director: "aaaaa")
        def request = HttpRequest.POST("/peliculas", peli)

        when:
        def response = client.toBlocking().exchange(request, Pelicula)
        Pelicula rsp = response.body();

        then:
        rsp != null
        rsp.titulo == "blablabla"
        rsp.director == "aaaaa"
        fixtures.total() == 1
    }

    void "Test de Peliculas que borra la pelicula dada por ID" () {
        given:
        def peli = fixtures.crearPelicula("Matrix", "Wachowski")
        Long id = peli.id
        def request = HttpRequest.DELETE("/peliculas/"+id)

        when:
        client.toBlocking().exchange(request)

        then:
        true
        fixtures.total() == 0
    }

}
