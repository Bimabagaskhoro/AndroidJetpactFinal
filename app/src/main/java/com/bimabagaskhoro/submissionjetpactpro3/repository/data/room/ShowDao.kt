package com.bimabagaskhoro.submissionjetpactpro3.repository.data.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.MovieEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.TvShowEntity

@Dao
interface ShowDao {

    @Query("SELECT * FROM movie_entity")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tv_show_entity")
    fun getTVShows(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM movie_entity WHERE addFav = 1")
    fun getFavMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tv_show_entity WHERE addFav = 1")
    fun getFavTVShows(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM movie_entity WHERE id = :id")
    fun getMoviesById(id: Int): LiveData<MovieEntity>

    @Query("SELECT * FROM tv_show_entity WHERE id = :id")
    fun getTVShowsById(id: Int): LiveData<TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTVShow(tvShow: List<TvShowEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateTVShow(tvShow: TvShowEntity)
}