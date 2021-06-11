package com.bimabagaskhoro.submissionjetpactpro3.repository.data.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie_entity")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "date")
    val date: String,

    @ColumnInfo(name = "image")
    val image: String,

    @ColumnInfo(name = "desc")
    val desc: String,

    @ColumnInfo(name = "original_language")
    val original_language: String,

    @SerializedName("backdrop_path")
    val imageBackdrop: String,

    @SerializedName("vote_average")
    val vote_average: Double,

    @ColumnInfo(name = "addFav")
    var addFav: Boolean = false
)
