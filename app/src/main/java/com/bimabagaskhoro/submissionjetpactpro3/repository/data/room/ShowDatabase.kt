package com.bimabagaskhoro.submissionjetpactpro3.repository.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.MovieEntity
import com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity.TvShowEntity

@Database(entities = [MovieEntity::class, TvShowEntity::class], version = 3, exportSchema = false)
abstract class ShowDatabase : RoomDatabase(){
    abstract fun showDao(): ShowDao

    companion object {

        @Volatile
        private var INSTANCE: ShowDatabase? = null

        fun getInstance(context: Context): ShowDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    ShowDatabase::class.java,
                    "show.db"
                ).fallbackToDestructiveMigration().build().apply { INSTANCE = this }
            }
    }
}