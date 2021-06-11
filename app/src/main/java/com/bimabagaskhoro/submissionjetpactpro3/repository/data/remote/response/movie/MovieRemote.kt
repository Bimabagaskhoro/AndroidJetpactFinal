package com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.movie

import com.google.gson.annotations.SerializedName

data class MovieRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("release_date")
    val date: String,
    @SerializedName("poster_path")
    val image: String,
    @SerializedName("overview")
    val desc: String,
    @SerializedName("original_language")
    val original_language: String,
    @SerializedName("backdrop_path")
    val imageBackdrop: String,
    @SerializedName("vote_average")
    val vote_average: Double
)
