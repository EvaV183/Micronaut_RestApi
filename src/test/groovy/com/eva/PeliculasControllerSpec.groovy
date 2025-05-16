package com.eva

import com.demo.Pelicula
import com.demo.PeliculasRepository
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

import jakarta.inject.Inject

    @MicronautTest
    class PeliculasController extends Specification {

        @Inject
        @Client("/")
        HttpClient client

        @Inject
        PeliculasRepository peliculasRepository

        void "Test Peliculas response"() {
            when:
            HttpRequest request = HttpRequest.GET('/peliculas')
            List<Pelicula> rsp = client.toBlocking().exchange(request, List<Pelicula>);

            then:
            rsp != null
            rsp instanceof List<Pelicula>;
        }

        void "Test Peliculas con DB vacía"() {
            given:
            Pelicula p = new Pelicula()
            p.setTitulo("bla bla");
            p.setDirector("bla bla");
            peliculasRepository.save(p);

            when:
            HttpRequest request = HttpRequest.GET('/peliculas')
            List<Pelicula> rsp = client.toBlocking().exchange(request, List<Pelicula>);

            then:
            !rsp.isEmpty();

        }


    }
