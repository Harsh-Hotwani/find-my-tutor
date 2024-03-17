package com.example.tutor

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tutor.databinding.PopularfacultiesBinding

class PopularAdapter(private val items:List<String>,private val price:List<String>,private val image:List<Int>) : RecyclerView.Adapter<PopularAdapter.PouplerViewHolder>() {


    override fun onBindViewHolder(holder: PouplerViewHolder, position: Int) {
        val item = items[position]
        val images = image[position]
        val price=price[position]
        holder.bind(item,price,images)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PouplerViewHolder {
        return PouplerViewHolder(PopularfacultiesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class PouplerViewHolder(private val binding: PopularfacultiesBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imagesView = binding.imageView5
        fun bind(item: String,price :String, images: Int) {
            binding.popularfacultyname.text = item
            binding.educationpopular.text = price
            imagesView.setImageResource(images)


        }

    }


}