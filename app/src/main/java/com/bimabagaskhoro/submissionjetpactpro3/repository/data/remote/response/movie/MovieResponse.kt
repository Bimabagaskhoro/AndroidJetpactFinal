package com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.movie

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    val result: List<MovieRemote>
)
