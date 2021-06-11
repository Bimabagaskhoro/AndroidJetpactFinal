package com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.tvshow

import com.google.gson.annotations.SerializedName

data class TvShowRemote(
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_name")
    val title: String,
    @SerializedName("first_air_date")
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
