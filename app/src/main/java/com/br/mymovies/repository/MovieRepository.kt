package com.br.mymovies.repository

import com.br.mymovies.data.entity.Movie
import com.br.mymovies.data.service.MovieService
import com.br.mymovies.network.RetrofitInstance
import com.br.mymovies.network.callback

class MovieRepository {

    fun getDetailsMovie(
        sucess: (movie: Movie) -> Unit,
        failure: (throwable: Throwable) -> Unit
    ) {
        val endpoint = RetrofitInstance.getRetrofitInstance().create(MovieService::class.java)
        return endpoint.getDetailsMovie(337404).enqueue(callback({ response ->
            response?.body()?.let {
                if (response.code() == RetrofitInstance.STATUS_OK) {
                    val movie = response.body() as Movie
                    sucess(movie)
                }
            }
        }, { throwable ->
            throwable?.let {
                failure(throwable)
            }
        }))
    }

}