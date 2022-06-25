package com.codeonblue.movies.controller

import com.codeonblue.movies.service.MovieService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MovieController(private val movieService: MovieService) {

    @GetMapping("/")
    fun getAllMovies(model: Model): String? {
        val movieList = movieService.getAll()
        model.addAttribute("movies", movieList)
        return "list-movies"
    }
}