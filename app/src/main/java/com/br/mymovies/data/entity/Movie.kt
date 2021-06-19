package com.br.mymovies.data.entity

import com.google.gson.annotations.SerializedName

data class Movie(

    @SerializedName("id")
    val id: Long,

    @SerializedName("original_language")
    val language: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("original_title")
    val description: String,

    @SerializedName("release_date")
    val release: String,

    @SerializedName("poster_path")
    val poster: String,

    @SerializedName("genre_ids")
    val genres: List<Int>
)