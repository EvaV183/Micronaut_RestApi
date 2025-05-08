package com.demo;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.PageableRepository;


    @JdbcRepository(dialect = Dialect.MYSQL)
    public interface PeliculasRepository extends PageableRepository<Pelicula, Long> {

        Pelicula save(@NonNull String titulo, @NonNull String director);

        long update(@NonNull @Id Long id, @NonNull String titulo);
    }

