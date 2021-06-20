package com.br.mymovies.data.service

import com.br.mymovies.data.entity.MoviesAllRespose
import com.br.mymovies.network.Credentials.Companion.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesAllService {

    fun insert(movie: MoviesAllRespose): Long

    fun update(movie: MoviesAllRespose)

    fun delete(id: Long)

    fun deleteAll()

    //https://api.themoviedb.org/3/movie/popular?api_key=6221323efa4eb333f46e9f800f2ebcb1

    @GET("movie/popular")
    fun getAllMovies(
        @Query("api_key") api_key: String = API_KEY,
        @Query("page") pages: Int = 2
    ): Call<MoviesAllRespose>

}