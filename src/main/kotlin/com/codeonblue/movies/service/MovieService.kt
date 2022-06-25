package com.codeonblue.movies.service

import com.codeonblue.movies.model.Movie
import com.codeonblue.movies.repository.MovieRepository
import org.springframework.stereotype.Service

@Service
class MovieService(private val movieRepository: MovieRepository) {

    fun getAll(): List<Movie> {
        return movieRepository.findAll()
    }
}
