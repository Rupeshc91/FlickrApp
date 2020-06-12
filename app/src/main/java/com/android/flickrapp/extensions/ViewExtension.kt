package com.android.flickrapp.extensions

import android.widget.ImageView
import com.android.flickrapp.GlideApp
import com.android.flickrapp.R
import com.android.flickrapp.model.Photo

fun ImageView.loadImage(url: String, placeholder: Int = R.drawable.ic_launcher_background) {
    GlideApp.with(context).load(url).placeholder(placeholder).into(this)
}

fun Photo.buildPhotoUrl():String {
    return "http://farm${this.farm}.staticflickr.com/${this.server}/${this.id}_${this.secret}_m.jpg"
}