package com.example.training

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ForgotPassword : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.forgot_password)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.forgotPassword)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtSignIn: TextView=findViewById(R.id.txtSignIn)
        txtSignIn.setOnClickListener {
            val intent= Intent(this, Login::class.java)
            startActivity(intent)
        }
        val email:EditText= findViewById(R.id.email_address)
        val btnForgot: Button= findViewById(R.id.btnForgot)
        btnForgot.setOnClickListener{

           if (isValidEmail(email.text.toString().trim()))
            {

                Toast.makeText(this, "Valid email address", Toast.LENGTH_SHORT).show()
                val intent = Intent(this,CreatePassword::class.java )
                startActivity(intent)

            }
            else
            {
                email.error=" Invalid Email Address"
            }

        }

    }
    fun isValidEmail(email: String): Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()

    }

}