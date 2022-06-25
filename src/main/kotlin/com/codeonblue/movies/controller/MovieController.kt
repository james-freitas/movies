package com.codeonblue.movies.controller

import com.codeonblue.movies.model.Movie
import com.codeonblue.movies.service.MovieService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class MovieController(private val movieService: MovieService) {

    @GetMapping("/")
    fun getAllMovies(model: Model): String? {
        val movieList = movieService.getAll()
        model.addAttribute("movies", movieList)
        return "list-movies"
    }

    @PostMapping("/createMovie")
    fun create(@ModelAttribute movie: Movie): String {
        movieService.create(movie)
        return "redirect:/"
    }

    @GetMapping(path = ["/add"])
    fun createMovieForm(): String? {
        return "add-movie"
    }

    @GetMapping(path = ["/edit/{id}"])
    fun editUserById(model: Model, @PathVariable("id") id: Long): String? {
        model.addAttribute("movie", movieService.findById(id))
        return "edit-movie"
    }

    @PostMapping(path = ["/editMovie"])
    fun editUser(@ModelAttribute movie: Movie): String? {
        movieService.update(movie)
        return "redirect:/"
    }

    @GetMapping(path = ["/delete/{id}"])
    fun deleteUserById(@PathVariable("id") id: Long): String? {
        movieService.deleteById(id)
        return "redirect:/"
    }
}