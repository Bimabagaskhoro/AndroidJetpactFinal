package com.bimabagaskhoro.submissionjetpactpro3.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.MovieEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.TvShowEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.repository.CatalogueRepository
import com.bimabagaskhoro.submissionjetpactpro3.utils.DataDetailDummy
import com.bimabagaskhoro.submissionjetpactpro3.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel

    private val dummyDetailMovie = DataDetailDummy.getDetailMovie()
    private val dummyDetailTVShow = DataDetailDummy.getDetailTVShow()

    private val movieID = dummyDetailMovie.id
    private val tvShowID = dummyDetailTVShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmCatalogueRepository: CatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var tvShowObserver: Observer<Resource<TvShowEntity>>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(filmCatalogueRepository)
    }

    @Test
    fun getDetailMovie() {
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = Resource.success(DataDetailDummy.getDetailMovie())

        Mockito.`when`(filmCatalogueRepository.loadDetailMovies(movieID)).thenReturn(movie)
        viewModel.setDataMovie(movieID).observeForever(movieObserver)
        verify(movieObserver).onChanged(movie.value)
    }

    @Test
    fun getDetailTVShow() {
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = Resource.success(DataDetailDummy.getDetailTVShow())

        Mockito.`when`(filmCatalogueRepository.loadDetailTVShows(tvShowID)).thenReturn(tvShow)
        viewModel.setDataTVShow(tvShowID).observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(tvShow.value)
    }

    @Test
    fun setMovieFav() {
        val movies = MutableLiveData<Resource<MovieEntity>>()
        movies.value = Resource.success(DataDetailDummy.getDetailMovie())

        Mockito.`when`(filmCatalogueRepository.loadDetailMovies(movieID)).thenReturn(movies)

        viewModel.setDataMovie(movieID).observeForever(movieObserver)
        viewModel.setMovieFavorite()
        verify(filmCatalogueRepository).setMoviesFav((movies.value?.data) as MovieEntity, true)
    }

    @Test
    fun setTVShowFav() {
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = Resource.success(DataDetailDummy.getDetailTVShow())

        Mockito.`when`(filmCatalogueRepository.loadDetailTVShows(tvShowID)).thenReturn(tvShow)

        viewModel.setDataTVShow(tvShowID).observeForever(tvShowObserver)
        viewModel.setTvShowFavorite()
        verify(filmCatalogueRepository).setTVShowsFav((tvShow.value?.data) as TvShowEntity, true)
    }
}