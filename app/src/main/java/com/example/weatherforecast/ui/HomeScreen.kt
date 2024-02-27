package com.example.weatherforecast.ui

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherforecast.R
import com.example.weatherforecast.data.getDailyData
import com.example.weatherforecast.data.getData
import com.example.weatherforecast.domain.COLOR_KEY_Vibrant_DARK
import com.example.weatherforecast.domain.WeatherChartColors
import com.example.weatherforecast.domain.extractColorsFromResource
import com.example.weatherforecast.ui.components.DailyWeather
import com.example.weatherforecast.ui.components.WeatherChart

@Composable
fun HomeScreen(context: Context) {

    var backgroundImage: Int by remember {
        mutableStateOf(R.drawable.sunset)
    }
    var colors: Map<String, Color> by remember {
        mutableStateOf(mapOf())
    }
    var weatherChartColors = WeatherChartColors(
        itemBackgroundColor = (colors[COLOR_KEY_Vibrant_DARK] ?: Color.DarkGray).copy(alpha = 0.3f),
    )

    LaunchedEffect(true) {
        extractColorsFromResource(context, backgroundImage) { colors = it }
    }


    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = backgroundImage),
            contentDescription = "Background Image",
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            DailyWeather(currentWeather = getDailyData())
            WeatherChart(data = getData(), weatherChartColors)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowHomeScreen() {

}