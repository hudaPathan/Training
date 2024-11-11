import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.training.ChartData
import com.example.training.ChartType
import com.example.training.R
import com.highsoft.highcharts.common.HIColor
import com.highsoft.highcharts.common.hichartsclasses.HIAxis
import com.highsoft.highcharts.common.hichartsclasses.HICSSObject
import com.highsoft.highcharts.common.hichartsclasses.HIChart
import com.highsoft.highcharts.common.hichartsclasses.HIColumn
import com.highsoft.highcharts.common.hichartsclasses.HIDataLabels
import com.highsoft.highcharts.common.hichartsclasses.HIExporting
import com.highsoft.highcharts.common.hichartsclasses.HIFontMetricsObject
import com.highsoft.highcharts.common.hichartsclasses.HILegend
import com.highsoft.highcharts.common.hichartsclasses.HILine
import com.highsoft.highcharts.common.hichartsclasses.HIOptions
import com.highsoft.highcharts.common.hichartsclasses.HIPie
import com.highsoft.highcharts.common.hichartsclasses.HISeries
import com.highsoft.highcharts.common.hichartsclasses.HIStyle
import com.highsoft.highcharts.common.hichartsclasses.HISubtitle
import com.highsoft.highcharts.common.hichartsclasses.HITitle
import com.highsoft.highcharts.common.hichartsclasses.HIXAxis
import com.highsoft.highcharts.common.hichartsclasses.HIYAxis

import com.highsoft.highcharts.core.HIChartView
import kotlin.collections.ArrayList

class ChartAdapter(private val chartList: List<ChartData>) :
    RecyclerView.Adapter<ChartAdapter.ChartViewHolder>() {

    inner class ChartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val chartView: HIChartView = itemView.findViewById(R.id.chart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chart_items, parent, false)
        return ChartViewHolder(view)
    }

    override fun getItemCount(): Int = chartList.size

    override fun onBindViewHolder(holder: ChartViewHolder, position: Int) {
        val chartData = chartList[position]

        // Configure the chart
        val options = HIOptions()

        when (chartData.chartType)
        {
            ChartType.DONUT -> setupDonutChart(options, chartData)
            ChartType.LINE -> setupLineChart(options, chartData)
            ChartType.COLUMN -> setupColumnChart(options, chartData)
        }
        // Apply options to chart view
        holder.chartView.options = options

    }

    private fun setupChart(options:HIOptions, chartData: ChartData)
    {

        val title = HITitle()
        title.text = chartData.title
        title.align="left"
        options.title = title


        val exporting= HIExporting()
        exporting.enabled=false
        options.exporting=exporting
    }

     private fun setupDonutChart(options:HIOptions, chartData: ChartData){
         val chart = HIChart()
         chart.type = "pie"
         options.chart = chart

         setupChart(options,chartData)


         val subtitle = HISubtitle()
         subtitle.text= chartData.total
         subtitle.align="center"
         subtitle.verticalAlign="middle"
         subtitle.y=0

         val style = HICSSObject()
         style.fontSize="18"
         style.fontWeight="normal"
         style.fontFamily="Roboto-Light"
         subtitle.style= style

         options.subtitle= subtitle


         val seriesPie= HIPie()
         seriesPie.data = chartData.data.toCollection(ArrayList())
         seriesPie.innerSize = "70%"
         seriesPie.borderWidth=0
         seriesPie.size="80%"

         val datalabels = HIDataLabels()
         datalabels.enabled= false
         seriesPie.dataLabels= arrayListOf(datalabels)
         options.series = ArrayList<HISeries>().apply { add(seriesPie) }



     }

     private fun setupColumnChart(options: HIOptions, chartData: ChartData)
     {
         val chart = HIChart()
         chart.type = "column"
         options.chart = chart

         setupChart(options,chartData)


         val xAxis = HIXAxis()
         xAxis.categories = chartData.categories?.toCollection(ArrayList()) ?: arrayListOf()
         options.xAxis = arrayListOf(xAxis)

         val seriesData = chartData.data as List<List<Number>>
         val series1 = HIColumn()
         series1.name = "Category 1"
         series1.data = seriesData[0].toCollection(ArrayList())

         val series2 = HIColumn()
         series2.name = "Category 2"
         series2.data = seriesData[1].toCollection(ArrayList())

         options.series = arrayListOf(series1, series2)
     }

    private fun setupLineChart(options: HIOptions, chartData: ChartData) {
        val chart = HIChart()
        chart.type = "line"
        options.chart = chart

        setupChart(options,chartData)


        val xAxis = HIXAxis()
        xAxis.categories = chartData.categories?.toCollection(ArrayList())
        options.xAxis = arrayListOf(xAxis)

        val series = HILine()
        series.name = chartData.title
        series.data = chartData.data.toCollection(ArrayList())
        options.series = arrayListOf(series)
    }
}