package com.example.weatherforecast.domain

data class CurrentWeather(
    val country: String,
    val degree: String,
    val condition: Condition,
    val high: String,
    val low: String
)

data class HourlyWeather(
    val time: String,
    val condition: Condition,
    val degree: String
)

data class DailyWeather(val dayWeather: CurrentWeather, val hourlyWeather: HourlyWeather)

enum class Condition(val value: String) {
    Cloudy("Cloudy"),
    Overcast("Overcast"),
    PartlyCloudy("Partly cloudy"),
    PatchyRainNearby("Patchy rain nearby"),
    Clear("Clear"),
    Sunny("Sunny");

    companion object {
        public fun fromValue(value: String): Condition = when (value) {
            "Cloudy" -> Cloudy
            "Overcast" -> Overcast
            "Partly cloudy" -> PartlyCloudy
            "Patchy rain nearby" -> PatchyRainNearby
            "Clear" -> Clear
            "Sunny" -> Sunny
            else -> throw IllegalArgumentException()
        }
    }
}
