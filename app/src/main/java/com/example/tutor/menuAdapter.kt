package com.example.tutor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tutor.databinding.MenuItemBinding

class menuAdapter(private val menuItemsName: MutableList<String>,private val menuItemeducation: MutableList<String>,private val menuImage:MutableList<Int>) : RecyclerView.Adapter<menuAdapter.MenuViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): menuAdapter.MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return (MenuViewHolder(binding))
    }

    override fun getItemCount(): Int = menuItemsName.size

    override fun onBindViewHolder(holder: menuAdapter.MenuViewHolder, position: Int) {
        holder.bind(position)
    }



    inner class MenuViewHolder(private val binding :MenuItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                menufacultyname.text = menuItemsName[position]
                menueducation.text = menuItemeducation[position]
                menuimage.setImageResource(menuImage[position])

            }
        }

    }
}