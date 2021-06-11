@file:Suppress("UNREACHABLE_CODE")

package com.bimabagaskhoro.submissionjetpactpro3.di

import android.content.Context
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.remote.repository.CatalogueRepository
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.room.ShowDatabase
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.source.RemoteDataSource
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.source.local.LocalDataSource
import com.bimabagaskhoro.submissionjetpactpro3.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): CatalogueRepository {
        val db = ShowDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(db.showDao())
        val appExecutors = AppExecutors()

        return CatalogueRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}