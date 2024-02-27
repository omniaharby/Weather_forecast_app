package com.example.weatherforecast.data

import com.example.weatherforecast.domain.Condition
import com.example.weatherforecast.domain.CurrentWeather
import com.example.weatherforecast.domain.DailyWeather
import com.example.weatherforecast.domain.HourlyWeather

fun dataMapper(response: WeatherAPIResponse): DailyWeather {

    return DailyWeather(
        CurrentWeather(
            country = response.location.country,
            degree = "${response.current.tempC.toInt()}",
            condition = Condition.fromValue(response.current.condition.text.trimEnd()),
            high = "${response.forecast.forecastday[0].day.maxtempC.toInt()}",
            low = "${response.forecast.forecastday[0].day.maxtempC}"
        ),
        hourlyWeather = HourlyWeather(
            time = response.forecast.forecastday[0].hour[0].time,
            condition = Condition.fromValue(response.forecast.forecastday[0].hour[0].condition.text),
            degree = "${response.forecast.forecastday[0].hour[0].tempC.toInt()}"
        )
    )
}