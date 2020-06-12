package com.android.flickrapp.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.android.flickrapp.db.PhotosDao
import com.android.flickrapp.model.Photo
import com.android.flickrsample.home.data.FlickrPageDataSourceFactory
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepositoryImpl @Inject constructor(
    val dao: PhotosDao,
    val remoteDataSource: PhotosRemoteDataSource
) :
    HomeRepository {
    override fun getFlickerPhotos(
        text: String,
        coroutineScope: CoroutineScope
    ): LiveData<PagedList<Photo>> {
        val dataSource =
            FlickrPageDataSourceFactory(text, dao, remoteDataSource, coroutineScope)
        return LivePagedListBuilder(
            dataSource,
            FlickrPageDataSourceFactory.pagedListConfig()
        ).build()
    }
}