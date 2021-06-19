package com.br.mymovies.data.dao

import com.br.mymovies.data.entity.MoviesAllRespose
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.*

interface MovieDao {

    fun insert(movie: MoviesAllRespose): Long

    fun update(movie: MoviesAllRespose)

    fun delete(id: Long)

    fun deleteAll()

    //https://api.themoviedb.org/3/movie/popular?api_key=6221323efa4eb333f46e9f800f2ebcb1

    @GET("movie/popular")
    fun getAllMovies(
        @Query("api_key") api_key: String
    ): Call<MoviesAllRespose>

}