package com.example.weatherforecast.domain

import androidx.compose.ui.graphics.Color

data class WeatherChartColors(
    val itemBackgroundColor: Color,
    val itemStrokeColor: Color = Color.White,
    val textColor: Color = Color.White,
    val backGroundColor: Color = (Color.White).copy(alpha = 0.33f)
)