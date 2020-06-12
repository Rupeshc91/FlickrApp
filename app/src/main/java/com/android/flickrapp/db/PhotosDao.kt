package com.android.flickrapp.db

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.flickrapp.model.Photo

@Dao
interface PhotosDao {

    @Query("SELECT * from photos where title=:query")
     fun getPhotosByQuery(query: String): DataSource.Factory<Int, Photo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(photos: List<Photo>)
}