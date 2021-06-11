package com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.MovieEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.TvShowEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.source.RemoteDataSource
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.source.local.LocalDataSource
import com.bimabagaskhoro.submissionjetpactpro3.utils.*
import com.bimabagaskhoro.submissionjetpactpro3.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class CatalogueRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val local = Mockito.mock(LocalDataSource::class.java)
    private val appExecutors = Mockito.mock(AppExecutors::class.java)

    private val filmCatalogueRepository = FakeCatalogueRepository(remote, local, appExecutors)

    private val responseMovie = DataDummy.getRemoteMovies()
    private val responseTVShow = DataDummy.getRemoteTVShows()

    private val idMovie = responseMovie[0].id
    private val idTVShow = responseTVShow[0].id

    private val detailMovie = DataDetailDummy.getRemoteDetailMovie()
    private val detailTVShow = DataDetailDummy.getRemoteDetailTVShow()

    @Test
    fun getListMovies() {
        val dataSourceFactory =
            Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        Mockito.`when`(local.getAllDataMovie()).thenReturn(dataSourceFactory)
        filmCatalogueRepository.loadMovies()

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getAllDataMovie()
        assertNotNull(movieEntity.data)
        assertEquals(responseMovie.size.toLong(), movieEntity.data?.size?.toLong())
    }

    @Test
    fun getListTVShows() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        Mockito.`when`(local.getAllDataTVShow()).thenReturn(dataSourceFactory)
        filmCatalogueRepository.loadTVShows()

        val tvShowEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvShow()))
        verify(local).getAllDataTVShow()
        assertNotNull(tvShowEntity)
        assertEquals(responseTVShow.size.toLong(), tvShowEntity.data?.size?.toLong())
    }

    @Test
    fun getDetailMovies() {
        val dummyDetail = MutableLiveData<MovieEntity>()
        dummyDetail.value = DataDetailDummy.getDetailMovie()
        Mockito.`when`(local.getMovieById(idMovie)).thenReturn(dummyDetail)

        val movieDetailEntity =
            LiveDataTestUtil.getValue(filmCatalogueRepository.loadDetailMovies(idMovie))
        verify(local).getMovieById(idMovie)
        assertNotNull(movieDetailEntity)
        assertEquals(detailMovie.id, movieDetailEntity.data?.id)
    }

    @Test
    fun getDetailTVShows() {
        val dummyDetail = MutableLiveData<TvShowEntity>()
        dummyDetail.value = DataDetailDummy.getDetailTVShow()
        Mockito.`when`(local.getTVShowById(idTVShow)).thenReturn(dummyDetail)

        val tvShowDetailEntity =
            LiveDataTestUtil.getValue(filmCatalogueRepository.loadDetailTVShows(idTVShow))
        verify(local).getTVShowById(idTVShow)
        assertNotNull(tvShowDetailEntity)
        assertEquals(detailTVShow.id, tvShowDetailEntity.data?.id)
    }

    @Test
    fun setFavMovie() {
        filmCatalogueRepository.setMoviesFav(DataDetailDummy.getDetailMovie(), true)
        verify(local).updateFavMovie(DataDetailDummy.getDetailMovie(), true)
        verifyNoMoreInteractions(local)
    }

    @Test
    fun getFavMovie() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        Mockito.`when`(local.getFavMovies()).thenReturn(dataSourceFactory)
        filmCatalogueRepository.getMoviesFav()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getFavMovies()
        assertNotNull(movieEntities)
        assertEquals(responseMovie.size, movieEntities.data?.size)
    }
}