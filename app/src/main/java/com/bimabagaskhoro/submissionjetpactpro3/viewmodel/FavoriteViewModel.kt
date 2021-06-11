package com.bimabagaskhoro.submissionjetpactpro3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.MovieEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.TvShowEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.repository.CatalogueRepository

class FavoriteViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getFavListMovie(): LiveData<PagedList<MovieEntity>> = catalogueRepository.getMoviesFav()

    fun getFavListTVShow(): LiveData<PagedList<TvShowEntity>> = catalogueRepository.getTVShowsFav()

    fun setFavListMovie(movieEntity: MovieEntity) {
        val newState = !movieEntity.addFav
        catalogueRepository.setMoviesFav(movieEntity, newState)
    }

    fun setFavListTVShow(tvShowEntity: TvShowEntity) {
        val newState = !tvShowEntity.addFav
        catalogueRepository.setTVShowsFav(tvShowEntity, newState)
    }
}