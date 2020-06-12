package com.android.flickrapp.di

import android.app.Application
import com.android.flickrapp.api.ApiService
import com.android.flickrapp.data.HomeRepository
import com.android.flickrapp.data.HomeRepositoryImpl
import com.android.flickrapp.data.PhotosRemoteDataSource
import com.android.flickrapp.db.AppDatabase
import com.android.flickrapp.db.PhotosDao
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun providesHomeRepository(
        dao: PhotosDao,
        remoteDataSource: PhotosRemoteDataSource
    ): HomeRepository =
        HomeRepositoryImpl(dao, remoteDataSource)

    @Provides
    @Singleton
    fun providesAppDatabase(application: Application): AppDatabase =
        AppDatabase.getInstance(application)

    @Provides
    @Singleton
    fun providesPhotoDao(appDatabase: AppDatabase): PhotosDao = appDatabase.photosDao()

    @CoroutineScropeIO
    @Provides
    fun provideCoroutineScopeIO() = CoroutineScope(Dispatchers.IO)

    @Provides
    @Singleton
    fun providesPhotoRemoteDataSource(apiService: ApiService) =
        PhotosRemoteDataSource(apiService)
}