package com.example.training

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.training.adapters.GridAdapter
import com.example.training.data.GridItems
import com.google.android.material.tabs.TabLayout

class MenuActivity: AppCompatActivity(){
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

        val tabNames = listOf("All", "Dev", "Bawaseer", "Check", "Book")
        for (name in tabNames){
            tabLayout.addTab(tabLayout.newTab().setText(name))
        }




        val DevData= listOf(
            GridItems(R.drawable.item_2, "Clock", "$12"),
            GridItems(R.drawable.item_2, "Clock", "$12"),
            GridItems(R.drawable.item_2, "Clock", "$12"),
            GridItems(R.drawable.item_2, "Clock", "$12"),
            GridItems(R.drawable.item_2, "Clock", "$12"),
            GridItems(R.drawable.item_2, "Clock", "$12"),
            GridItems(R.drawable.item_2, "Clock", "$12"),
            GridItems(R.drawable.item_2, "Clock", "$12")
        )

        val CheckData= listOf(
            GridItems(R.drawable.item_1, "Clock", "$12"),
            GridItems(R.drawable.item_2, "Clock", "$12"),
            GridItems(R.drawable.item_1, "Clock", "$12"),
            GridItems(R.drawable.item_2, "Clock", "$12"),
            GridItems(R.drawable.item_1, "Clock", "$12"),
            GridItems(R.drawable.item_2, "Clock", "$12"),
            GridItems(R.drawable.item_1, "Clock", "$12"),
            GridItems(R.drawable.item_2, "Clock", "$12")
        )
        val BookData= listOf(
            GridItems(R.drawable.item_1, "Clock", "$12"),
            GridItems(R.drawable.item_2, "Clock", "$12"),
            GridItems(R.drawable.item_1, "Clock", "$12"),
            GridItems(R.drawable.item_2, "Clock", "$12"),
            GridItems(R.drawable.item_1, "Clock", "$12"),
            GridItems(R.drawable.item_2, "Clock", "$12"),
            GridItems(R.drawable.item_1, "Clock", "$12"),
            GridItems(R.drawable.item_2, "Clock", "$12")
        )

        val BawData= listOf(
            GridItems(R.drawable.item_1, "Clock", "$12"),
            GridItems(R.drawable.item_2, "Clock", "$12"),
            GridItems(R.drawable.item_1, "Clock", "$12"),
            GridItems(R.drawable.item_2, "Clock", "$12"),
            GridItems(R.drawable.item_1, "Clock", "$12"),
            GridItems(R.drawable.item_2, "Clock", "$12"),
            GridItems(R.drawable.item_1, "Clock", "$12"),
            GridItems(R.drawable.item_2, "Clock", "$12")
        )


        val dataMap = mapOf(
            "Dev" to DevData,
            "Bawaseer" to BawData,
            "Check" to CheckData,
            "Book" to BookData
        )

        val recyclerView:RecyclerView= findViewById(R.id.recyclerView)

        val fragment = FragmentAll()
        supportFragmentManager.beginTransaction()
            .replace(R.id.contentFrame, fragment)
            .commit()
        recyclerView.visibility = View.GONE
        findViewById<FrameLayout>(R.id.contentFrame).visibility = View.VISIBLE

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                // Check if tab is not null and log the tab text
                val tabText = tab?.text.toString()
                Log.d("TabSelected", "Selected tab: $tabText")

                if (tabText== "All")
                {
                    val fragment = FragmentAll()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.contentFrame, fragment)
                        .commit()
                    recyclerView.visibility = View.GONE
                    findViewById<FrameLayout>(R.id.contentFrame).visibility = View.VISIBLE


                }
                else{
                    recyclerView.visibility = View.VISIBLE
                    findViewById<FrameLayout>(R.id.contentFrame).visibility = View.GONE

                    val imageAdapter = GridAdapter(dataMap[tabText] ?: emptyList())
                    {
                        //Handle  CLick

                    }
                    recyclerView.adapter= imageAdapter
                    recyclerView.layoutManager= GridLayoutManager(this@MenuActivity, 2)
                }


            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })



    }




}


