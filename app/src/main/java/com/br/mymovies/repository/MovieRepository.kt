package com.br.mymovies.repository

import com.br.mymovies.data.entity.MoviesAllRespose
import retrofit2.Call

interface MovieRepository {

    fun insertMovie(): Long

    fun updateMovie()

    fun deleteMovie()

    fun deleteAllMovies()

    fun getAllMovies(api_key: String): Call<MoviesAllRespose>

}