package com.android.flickrapp.di

import android.app.Application
import com.android.flickrapp.data.HomeRepositoryImpl
import com.android.flickrapp.data.PhotosRemoteDataSource
import com.android.flickrapp.db.AppDatabase
import com.android.flickrapp.db.PhotosDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun providesHomeRepository(dao: PhotosDao, remoteDataSource: PhotosRemoteDataSource) =
        HomeRepositoryImpl(dao, remoteDataSource)

    @Provides
    @Singleton
    fun providesAppDatabase(application: Application): AppDatabase =
        AppDatabase.getInstance(application)

    @Provides
    @Singleton
    fun providesPhotoDao(appDatabase: AppDatabase): PhotosDao = appDatabase.photosDao()
}