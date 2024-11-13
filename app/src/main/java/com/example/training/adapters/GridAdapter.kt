package com.example.training.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.training.data.GridItems
import com.example.training.R


class GridAdapter (private val box: List<GridItems>) :
RecyclerView.Adapter<GridAdapter.ButtonViewHolder>()
{
    inner class ButtonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val item_image: ImageView = itemView.findViewById(R.id.item_image)
        val item_name: TextView = itemView.findViewById(R.id.item_name)
        val item_price: TextView = itemView.findViewById(R.id.item_price)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_items, parent, false)
        return ButtonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return box.size

    }

    override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
        val box = box[position]
        Glide.with(holder.item_image.context)
            .load(box.image)
            .into(holder.item_image)

        holder.item_name.setText(box.name)
        holder.item_price.setText("$"+box.price)




    }
}


