package com.example.sewamobil.ui.welcome.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sewamobil.databinding.ItemSliderBinding
import com.example.sewamobil.ui.welcome.model.SliderItem

class SliderAdapter(private val items: List<SliderItem>) :
    RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    inner class SliderViewHolder(val binding: ItemSliderBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val binding = ItemSliderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SliderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        val item = items[position]
        holder.binding.imageView.setImageResource(item.imageRes)
        holder.binding.textView.text = item.description
    }

    override fun getItemCount() = items.size
}