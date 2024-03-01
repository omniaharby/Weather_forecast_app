package com.example.weatherforecast.ui

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherforecast.domain.COLOR_KEY_Vibrant_DARK
import com.example.weatherforecast.domain.Condition
import com.example.weatherforecast.domain.WeatherChartColors
import com.example.weatherforecast.domain.conditionToBackgroundImage
import com.example.weatherforecast.domain.extractColorsFromResource
import com.example.weatherforecast.ui.components.DailyWeather
import com.example.weatherforecast.ui.components.RetryConnection
import com.example.weatherforecast.ui.components.WeatherChart

@Composable
fun HomeScreen(context: Context, viewModel: HomeViewModel = hiltViewModel()) {

    val dailyWeather by viewModel.forecastData.observeAsState()

    val networkError by viewModel.networkError.observeAsState()

    val backgroundImage = conditionToBackgroundImage(
        dailyWeather?.dayWeather?.condition ?: Condition.Clear
    ).drawable

    var colors: Map<String, Color> by remember {
        mutableStateOf(mapOf())
    }

    val weatherChartColors = WeatherChartColors(
        itemBackgroundColor = (colors[COLOR_KEY_Vibrant_DARK] ?: Color.DarkGray).copy(alpha = 0.3f),
    )
    LaunchedEffect(true) {
        extractColorsFromResource(context, backgroundImage) { colors = it }
    }

    if (dailyWeather != null) {
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
                dailyWeather?.apply {
                    DailyWeather(currentWeather = dayWeather)
                    WeatherChart(data = hourlyWeather, weatherChartColors)
                }
            }
        }
    } else if (networkError == true) {
        RetryConnection {
            viewModel.loadData()
        }
    } else {
        Text(
            text = "Loading...",
            Modifier.fillMaxSize(),
            fontSize = 24.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowHomeScreen() {

}