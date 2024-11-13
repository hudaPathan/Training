package com.example.training.data

data class ChartData(
    val title: String,
    val chartType: ChartType,
    val data: List<Any>,
    val total: String ="",
    val categories: List <String>?= null

)

enum class ChartType{
    DONUT,
    COLUMN,
    LINE
}