package com.example.training

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CreatePassword:AppCompatActivity() {
    val isPasswordVisible:Boolean= false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.create_password)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.createPassword)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtSignIn :TextView= findViewById(R.id.signIn)
        txtSignIn.setOnClickListener{
            val intent = Intent (this, Login::class.java)
            startActivity(intent)
        }
        val txtPassword:TextView=findViewById(R.id.pass)
        val txtCPassword:TextView=findViewById(R.id.cpass)

        


        val btnReset: Button= findViewById(R.id.btnreset)
        btnReset.setOnClickListener {
            if (txtPassword.text.toString() == txtCPassword.text.toString())
            {
                Toast.makeText(this, "Matched", Toast.LENGTH_SHORT).show()
            }
            else
            {
                txtPassword.error="Password not matched"
            }


        }


    }


}
