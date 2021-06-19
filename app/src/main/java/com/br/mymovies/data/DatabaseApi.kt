package com.br.mymovies.data

import com.br.mymovies.data.entity.Movie
import com.br.mymovies.network.RetrofitInstance
import com.br.mymovies.network.callback

class DatabaseApi {

    fun getAllMovies(
        sucess: (movies: List<Movie>) -> Unit,
        failure: (throwable: Throwable) -> Unit
    ){
        RetrofitInstance.getAllMovies().enqueue(callback({ response ->
            response?.body()?.let {
                if(response.code() == STATUS_OK){
                    val movies: List<Movie> = response.body()?.results ?: listOf()
                    sucess(movies)
                } else {
                    sucess(listOf())
                }
            }
        }, { throwable ->
            throwable?.let {
                failure(throwable)
            }
        }))
    }

    companion object {
        val STATUS_OK = 200
        val STATUS_ERROR = 400 or 401
    }

}