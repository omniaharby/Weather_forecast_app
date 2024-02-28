package com.example.weatherforecast.domain

fun conditionToIcon(condition: Condition): WeatherICon {
    return when (condition) {
        Condition.Clear -> WeatherICon.ClearNight
        Condition.Cloudy -> WeatherICon.Cloudy
        Condition.Sunny -> WeatherICon.Sunny
        Condition.PartlyCloudy -> WeatherICon.PartiallyCloudy
        Condition.PatchyRainNearby -> WeatherICon.PartiallyRaining
        Condition.Overcast -> WeatherICon.Overcast
        Condition.LightDrizzle -> WeatherICon.PartiallyRaining
        else -> WeatherICon.Cloudy
    }
}

fun conditionToBackgroundImage(condition: Condition): WeatherBackGround {
    return when (condition) {
        Condition.Clear -> WeatherBackGround.ClearDawnSky
        Condition.Cloudy -> WeatherBackGround.ColdFoggySky
        Condition.Sunny -> WeatherBackGround.WarmMorning
        Condition.PartlyCloudy -> WeatherBackGround.SkyWithCloudsMorning
        Condition.PatchyRainNearby -> WeatherBackGround.RainySky
        Condition.Overcast -> WeatherBackGround.Overcast
        Condition.LightDrizzle -> WeatherBackGround.RainySky
        else -> WeatherBackGround.ColdFoggySky
    }
}