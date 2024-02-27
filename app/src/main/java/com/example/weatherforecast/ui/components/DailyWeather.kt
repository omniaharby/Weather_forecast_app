package com.example.weatherforecast.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherforecast.data.getDailyData
import com.example.weatherforecast.domain.CurrentWeather

@Composable
fun DailyWeather(currentWeather: CurrentWeather, fontColor: Color? = null) {

    val getStyle: (TextUnit, FontWeight?) -> TextStyle = { fontSize, fontWeight ->
        TextStyle(
            color = fontColor ?: Color.White,
            fontSize = fontSize,
            fontWeight = fontWeight,
            shadow = Shadow(
                color = Color.DarkGray,
                offset = Offset(4f, 4f),
                blurRadius = 70f
            )
        )
    }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = currentWeather.country,
            style = getStyle(35.sp, FontWeight.Bold)
        )
        Text(
            text = "${currentWeather.degree}°",
            style = getStyle(75.sp, FontWeight.Light)
        )
        Text(
            text = currentWeather.condition.name,
            style = getStyle(25.sp, FontWeight.Medium)
        )
        Row {
            Text(
                text = "H:${currentWeather.high}°",
                style = getStyle(25.sp, FontWeight.Bold)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "L:${currentWeather.low}°",
                style = getStyle(25.sp, FontWeight.Bold)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowDailyWeatherView() {
    DailyWeather(getDailyData())
}