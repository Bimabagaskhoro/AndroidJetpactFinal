@file:Suppress("DEPRECATION")

package com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.repository

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.NetworkBoundResource
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.MovieEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.TvShowEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.ApiResponse
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.movie.MovieDetailResponse
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.movie.MovieRemote
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.tvshow.TvShowDetailResponse
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.response.tvshow.TvShowRemote
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.source.RemoteDataSource
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.source.ShowDataSource
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.source.local.LocalDataSource
import com.bimabagaskhoro.submissionjetpactpro3.utils.AppExecutors
import com.bimabagaskhoro.submissionjetpactpro3.vo.Resource

class FakeCatalogueRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors,
) : ShowDataSource {

    override fun loadMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<MovieRemote>>(appExecutors) {
            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun loadFromDb(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllDataMovie(), config).build()
            }

            override fun createCall(): LiveData<ApiResponse<List<MovieRemote>>> =
                remoteDataSource.getListMovie()

            override fun saveCallResult(data: List<MovieRemote>) {
                val listMovie = ArrayList<MovieEntity>()
                for (dataMovie in data) {
                    dataMovie.apply {
                        val movie = MovieEntity(
                            id, title, date, image, desc, original_language, imageBackdrop, vote_average, false
                        )
                        listMovie.add(movie)
                    }
                }
                localDataSource.insertMovie(listMovie)
            }
        }.asLiveData()
    }

    override fun loadTVShows(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object :
            NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowRemote>>(appExecutors) {

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun loadFromDb(): LiveData<PagedList<TvShowEntity>> {
                val conf = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllDataTVShow(), conf).build()
            }

            override fun createCall(): LiveData<ApiResponse<List<TvShowRemote>>> =
                remoteDataSource.getListTvShow()

            override fun saveCallResult(data: List<TvShowRemote>) {
                val listTVShow = ArrayList<TvShowEntity>()
                for (dataTVShow in data) {
                    with(dataTVShow) {
                        val tvShow = TvShowEntity(
                            id, title, date, image, desc, original_language, imageBackdrop, vote_average, false
                        )
                        listTVShow.add(tvShow)
                    }
                }
                localDataSource.insertTVShow(listTVShow)
            }
        }.asLiveData()
    }

    override fun loadDetailMovies(movieID: Int): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, MovieDetailResponse>(appExecutors) {
            override fun shouldFetch(data: MovieEntity?): Boolean =
                data == null

            override fun loadFromDb(): LiveData<MovieEntity> = localDataSource.getMovieById(movieID)
            override fun createCall(): LiveData<ApiResponse<MovieDetailResponse>> =
                remoteDataSource.getDetailMovie(movieID.toString())

            override fun saveCallResult(data: MovieDetailResponse) {
                with(data) {
                    val dataDetailMovie = MovieEntity(
                        id = id,
                        title = title,
                        date = date,
                        desc = desc,
                        image = image,
                        original_language = original_language,
                        imageBackdrop = imageBackdrop,
                        vote_average = vote_average,
                        addFav = false
                    )
                    localDataSource.updateFavMovie(dataDetailMovie, false)
                }
            }
        }.asLiveData()
    }

    override fun loadDetailTVShows(tvShowID: Int): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, TvShowDetailResponse>(appExecutors) {
            override fun shouldFetch(data: TvShowEntity?): Boolean = data == null

            override fun loadFromDb(): LiveData<TvShowEntity> =
                localDataSource.getTVShowById(tvShowID)

            override fun createCall(): LiveData<ApiResponse<TvShowDetailResponse>> =
                remoteDataSource.getDetailTvShow(tvShowID.toString())

            override fun saveCallResult(data: TvShowDetailResponse) {
                with(data) {
                    val dataDetailTVShow = TvShowEntity(
                        id = id,
                        title = title,
                        date = date,
                        desc = desc,
                        image = image,
                        original_language = original_language,
                        imageBackdrop = imageBackdrop,
                        vote_average = vote_average,
                        addFav = false
                    )
                    localDataSource.updateFavTVShow(dataDetailTVShow, false)
                }
            }
        }.asLiveData()
    }

    override fun setMoviesFav(movie: MovieEntity, state: Boolean) {
        localDataSource.updateFavMovie(movie, state)
    }

    override fun setTVShowsFav(tvShow: TvShowEntity, state: Boolean) {
        localDataSource.updateFavTVShow(tvShow, state)
    }

    override fun getMoviesFav(): LiveData<PagedList<MovieEntity>> {
        val conf = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavMovies(), conf).build()
    }

    override fun getTVShowsFav(): LiveData<PagedList<TvShowEntity>> {
        val conf = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavTVShows(), conf).build()
    }


}