package com.example.training

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.training.adapters.GridAdapter
import com.example.training.adapters.SelectDiscountAdapter
import com.example.training.data.GridItems

class SalesChartActivity : AppCompatActivity(), OnButtonClickListener{
    lateinit var editText:EditText
    @SuppressLint("UseSwitchCompatOrMaterialCode", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sales_chart)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.saleschart)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val data= listOf(
            GridItems(R.drawable.item_1, "Clock", "12"),
            GridItems(R.drawable.item_2, "Clock", "12"),
            GridItems(R.drawable.item_1, "Clock", "12"),
            GridItems(R.drawable.item_2, "Clock", "12")
        )

        val recyclerView1:RecyclerView=findViewById(R.id.recyclerView1)
        val imageAdapter= GridAdapter(data)
        recyclerView1.adapter=imageAdapter
        recyclerView1.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

         editText= findViewById(R.id.editText)
        val txtLess:TextView= findViewById(R.id.qt_less)
        val txtVal:TextView= findViewById(R.id.qt_val)
        val txtMore:TextView= findViewById(R.id.qt_more)
        val txtoriginal:TextView= findViewById(R.id.originalAmount)

        var quantity=1;

        txtVal.setText(quantity.toString())
        txtLess.setOnClickListener {
            quantity--
            txtVal.setText(quantity.toString())
            if (quantity==1)
            {
                txtLess.isClickable=false
            }

        }
        txtMore.setOnClickListener {
            quantity++
            txtVal.setText(quantity.toString())
            txtLess.isClickable=true

        }


        val disData= listOf("5%", "10%", "15%", "20%" )
        val recyclerView2:RecyclerView=findViewById(R.id.recyclerView2)
        val adapter= SelectDiscountAdapter(disData, this)
        recyclerView2.adapter=adapter
        recyclerView2.layoutManager=GridLayoutManager(this,2)

        val switch: Switch= findViewById(R.id.on)
        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                editText.visibility=View.VISIBLE
            }
            else

            {
                editText.visibility=View.INVISIBLE
            }

        }
    }

    override fun onButtonClicked(buttonText: String) {
        editText.setText(buttonText)

    }
}
interface OnButtonClickListener {
    fun onButtonClicked(buttonText: String)
}