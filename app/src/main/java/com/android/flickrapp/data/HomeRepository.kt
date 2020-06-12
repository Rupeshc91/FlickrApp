package com.android.flickrapp.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.android.flickrapp.model.Photo
import kotlinx.coroutines.CoroutineScope

interface HomeRepository {
    fun getFlickerPhotos(text:String,coroutineScope: CoroutineScope): LiveData<PagedList<Photo>>

}