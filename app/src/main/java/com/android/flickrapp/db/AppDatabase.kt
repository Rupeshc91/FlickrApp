package com.android.flickrapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.flickrapp.model.Photo

@Database(entities = [Photo::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun photosDao(): PhotosDao

    companion object {

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildRoomDatabase(context).also {
                    instance = it
                }
            }
        }

        fun buildRoomDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "flickr-db").build()
        }

    }
}