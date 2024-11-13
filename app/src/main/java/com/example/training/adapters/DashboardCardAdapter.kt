package com.example.training.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.training.data.DashboardCards
import com.example.training.R

class DashboardCardAdapter (private val box: List<DashboardCards>, private val clickListener: (String) -> Unit) :
    RecyclerView.Adapter<DashboardCardAdapter.ButtonViewHolder>()
{
    inner class ButtonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val item_image: ImageView = itemView.findViewById(R.id.imageView)
        val item_number: TextView = itemView.findViewById(R.id.textNumber)
        val item_action: TextView = itemView.findViewById(R.id.textAction)
        val item_category: TextView = itemView.findViewById(R.id.textCategory)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dashboard_cards, parent, false)
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

        holder.item_action.setText(box.action)
        holder.item_category.setText(box.category)
        holder.item_number.setText(box.number)





    }
}