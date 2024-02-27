package com.example.weatherforecast.data

import androidx.compose.ui.graphics.Color
import com.example.weatherforecast.domain.Condition
import com.example.weatherforecast.domain.CurrentWeather
import com.example.weatherforecast.domain.HourlyWeather
import com.example.weatherforecast.domain.WeatherChartColors
import com.example.weatherforecast.domain.WeatherICon

fun getData() = listOf(
    HourlyWeather("12 PM", Condition.Cloudy, "10"),
    HourlyWeather("12 PM", Condition.Sunny, "10"),
    HourlyWeather("12 PM", Condition.Overcast, "10"),
    HourlyWeather("12 PM", Condition.Clear, "10"),
    HourlyWeather("12 PM", Condition.PartlyCloudy, "10")
)

fun getDailyData() = CurrentWeather("Cairo", "10", Condition.Overcast, "12", "10")

fun getWeatherChartColor() = WeatherChartColors(
    itemBackgroundColor = Color.DarkGray,
    itemStrokeColor = Color.White,
    textColor = Color.White,
)