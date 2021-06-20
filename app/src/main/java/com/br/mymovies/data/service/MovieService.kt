package com.br.mymovies.data.service

import com.br.mymovies.data.entity.Movie
import com.br.mymovies.data.entity.MoviesAllRespose
import com.br.mymovies.network.Credentials
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("movie/{movie_id}")
    fun getDetailsMovie(
        @Path("movie_id") movie_id: Int,
        @Query("api_key") api_key: String = Credentials.API_KEY
    ): Call<Movie>

}