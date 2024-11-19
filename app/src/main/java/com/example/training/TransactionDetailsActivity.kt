package com.example.training

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TransactionDetailsActivity : AppCompatActivity() {
    lateinit var txtcontact: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_transaction_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtcontact= findViewById(R.id.txtContact)
        val drawable = ContextCompat.getDrawable(this, R.drawable.phone)
        drawable?.setBounds(0, 0, 20, 20)
        txtcontact.setCompoundDrawables(drawable, null, null, null)
    }
}