package com.bimabagaskhoro.submissionjetpactpro3.repository.api

import com.bimabagaskhoro.submissionjetpactpro3.BuildConfig
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.movie.MovieDetailResponse
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.movie.MovieResponse
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.tvshow.TvShowDetailResponse
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.tvshow.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiEndPoint {

    companion object {
        const val API_KEY = BuildConfig.TMDB_API_KEY
    }

    @GET("movie/popular?api_key=$API_KEY")
    fun getListMovies(
        @Query("page") page: Int
    ): Call<MovieResponse>

    @GET("movie/{movie_id}?api_key=$API_KEY")
    fun getDetailMovies(
        @Path("movie_id") id: String
    ): Call<MovieDetailResponse>

    @GET("tv/popular?api_key=$API_KEY")
    fun getListTVShows(
        @Query("page") page: Int
    ): Call<TvShowResponse>

    @GET("tv/{tv_id}?api_key=$API_KEY")
    fun getDetailTVShows(
        @Path("tv_id") id: String
    ): Call<TvShowDetailResponse>
}