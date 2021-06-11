package com.bimabagaskhoro.submissionjetpactpro3.repository.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.MovieEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.TvShowEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.room.ShowDao

class LocalDataSource private constructor(private val showDao: ShowDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(showDao: ShowDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(showDao).apply {
                INSTANCE = this
            }
    }

    fun getAllDataMovie(): DataSource.Factory<Int, MovieEntity> =
        showDao.getMovies()

    fun getAllDataTVShow(): DataSource.Factory<Int, TvShowEntity> =
        showDao.getTVShows()

    fun getFavMovies(): DataSource.Factory<Int, MovieEntity> = showDao.getFavMovies()

    fun getFavTVShows(): DataSource.Factory<Int, TvShowEntity> = showDao.getFavTVShows()

    fun getMovieById(id: Int): LiveData<MovieEntity> = showDao.getMoviesById(id)

    fun getTVShowById(id: Int): LiveData<TvShowEntity> = showDao.getTVShowsById(id)

    fun insertMovie(movies: List<MovieEntity>) = showDao.insertMovie(movies)

    fun insertTVShow(tvShow: List<TvShowEntity>) = showDao.insertTVShow(tvShow)

    fun updateFavMovie(movies: MovieEntity, newState: Boolean) {
        movies.addFav = newState
        showDao.updateMovie(movies)
    }

    fun updateFavTVShow(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.addFav = newState
        showDao.updateTVShow(tvShow)
    }
}