package com.example.training.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.training.OnButtonClickListener
import com.example.training.data.GridItems
import com.example.training.R


class GridAdapter (private val box: List<GridItems>, private val clickListener: (String) -> Unit) :
RecyclerView.Adapter<GridAdapter.ButtonViewHolder>()
{
    private var selectedPosition = RecyclerView.NO_POSITION

    inner class ButtonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val item_image: ImageView = itemView.findViewById(R.id.item_image)
        val item_name: TextView = itemView.findViewById(R.id.item_name)
        val item_price: TextView = itemView.findViewById(R.id.item_price)
        val cardView:CardView = itemView.findViewById(R.id.cardView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_items, parent, false)
        return ButtonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return box.size

    }

    override fun onBindViewHolder(holder: ButtonViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val box = box[position]
        Glide.with(holder.item_image.context)
            .load(box.image)
            .into(holder.item_image)

        holder.item_name.setText(box.name)
        holder.item_price.setText("$"+box.price)

        if (position == selectedPosition) {
            holder.item_price.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
            holder.item_name.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.secondary))
            holder.cardView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.main))
        } else {
            holder.item_price.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.secondary))
            holder.item_name.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.gray_1))
            holder.cardView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.white))
        }

        holder.itemView.setOnClickListener {
            val previousPosition = selectedPosition
            selectedPosition = position

            // Notify the adapter to refresh previous and new selected items
            notifyItemChanged(previousPosition)
            notifyItemChanged(selectedPosition)
        }

    }
}



