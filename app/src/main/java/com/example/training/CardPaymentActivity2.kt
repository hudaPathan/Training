package com.example.training

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class CardPaymentActivity2 : AppCompatActivity() {
    lateinit var edtCardNUmber: TextInputEditText
    lateinit var edtExpiryDate: TextInputEditText
    lateinit var edtCCV: TextInputEditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_card_payment2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        edtCardNUmber= findViewById(R.id.edtCardNumber)
        edtExpiryDate= findViewById(R.id.edtExpiryDate)
        edtCCV= findViewById(R.id.edtCCV)


        val drawable = ContextCompat.getDrawable(this, R.drawable.card)
        drawable?.setBounds(0, 0, 20, 20)
        edtCardNUmber.setCompoundDrawables(drawable, null, null, null)
        edtCardNUmber.compoundDrawablePadding=10

        edtExpiryDate.setCompoundDrawables(null, null, drawable, null)
        edtExpiryDate.compoundDrawablePadding=10

        edtCCV.setCompoundDrawables(null, null, drawable, null)
        edtCCV.compoundDrawablePadding=10



    }
}