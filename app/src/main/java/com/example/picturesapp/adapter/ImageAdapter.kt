package com.example.picturesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.picturesapp.R
import com.example.picturesapp.databinding.ItemImageBinding
import com.example.picturesapp.model.Data

class ImageAdapter() :
    ListAdapter<Data, ImageViewHolder>(ImageDiffCallback()) {

    private val image = mutableListOf<Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false).apply {
            return ImageViewHolder(this)
        }
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        getItem(position).let {
            holder.bind(it)
        }
    }

    fun update(newList: MutableList<Data>) {
        image.addAll(newList)
        submitList(newList)
        notifyDataSetChanged()
    }

}

class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding: ItemImageBinding = ItemImageBinding.bind(itemView)

    fun bind(image: Data) {
        Glide.with(itemView.context)
            .load(image.images[0].link)
            .placeholder(R.drawable.ic_placeholder_cat)
            .into(binding.ivImage)
    }
}