package com.bimabagaskhoro.submissionjetpactpro3.repository.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.MovieEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.TvShowEntity
import com.bimabagaskhoro.submissionjetpactpro3.vo.Resource

interface ShowDataSource {
    fun loadMovies(): LiveData<Resource<PagedList<MovieEntity>>>
    fun loadTVShows(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun loadDetailMovies(movieID: Int): LiveData<Resource<MovieEntity>>
    fun loadDetailTVShows(tvShowID: Int): LiveData<Resource<TvShowEntity>>

    fun setMoviesFav(movie: MovieEntity, state: Boolean)
    fun setTVShowsFav(tvShow: TvShowEntity, state: Boolean)

    fun getMoviesFav(): LiveData<PagedList<MovieEntity>>
    fun getTVShowsFav(): LiveData<PagedList<TvShowEntity>>
}