package com.example.training

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
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

        val recyclerViewChart:WebView=findViewById(R.id.recyclerViewChart)
//        recyclerViewChart.layoutManager = LinearLayoutManager(this)
        val websettings: WebSettings = recyclerViewChart.settings
        websettings.javaScriptEnabled= true
        val htmlContent = """
    <!DOCTYPE html>
    <html>
    <head>
        <script src="https://code.highcharts.com/highcharts.js"></script>
    </head>
    <body>
        <div id="container" style="width:100%; height:100%;"></div>
        <script>
            document.addEventListener("DOMContentLoaded", function() {
                Highcharts.chart('container', {
                    chart: {
                        type: 'line'
                    },
                    title: {
                        text: 'Sample Chart'
                    },
                    xAxis: {
                        categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
                    },
                    series: [{
                        name: 'Temperature',
                        data: [29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]
                    }]
                });
            });
        </script>
    </body>
    </html>
"""
recyclerViewChart.loadDataWithBaseURL(null, "", "text/html","utf-8", null)



    }}