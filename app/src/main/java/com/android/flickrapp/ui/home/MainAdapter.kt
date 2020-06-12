package com.android.flickrapp.ui.home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.flickrapp.databinding.ViewPhotoItemBinding
import com.android.flickrapp.model.Photo

class MainAdapter : PagedListAdapter<Photo, MainAdapter.ViewHolder>(PhotosDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ViewPhotoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = getItem(position)
        photo?.let {
            holder.apply {
                bindView(photo)
            }
        }
    }

    class ViewHolder(val binding: ViewPhotoItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(photo: Photo) {
            binding.photo = photo
            binding.executePendingBindings()
        }
    }
}

private class PhotosDiffCallback : DiffUtil.ItemCallback<Photo>() {
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem == newItem
    }

}