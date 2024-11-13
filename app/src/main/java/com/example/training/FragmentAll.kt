package com.example.training

import com.example.training.adapters.CalculatorAdapter
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.training.data.CalculatorButton
import com.google.android.material.textfield.TextInputLayout

class FragmentAll : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_all, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textInputLayout: TextInputLayout= view.findViewById(R.id.textInputLayout)
        val textInputLayout2: TextInputLayout= view.findViewById(R.id.textInputLayout2)
        val textInputLayout3: TextInputLayout= view.findViewById(R.id.textInputLayout3)




        // Find views and set up UI logic here
        val list_items = listOf("Article", "Article 2", "Article 3", "Article 4","Article 5", "Article 6")
        val autoCompleteTextView:AutoCompleteTextView= view.findViewById(R.id.autocomplete)
        val arrayAdapter= ArrayAdapter(requireContext(),R.layout.list_item,list_items)
        autoCompleteTextView.setAdapter(arrayAdapter)
        autoCompleteTextView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->

            val itemSelected= adapterView.getItemAtPosition(i)
            Toast.makeText(requireContext(), "Item : $itemSelected", Toast.LENGTH_SHORT).show()
        }

        autoCompleteTextView.setOnFocusChangeListener { v, hasFocus ->

            if (autoCompleteTextView.hasFocus())
            {
                textInputLayout.setEndIconDrawable(R.drawable.up)
            }
            else
            {
                textInputLayout.setEndIconDrawable(R.drawable.down)

            }


        }

        //List items for amount
        val list_amount = listOf("$56", "$560", "$23", "$2134")
        val autoCompleteTextView2:AutoCompleteTextView= view.findViewById(R.id.autocomplete2)
        val arrayAdapter2= ArrayAdapter(requireContext(),R.layout.list_item,list_amount)
        autoCompleteTextView2.setAdapter(arrayAdapter2)
        autoCompleteTextView2.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->

            val itemSelected= adapterView.getItemAtPosition(i)
            Toast.makeText(requireContext(), "Item : $itemSelected", Toast.LENGTH_SHORT).show()
        }

        autoCompleteTextView2.setOnFocusChangeListener { v, hasFocus ->

            if (autoCompleteTextView2.hasFocus())
            {
                textInputLayout2.setEndIconDrawable(R.drawable.up)
            }
            else
            {
                textInputLayout2.setEndIconDrawable(R.drawable.down)

            }


        }
        //List items for amount
        val list_quantity= listOf(1,2,3,4,5,6,7,8,9)
        val autoCompleteTextView3:AutoCompleteTextView= view.findViewById(R.id.autocomplete3)
        val arrayAdapter3= ArrayAdapter(requireContext(),R.layout.list_item,list_quantity)
        autoCompleteTextView3.setAdapter(arrayAdapter3)
        autoCompleteTextView3.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->

            val itemSelected= adapterView.getItemAtPosition(i)
            Toast.makeText(requireContext(), "Item : $itemSelected", Toast.LENGTH_SHORT).show()
        }

        autoCompleteTextView3.setOnFocusChangeListener { v, hasFocus ->

            if (autoCompleteTextView3.hasFocus()) {
                textInputLayout3.setEndIconDrawable(R.drawable.up)
            } else {
                textInputLayout3.setEndIconDrawable(R.drawable.down)

            }}

        //List items for tax
       val list_tax= listOf(5,7,9,2,3,6)
        val autoCompleteTextView4:AutoCompleteTextView= view.findViewById(R.id.autocomplete4)
        val arrayAdapter4= ArrayAdapter(requireContext(),R.layout.list_item,list_tax)
        autoCompleteTextView4.setAdapter(arrayAdapter4)
        autoCompleteTextView4.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->

            val itemSelected= adapterView.getItemAtPosition(i)
            Toast.makeText(requireContext(), "Item : $itemSelected", Toast.LENGTH_SHORT).show()
        }


            val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.setOnTouchListener{ _, _ -> false }
        val color1 = Color.rgb(238, 243, 255)
        val color2 = Color.rgb(39 , 174, 96)
        val color3 = Color.WHITE
        val color4 = Color.GRAY

        val buttons = listOf(
            CalculatorButton("1", color1, color4), CalculatorButton("2",color1,color4), CalculatorButton("3", color1,color4), CalculatorButton("4", color1,color4),
            CalculatorButton("5", color1,color4), CalculatorButton("6",color1,color4), CalculatorButton("7", color1,color4), CalculatorButton("8", color1,color4),
            CalculatorButton("9",color1,color4), CalculatorButton("0", color1,color4), CalculatorButton("0", color1,color4), CalculatorButton("+", color2,color3)
        )

        // Set LayoutManager
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        // Set Adapter
        recyclerView.adapter = CalculatorAdapter(buttons) { label ->
            // Handle button clicks here
        }





    }
}