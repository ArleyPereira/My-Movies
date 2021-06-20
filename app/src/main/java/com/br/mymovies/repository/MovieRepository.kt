package com.br.mymovies.repository

import com.br.mymovies.data.dao.MovieDao
import com.br.mymovies.data.entity.Movie
import com.br.mymovies.network.RetrofitInstance
import com.br.mymovies.network.callback

class MovieRepository {

    companion object {

        fun insertMovie(): Long {
            TODO("Not yet implemented")
        }

        fun updateMovie() {
            TODO("Not yet implemented")
        }

        fun deleteMovie() {
            TODO("Not yet implemented")
        }

        fun deleteAllMovies() {
            TODO("Not yet implemented")
        }

        fun getAllMovies(
            sucess: (movies: List<Movie>) -> Unit,
            failure: (throwable: Throwable) -> Unit
        ) {
            val endpoint = RetrofitInstance.getRetrofitInstance().create(MovieDao::class.java)
            return endpoint.getAllMovies().enqueue(callback({ response ->
                response?.body()?.let {
                    if (response.code() == STATUS_OK) {
                        val movies: List<Movie> = response.body()?.results ?: listOf()
                        sucess(movies)
                    }
                }
            }, { throwable ->
                throwable?.let {
                    failure(throwable)
                }
            }))
        }

        val STATUS_OK = 200
    }

}