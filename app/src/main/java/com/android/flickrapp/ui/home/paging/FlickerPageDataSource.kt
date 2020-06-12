package com.android.flickrapp.ui.home.paging

import androidx.paging.PageKeyedDataSource
import com.android.flickrapp.data.PhotosRemoteDataSource
import com.android.flickrapp.db.PhotosDao
import com.android.flickrapp.model.Photo
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class FlickerPageDataSource(
    val text: String,
    val dao: PhotosDao,
    val flickrPhotoRemoteDataSource: PhotosRemoteDataSource,
    val scope: CoroutineScope
) : PageKeyedDataSource<Int, Photo>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Photo>
    ) {
        loadFlickrPhotos(1, params.requestedLoadSize) {
            callback.onResult(it, null, 2)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
        val page = params.key
        loadFlickrPhotos(page, params.requestedLoadSize) {
            callback.onResult(it, page + 1)
        }
    }

    private fun loadFlickrPhotos(page: Int, perPage: Int, callback: (List<Photo>) -> Unit) {
        scope.launch {
            val response = flickrPhotoRemoteDataSource.getFlickPhotos(text, page, perPage)
            if (com.android.flickrapp.api.Result.Status.SUCCESS == response.status) {
                val results = response.data!!.photos.result
                dao.insertAll(results)
                callback(results)
            } else if (com.android.flickrapp.api.Result.Status.ERROR == response.status) {

            }
        }
    }

    private fun getJobErrorHandler() = CoroutineExceptionHandler { _, e ->
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Photo>) {
        // Do Nothing
    }
}