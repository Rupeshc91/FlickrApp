package com.android.flickrapp.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.flickrapp.extensions.buildPhotoUrl
import com.android.flickrapp.extensions.loadImage

@BindingAdapter("photo")
fun setImage(imageView: ImageView, photo: Photo) {
    imageView.loadImage(photo.buildPhotoUrl());
}
@Entity(tableName = "photos")
data class Photo(
    @PrimaryKey
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: Int,
    val title: String
)