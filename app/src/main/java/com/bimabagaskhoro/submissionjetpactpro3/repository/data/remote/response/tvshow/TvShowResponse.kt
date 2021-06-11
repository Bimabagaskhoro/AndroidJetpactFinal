package com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.tvshow

import com.google.gson.annotations.SerializedName

data class TvShowResponse(
    @SerializedName("results")
    val result: List<TvShowRemote>
)
