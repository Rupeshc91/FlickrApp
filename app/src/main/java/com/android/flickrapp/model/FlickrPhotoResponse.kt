package com.android.flickrapp.model

import com.elifox.legocatalog.api.ResultsResponse
import com.google.gson.annotations.SerializedName

data class FlickrPhotoResponse(@SerializedName("photos") val photos: ResultsResponse<Photo>)