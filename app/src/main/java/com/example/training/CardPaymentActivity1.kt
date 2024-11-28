package com.example.training

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CardPaymentActivity1 : AppCompatActivity() {
    lateinit var txtdisc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_card_payment1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtdisc= findViewById(R.id.txtDisc)
        val drawable = ContextCompat.getDrawable(this, R.drawable.disc_percent)
        drawable?.setBounds(0, 0, 20, 20)
        txtdisc.setCompoundDrawables(drawable, null, null, null)
        txtdisc.compoundDrawablePadding=10
    }
}