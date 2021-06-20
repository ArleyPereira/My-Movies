package com.br.mymovies.repository

import com.br.mymovies.data.service.MoviesAllService
import com.br.mymovies.data.entity.Movie
import com.br.mymovies.network.RetrofitInstance
import com.br.mymovies.network.callback

class MoviesAllRepository {

    fun getAllMovies(
        sucess: (movies: List<Movie>) -> Unit,
        failure: (throwable: Throwable) -> Unit
    ) {
        val endpoint = RetrofitInstance.getRetrofitInstance().create(MoviesAllService::class.java)
        return endpoint.getAllMovies().enqueue(callback({ response ->
            response?.body()?.let {
                if (response.code() == RetrofitInstance.STATUS_OK) {
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

}