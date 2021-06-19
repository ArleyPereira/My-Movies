package com.br.mymovies.network

import com.br.mymovies.data.dao.MovieDao
import com.br.mymovies.data.entity.MoviesAllRespose
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {

        fun getRetrofitInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(Credentials.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun getAllMovies(): Call<MoviesAllRespose> {
            val endpoint = getRetrofitInstance().create(MovieDao::class.java)
            return endpoint.getAllMovies()
        }

    }

}