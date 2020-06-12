package com.android.flickrsample.home.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import com.android.flickrapp.data.PhotosRemoteDataSource
import com.android.flickrapp.db.PhotosDao
import com.android.flickrapp.model.Photo
import com.android.flickrapp.ui.home.paging.FlickerPageDataSource
import kotlinx.coroutines.CoroutineScope

class FlickrPageDataSourceFactory(
    val text: String,
    val dao: PhotosDao,
    val flickrPhotoRemoteDataSource: PhotosRemoteDataSource,
    val coroutineScope: CoroutineScope
) : DataSource.Factory<Int, Photo>() {

    private val liveData = MutableLiveData<FlickerPageDataSource>()

    override fun create(): DataSource<Int, Photo> {
        val source = FlickerPageDataSource(text, dao, flickrPhotoRemoteDataSource, coroutineScope)
        liveData.postValue(source)
        return source
    }

    companion object {

        private const val PAGE_SIZE = 50

        fun pagedListConfig() = PagedList.Config.Builder()
            .setInitialLoadSizeHint(PAGE_SIZE)
            .setPageSize(PAGE_SIZE)
            .setEnablePlaceholders(true).build()
    }
}