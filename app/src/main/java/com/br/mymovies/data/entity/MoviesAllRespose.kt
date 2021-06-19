package com.br.mymovies.data.entity

import com.google.gson.annotations.SerializedName

data class MoviesAllRespose (

    @SerializedName("page")
    val page: Long,

    @SerializedName("results")
    val results: List<Movie>

)