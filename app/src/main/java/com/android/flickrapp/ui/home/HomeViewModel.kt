package com.android.flickrapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.android.flickrapp.data.HomeRepository
import com.android.flickrapp.di.CoroutineScropeIO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    homeRepository: HomeRepository,
    @CoroutineScropeIO val ioCoroutineScope: CoroutineScope
) : ViewModel() {
    val query = MutableLiveData<String>()

    val flickrPhotos = query.switchMap {
        homeRepository.getFlickerPhotos(it, ioCoroutineScope);
    }

    fun getFlickrPhotos(text: String) {
        query.value = text
    }

    /**
     * Cancel all coroutines when the ViewModel is cleared.
     */
    override fun onCleared() {
        super.onCleared()
        ioCoroutineScope.cancel()
    }
}
