package com.android.flickrapp.data

import com.android.flickrapp.api.ApiService
import com.android.flickrapp.api.BaseDataSource
import javax.inject.Inject

class PhotosRemoteDataSource @Inject constructor(val apiService: ApiService) : BaseDataSource() {
    suspend fun getFlickPhotos(
        text: String, page: Int, perPage: Int
    ) = getResult {
        apiService.getFlickerPhotos(text, page, perPage)
    }
}