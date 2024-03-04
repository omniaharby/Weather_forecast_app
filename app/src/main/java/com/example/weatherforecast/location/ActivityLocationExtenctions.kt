package com.example.weatherforecast.location

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import java.util.Locale

fun Activity.checkLocationPermission(): Boolean {
    return ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED
}

fun requestLocationPermission(launcher: ActivityResultLauncher<String>) {
    launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
}

@SuppressLint("MissingPermission")
fun Activity.getLastKnownLocation(): Location? {
    val locationManager = getSystemService(this, LocationManager::class.java)
    return locationManager?.getLastKnownLocation(LocationManager.GPS_PROVIDER)
}

fun Activity.getCountryFromLocation(location: Location): String {
    val geocoder = Geocoder(this, Locale.getDefault())
    val addresses = geocoder.getFromLocation(location.latitude, location.longitude, 1)
    return if (!addresses.isNullOrEmpty()) {
        addresses[0].countryName
    } else {
        "Country not found"
    }
}