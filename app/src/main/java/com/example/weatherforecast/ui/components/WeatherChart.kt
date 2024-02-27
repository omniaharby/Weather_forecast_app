package com.example.weatherforecast.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherforecast.data.getData
import com.example.weatherforecast.data.getWeatherChartColor
import com.example.weatherforecast.domain.HourlyWeather
import com.example.weatherforecast.domain.WeatherChartColors

@Composable
fun WeatherChart(data: List<HourlyWeather>, weatherChartColors: WeatherChartColors) {
    LazyRow(
        modifier = Modifier
            .background(
                color = weatherChartColors.backGroundColor,
                shape = RoundedCornerShape(40.dp, 40.dp, 0.dp, 0.dp),
            )
            .padding(20.dp)
    ) {
        items(data) { item -> WeatherItem(weather = item, weatherChartColors) }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowWeatherChart() {
    WeatherChart(data = getData(), getWeatherChartColor())
}