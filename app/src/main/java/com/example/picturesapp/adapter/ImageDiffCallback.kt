package com.example.picturesapp.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.picturesapp.model.Data

class ImageDiffCallback : DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem == newItem
    }
}