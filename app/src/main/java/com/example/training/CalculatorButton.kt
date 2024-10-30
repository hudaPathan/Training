package com.example.training

import android.graphics.Color

data class CalculatorButton(
    val label: String,
    val bgColor: Int = Color.BLACK,
    val textColor: Int = Color.BLACK)