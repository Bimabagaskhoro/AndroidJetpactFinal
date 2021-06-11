package com.bimabagaskhoro.submissionjetpactpro3.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.MovieEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.TvShowEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.repository.CatalogueRepository
import com.bimabagaskhoro.submissionjetpactpro3.utils.DataDetailDummy
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {
    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmCatalogueRepository: CatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<PagedList<MovieEntity>>
    @Mock
    private lateinit var tvShowObserver: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var moviePagedList: PagedList<MovieEntity>
    @Mock
    private lateinit var tvShowPagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(filmCatalogueRepository)
    }

    @Test
    fun setFavListMovies() {
        viewModel.setFavListMovie(DataDetailDummy.getDetailMovie())
        verify(filmCatalogueRepository).setMoviesFav(DataDetailDummy.getDetailMovie(), true)
        verifyNoMoreInteractions(filmCatalogueRepository)
    }

    @Test
    fun setFavListTVShows() {
        viewModel.setFavListTVShow(DataDetailDummy.getDetailTVShow())
        verify(filmCatalogueRepository).setTVShowsFav(DataDetailDummy.getDetailTVShow(), true)
        verifyNoMoreInteractions(filmCatalogueRepository)
    }

    @Test
    fun getFavListMovies() {
        val dummyMovie = moviePagedList
        Mockito.`when`(dummyMovie.size).thenReturn(5)
        val movies = MutableLiveData<PagedList<MovieEntity>>()
        movies.value = dummyMovie

        Mockito.`when`(filmCatalogueRepository.getMoviesFav()).thenReturn(movies)
        val favMovie = viewModel.getFavListMovie().value
        verify(filmCatalogueRepository).getMoviesFav()
        Assert.assertNotNull(favMovie)
        Assert.assertEquals(5, favMovie?.size)

        viewModel.getFavListMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getFavListTVShow() {
        val dummyTVShow = tvShowPagedList
        Mockito.`when`(dummyTVShow.size).thenReturn(5)
        val tvShows = MutableLiveData<PagedList<TvShowEntity>>()
        tvShows.value = dummyTVShow

        Mockito.`when`(filmCatalogueRepository.getTVShowsFav()).thenReturn(tvShows)
        val favTVShow = viewModel.getFavListTVShow().value
        verify(filmCatalogueRepository).getTVShowsFav()
        Assert.assertNotNull(favTVShow)
        Assert.assertEquals(5, favTVShow?.size)

        viewModel.getFavListTVShow().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTVShow)
    }
}