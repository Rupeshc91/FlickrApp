package com.android.flickrapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos")
data class Photo(
    @PrimaryKey
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: Int,
    val title: String
)