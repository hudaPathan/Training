package com.example.training

import android.os.Bundle
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import lecho.lib.hellocharts.model.PointValue

class Dashboard : AppCompatActivity() {

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

        for (i in 0 until tabLayout.tabCount) {
            val tab = tabLayout.getTabAt(i)
            val tabView = (tabLayout.getChildAt(0) as ViewGroup).getChildAt(i)
            //tabView?.background = ContextCompat.getDrawable(this, R.drawable.tab_background_selector)
        }
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

        val recyclerViewChart:RecyclerView=findViewById(R.id.recyclerViewChart)
        recyclerViewChart.layoutManager = LinearLayoutManager(this)

        val chartDataList = listOf(
            ChartData(listOf(PointValue(0f, 2f), PointValue(1f, 4f), PointValue(2f, 8f))),
            ChartData(listOf(PointValue(0f, 1f), PointValue(1f, 3f), PointValue(2f, 5f))),
            ChartData(listOf(PointValue(0f, 4f), PointValue(1f, 5f), PointValue(2f, 7f)))
        )

        recyclerViewChart.layoutManager = LinearLayoutManager(this)
        recyclerViewChart.adapter = ChartAdapter(chartDataList)


}}