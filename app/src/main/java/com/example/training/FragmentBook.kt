package com.example.training

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentBook : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.gridlayout)

        val grid= listOf(
            Items(R.drawable.item_1, "Clock", "$12"),
            Items(R.drawable.item_2, "Clock", "$12"),
            Items(R.drawable.item_1, "Clock", "$12"),
            Items(R.drawable.item_2, "Clock", "$12"),
            Items(R.drawable.item_1, "Clock", "$12"),
            Items(R.drawable.item_2, "Clock", "$12"),
            Items(R.drawable.item_1, "Clock", "$12"),
            Items(R.drawable.item_2, "Clock", "$12")
        )
        recyclerView.layoutManager= GridLayoutManager(view.context, 2)
        recyclerView.adapter = ImageAdapter(grid) { label ->
            // Handle button clicks here
        }
    }
}