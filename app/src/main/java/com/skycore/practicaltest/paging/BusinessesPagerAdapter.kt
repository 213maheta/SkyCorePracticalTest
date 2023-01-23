package com.skycore.practicaltest.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.skycore.practicaltest.databinding.ItemRvBusinessesBinding
import com.skycore.practicaltest.model.Businesses

class BusinessesPagerAdapter : PagingDataAdapter<Businesses, BusinessesPagerAdapter.ViewHolder>(MovieComparator) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.business = getItem(position)
        Glide.with(holder.binding.businessImage).load(holder.binding.business?.imageUrl).into(holder.binding.businessImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRvBusinessesBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    class ViewHolder(val binding: ItemRvBusinessesBinding): RecyclerView.ViewHolder(binding.root) {

    }

    object MovieComparator: DiffUtil.ItemCallback<Businesses>() {
        override fun areItemsTheSame(oldItem: Businesses, newItem: Businesses): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Businesses, newItem: Businesses): Boolean {
            return oldItem == newItem
        }
    }
}