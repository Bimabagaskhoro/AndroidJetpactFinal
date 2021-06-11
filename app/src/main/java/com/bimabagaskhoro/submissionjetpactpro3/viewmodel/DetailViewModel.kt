package com.bimabagaskhoro.submissionjetpactpro3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.MovieEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.TvShowEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.repository.CatalogueRepository
import com.bimabagaskhoro.submissionjetpactpro3.vo.Resource

class DetailViewModel (private val catalogueRepository: CatalogueRepository) :
    ViewModel(){

    private lateinit var dataDetailMovie: LiveData<Resource<MovieEntity>>
    private lateinit var dataDetailTvShow: LiveData<Resource<TvShowEntity>>

    fun setDataMovie(movieId: Int) : LiveData<Resource<MovieEntity>> {
        dataDetailMovie = catalogueRepository.loadDetailMovies(movieId)
        return dataDetailMovie
    }

    fun setDataTVShow(tvShowId: Int) : LiveData<Resource<TvShowEntity>> {
        dataDetailTvShow = catalogueRepository.loadDetailTVShows(tvShowId)
        return dataDetailTvShow
    }

    fun setMovieFavorite() {
        val dataMovie = dataDetailMovie.value
        if (dataMovie?.data != null) {
            val newState = !dataMovie.data.addFav
            catalogueRepository.setMoviesFav(dataMovie.data, newState)
        }
    }

    fun setTvShowFavorite() {
        val dataTVShow = dataDetailTvShow.value
        if (dataTVShow?.data != null) {
            val newState = !dataTVShow.data.addFav
            catalogueRepository.setTVShowsFav(dataTVShow.data, newState)
        }
    }
}