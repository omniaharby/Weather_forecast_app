package com.example.weatherforecast.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherforecast.data.getWeatherChartColor
import com.example.weatherforecast.domain.Condition
import com.example.weatherforecast.domain.HourlyWeather
import com.example.weatherforecast.domain.WeatherChartColors
import com.example.weatherforecast.domain.WeatherICon
import com.example.weatherforecast.domain.conditionIconMapper

@Composable
fun WeatherItem(weather: HourlyWeather, colors: WeatherChartColors) {

    Box(
        modifier = Modifier
            .padding(8.dp)
            .shadow(4.dp, shape = RoundedCornerShape(40.dp))
    ) {
        Column(
            modifier = Modifier
                .border(3.dp, colors.itemStrokeColor, RoundedCornerShape(40.dp))
                .background(
                    color = colors.itemBackgroundColor,
                    shape = RoundedCornerShape(40.dp),
                )
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = weather.time,
                style = TextStyle(
                    color = colors.textColor,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
            Spacer(modifier = Modifier.height(26.dp))
            Image(
                painter = painterResource(id = conditionIconMapper(weather.condition).drawable),
                contentDescription = "Icon Image",
                Modifier.size(45.dp)
            )
            Spacer(modifier = Modifier.height(26.dp))
            Text(
                text = "${weather.degree}°", style = TextStyle(
                    color = colors.textColor,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowWeatherItemView() {
    WeatherItem(HourlyWeather("12 PM",Condition.Clear, "10"), getWeatherChartColor())
}