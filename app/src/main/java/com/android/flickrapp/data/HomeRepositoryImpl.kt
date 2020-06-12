package com.android.flickrapp.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.android.flickrapp.db.PhotosDao
import com.android.flickrapp.model.Photo
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(dao: PhotosDao, remoteDataSource: PhotosRemoteDataSource) :
    HomeRepository {
    override fun getFlickerPhotos(
        text: String,
        coroutineScope: CoroutineScope
    ): LiveData<PagedList<Photo>> {
    }
}