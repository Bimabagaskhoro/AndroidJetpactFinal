package com.bimabagaskhoro.submissionjetpactpro3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.MovieEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.TvShowEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.repository.CatalogueRepository
import com.bimabagaskhoro.submissionjetpactpro3.vo.Resource

class ShowViewModel (private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getListMovies(): LiveData<Resource<PagedList<MovieEntity>>> =
        catalogueRepository.loadMovies()

    fun getListTVShows(): LiveData<Resource<PagedList<TvShowEntity>>> =
        catalogueRepository.loadTVShows()
}