package com.android.flickrapp.api

import com.android.flickrapp.model.FlickrPhotoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(PATH_REST)
    suspend fun getFlickerPhotos(
        @Query("text") text: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("method") method: String = "flickr.photos.search",
        @Query("api_key") apiKey: String,
        @Query("format") format: String = "json",
        @Query("nojsoncallback") nonJsonCallback: Int = 1
    ): Response<FlickrPhotoResponse>
}