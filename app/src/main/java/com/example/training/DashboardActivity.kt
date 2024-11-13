package com.example.training

import com.example.training.adapters.ChartAdapter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.training.adapters.DashboardCardAdapter
import com.example.training.data.ChartData
import com.example.training.data.ChartType
import com.example.training.data.DashboardCards
import com.google.android.material.tabs.TabLayout

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.dashboard)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)


        val tabNames= listOf("Transaction Summary", "Sales Trends")
        for (name in tabNames){
            tabLayout.addTab(tabLayout.newTab().setText(name))
        }

    val recyclerView:RecyclerView=findViewById(R.id.recyclerView)
        val items= listOf(
            DashboardCards(R.drawable.dashboard_icon1, "560", "Approved", "Instore Mobile & Transactions"),
            DashboardCards(R.drawable.dashboard_icon1, "456","Pending", "Invoice Transactions"),
            DashboardCards(R.drawable.dashboard_icon1, "654","Completed", "Invoice Transactions"),
            DashboardCards(R.drawable.dashboard_icon1, "123","Late", "Invoice Transactions"),
        )
      recyclerView.layoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter= DashboardCardAdapter(items){}



        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position)
                {
                    0 ->  setupChart()
                    1 -> setupChart()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                setupChart()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }


        })

    }
    private fun setupChart ()
    {
        val dataPie=listOf(
            arrayListOf("Category A", 10),
            arrayListOf("Category B", 25),
            arrayListOf("Category C", 20)
        )
        val totalPie= dataPie.sumOf { it[1] as Int }

        val dataCol=listOf(
            listOf(387749, 280000, 129000, 64300, 54000, 34300),
            listOf(45321, 140000, 10000, 140500, 19500, 113500)
        )

        val categoryCol = listOf("Year 1", "Year 2", "Year 3", "Year 4", "Year 5", "Year 6")

        val dataLine= listOf(10, 20, 15, 30, 40)
        val categoryLine = listOf("Jan", "Feb", "Mar", "Apr", "May")
        val chartList = listOf(

            ChartData(
                title = "Line Chart",
                chartType = ChartType.LINE,
                data = dataLine,
                categories = categoryLine),

            ChartData(
                title = "Column Chart",
                chartType = ChartType.COLUMN,
                data = dataCol,
                categories = categoryCol
            ),


            ChartData(
                title = "Donut Chart",
                chartType = ChartType.DONUT,
                data = dataPie,
                total = "Total\n $totalPie"
            )
        )


        val recyclerViewChart = findViewById<RecyclerView>(R.id.recyclerViewChart)
        recyclerViewChart.layoutManager = LinearLayoutManager(this)
        recyclerViewChart.adapter = ChartAdapter(chartList)
    }
}
