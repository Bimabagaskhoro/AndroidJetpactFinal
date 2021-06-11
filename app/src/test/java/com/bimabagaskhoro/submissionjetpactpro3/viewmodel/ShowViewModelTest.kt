package com.bimabagaskhoro.submissionjetpactpro3.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.MovieEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.TvShowEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.repository.CatalogueRepository
import com.bimabagaskhoro.submissionjetpactpro3.vo.Resource
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ShowViewModelTest {

    private lateinit var viewModel: ShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmCatalogueRepository: CatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var tvObserver: Observer<Resource<PagedList<TvShowEntity>>>

    @Mock
    private lateinit var moviePagedList: PagedList<MovieEntity>

    @Mock
    private lateinit var tvPagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = ShowViewModel(filmCatalogueRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovie = Resource.success(moviePagedList)
        Mockito.`when`(dummyMovie.data?.size).thenReturn(5)
        val movies = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movies.value = dummyMovie

        Mockito.`when`(filmCatalogueRepository.loadMovies()).thenReturn(movies)
        val movieEntity = viewModel.getListMovies().value?.data
        Mockito.verify(filmCatalogueRepository).loadMovies()
        assertNotNull(movieEntity)
        assertEquals(5, movieEntity?.size)

        viewModel.getListMovies().observeForever(movieObserver)
        Mockito.verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getTVShows() {
        val dummyTVShow = Resource.success(tvPagedList)
        Mockito.`when`(dummyTVShow.data?.size).thenReturn(5)
        val tvShows = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        tvShows.value = dummyTVShow

        Mockito.`when`(filmCatalogueRepository.loadTVShows()).thenReturn(tvShows)
        val tvShowEntity = viewModel.getListTVShows().value?.data
        Mockito.verify(filmCatalogueRepository).loadTVShows()
        assertNotNull(tvShowEntity)
        assertEquals(5, tvShowEntity?.size)

        viewModel.getListTVShows().observeForever(tvObserver)
        Mockito.verify(tvObserver).onChanged(dummyTVShow)
    }
}