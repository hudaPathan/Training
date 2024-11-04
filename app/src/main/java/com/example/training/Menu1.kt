package com.example.training

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.training.R.id.autocomplete
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Menu1: AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.menu1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.menu1)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition{
            false
        }
        val tabLayout: TabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager: ViewPager2 = findViewById<ViewPager2>(R.id.viewPager)
        val adapter: ViewPageAdapter = ViewPageAdapter(this)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            val tabView= LayoutInflater.from(this).inflate(R.layout.custom_tab,null)
            val tabtitle: TextView= tabView.findViewById(R.id.tab_title)
            // Set tab titles here (you can customize based on position)
            when (position) {
                0 -> tabtitle.text = "All"
                1 -> tabtitle.text = "Dev"
                2 -> tabtitle.text = "Bawaseer"
                3 -> tabtitle.text = "Check"
                4 -> tabtitle.text = "Book"
            }
            tab.customView= tabView
        }.attach()


    }

}