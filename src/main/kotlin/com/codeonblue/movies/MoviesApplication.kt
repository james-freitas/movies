package com.codeonblue.movies

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MoviesApplication {

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<MoviesApplication>(*args)
		}
	}
}

