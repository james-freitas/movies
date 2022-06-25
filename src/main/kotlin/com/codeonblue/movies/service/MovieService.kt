package com.codeonblue.movies.service

import com.codeonblue.movies.model.Movie
import com.codeonblue.movies.repository.MovieRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class MovieService(private val movieRepository: MovieRepository) {

    fun getAll(): List<Movie> {
        return movieRepository.findAll()
    }

    fun create(movie: Movie): Movie {
        return movieRepository.save(movie)
    }

    fun findById(id: Long): Movie? {
        return movieRepository.findById(id).orElse(null)
    }

    fun update(movie: Movie): Movie {
        return movieRepository.save(movie)
    }

    fun deleteById(id: Long) {
        movieRepository.deleteById(id)
    }
}
