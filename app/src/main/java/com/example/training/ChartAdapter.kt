package com.example.training

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import lecho.lib.hellocharts.model.Line
import lecho.lib.hellocharts.model.LineChartData
import lecho.lib.hellocharts.model.PointValue
import lecho.lib.hellocharts.view.LineChartView

class ChartAdapter(private val chartDataList: List<ChartData>) :
    RecyclerView.Adapter<ChartAdapter.ChartViewHolder>() {

    class ChartViewHolder(val lineChartView: LineChartView) : RecyclerView.ViewHolder(lineChartView) {
        val lineChart: LineChartView = itemView.findViewById(R.id.line_chart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChartViewHolder {
        // Programmatically create LineChartView
        val lineChartView = LineChartView(parent.context)
        lineChartView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            400 // Set a fixed height or adjust as needed
        )
        return ChartViewHolder(lineChartView)
    }

    override fun onBindViewHolder(holder: ChartViewHolder, position: Int) {
        val chartData = chartDataList[position]

        // Create a line with the points from ChartData
        val line = Line(chartData.points).setColor(Color.BLUE).setCubic(true)

        // Create LineChartData and assign it to the chart
        val lineChartData = LineChartData(listOf(line))
        holder.lineChartView.lineChartData = lineChartData
    }

    override fun getItemCount() = chartDataList.size
}
