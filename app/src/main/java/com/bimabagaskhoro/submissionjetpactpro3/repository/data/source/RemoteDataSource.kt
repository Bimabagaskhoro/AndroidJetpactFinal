package com.bimabagaskhoro.submissionjetpactpro3.repository.data.source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bimabagaskhoro.submissionjetpactpro3.repository.api.ApiClient
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.ApiResponse
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.movie.MovieDetailResponse
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.movie.MovieRemote
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.movie.MovieResponse
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.tvshow.TvShowDetailResponse
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.tvshow.TvShowRemote
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.tvshow.TvShowResponse
import com.bimabagaskhoro.submissionjetpactpro3.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    companion object {
        const val TAG = "Remote Data Source"

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource = instance ?: synchronized(this) {
            RemoteDataSource().apply { instance = this }
        }
    }

    fun getListMovie(): LiveData<ApiResponse<List<MovieRemote>>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<List<MovieRemote>>>()
        ApiClient.getApiEndPoint().getListMovies(1)
            .enqueue(object : Callback<MovieResponse> {
                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    result.value = ApiResponse.success(response.body()?.result as List<MovieRemote>)
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    Log.e(TAG, "Failure to Get List Movie ${t.message}")
                    EspressoIdlingResource.decrement()
                }

            })
        return result
    }

    fun getListTvShow(): LiveData<ApiResponse<List<TvShowRemote>>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<List<TvShowRemote>>>()
        ApiClient.getApiEndPoint().getListTVShows(1)
            .enqueue(object : Callback<TvShowResponse> {
                override fun onResponse(
                    call: Call<TvShowResponse>,
                    response: Response<TvShowResponse>
                ) {
                    result.value =
                        ApiResponse.success(response.body()?.result as List<TvShowRemote>)
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                    Log.e(TAG, "Failure to get List TV Show ${t.message}")
                    EspressoIdlingResource.decrement()
                }

            })
        return result
    }

    fun getDetailMovie(movieId: String): LiveData<ApiResponse<MovieDetailResponse>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<MovieDetailResponse>>()
        ApiClient.getApiEndPoint().getDetailMovies(movieId)
            .enqueue(object : Callback<MovieDetailResponse> {
                override fun onResponse(
                    call: Call<MovieDetailResponse>,
                    response: Response<MovieDetailResponse>
                ) {
                    result.value = ApiResponse.success(response.body() as MovieDetailResponse)
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                    Log.e(TAG, "Failure to get Detail Movies : ${t.message}")
                    EspressoIdlingResource.decrement()
                }

            })
        return result
    }

    fun getDetailTvShow(id: String): LiveData<ApiResponse<TvShowDetailResponse>> {
        EspressoIdlingResource.increment()
        val result = MutableLiveData<ApiResponse<TvShowDetailResponse>>()
        ApiClient.getApiEndPoint().getDetailTVShows(id)
            .enqueue(object : Callback<TvShowDetailResponse> {
                override fun onResponse(
                    call: Call<TvShowDetailResponse>,
                    response: Response<TvShowDetailResponse>
                ) {
                    result.value = ApiResponse.success(response.body() as TvShowDetailResponse)
                    EspressoIdlingResource.decrement()
                }

                override fun onFailure(call: Call<TvShowDetailResponse>, t: Throwable) {
                    Log.e(TAG, "Failure to get Detail TV Show : ${t.message}")
                    EspressoIdlingResource.decrement()
                }

            })
        return result
    }
}