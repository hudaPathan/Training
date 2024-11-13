package com.example.training

import com.example.training.adapters.CalculatorAdapter
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.training.data.CalculatorButton

class CalculatorActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val color1 = Color.rgb(238, 243, 255)
        val color2 = Color.rgb(39 , 174, 96)
        val color5 = Color.rgb(235,87,87)
        val color3 = Color.WHITE
        val color4 = Color.GRAY

        // Data for buttons
        val buttons = listOf(
            CalculatorButton("1", color1, color4), CalculatorButton("2",color1,color4), CalculatorButton("3", color1,color4), CalculatorButton("4", color1,color4),
            CalculatorButton("5", color1,color4), CalculatorButton("6",color1,color4), CalculatorButton("7", color1,color4), CalculatorButton("8", color1,color4),
            CalculatorButton("9",color1,color4), CalculatorButton("C", color5,color3), CalculatorButton("0", color1,color4), CalculatorButton("+", color2,color3)
        )

        // Set LayoutManager
        recyclerView.layoutManager = GridLayoutManager(this, 3) // 3 columns

        // Set Adapter
        recyclerView.adapter = CalculatorAdapter(buttons) { label ->
            // Handle button clicks here
            handleButtonClick(label)
        }

        val button: Button = findViewById(R.id.btnCard)
        button.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun handleButtonClick(label: String) {
        // Implement calculator logic here
        Toast.makeText(this, "Clicked: $label", Toast.LENGTH_SHORT).show()
    }
}