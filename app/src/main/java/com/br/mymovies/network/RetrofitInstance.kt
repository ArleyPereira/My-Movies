package com.br.mymovies.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance {

    companion object {

        private fun client() =
            OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }).build()

        fun getRetrofitInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(Credentials.BASE_URL)
                .client(client())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }



    }

}