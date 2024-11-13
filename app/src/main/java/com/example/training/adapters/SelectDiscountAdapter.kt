package com.example.training.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat

import androidx.recyclerview.widget.RecyclerView
import com.example.training.OnButtonClickListener
import com.example.training.R

class SelectDiscountAdapter(private val item: List<String>, private val listener: OnButtonClickListener) :
RecyclerView.Adapter<SelectDiscountAdapter.ButtonViewHolder>()
 {
     private var selectedPosition = RecyclerView.NO_POSITION

     inner class ButtonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val discount: Button = itemView.findViewById(R.id.btn_select)
         fun bind(text: String, isSelected: Boolean) {
             discount.text = text
             discount.isSelected = isSelected  // Set the button state based on selection
            discount.setBackgroundResource(R.drawable.button_background_selector)
         }


     }
     override fun onCreateViewHolder(
         parent: ViewGroup,
         viewType: Int
     ): SelectDiscountAdapter.ButtonViewHolder {
         val view = LayoutInflater.from(parent.context).inflate(R.layout.quickdiscount_item, parent, false)
         return ButtonViewHolder(view)

     }

     override fun getItemCount(): Int {return item.size }

     override fun onBindViewHolder(holder: SelectDiscountAdapter.ButtonViewHolder, @SuppressLint("RecyclerView") position: Int) {
         holder.discount.isSelected= false
         val text = item[position]

         holder.discount.setText(text)
         holder.discount.setOnClickListener {
             holder.discount.isSelected= !holder.discount.isSelected }

         holder.bind(item[position], position == selectedPosition)

         holder.discount.setOnClickListener {
             // Update selected position
             val previousPosition = selectedPosition
             selectedPosition = position

             // Notify RecyclerView to update previous and current positions
             notifyItemChanged(previousPosition)
             notifyItemChanged(selectedPosition)

             listener.onButtonClicked(text)
         }

     }
 }