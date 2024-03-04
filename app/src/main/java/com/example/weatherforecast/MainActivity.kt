package com.example.weatherforecast

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.example.weatherforecast.location.checkLocationPermission
import com.example.weatherforecast.location.getCountryFromLocation
import com.example.weatherforecast.location.getLastKnownLocation
import com.example.weatherforecast.location.requestLocationPermission
import com.example.weatherforecast.ui.HomeScreen
import com.example.weatherforecast.ui.HomeViewModel
import com.example.weatherforecast.ui.MainActivityViewModel
import com.example.weatherforecast.ui.components.ErrorView
import com.example.weatherforecast.ui.theme.WeatherForecastTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    private val childViewModel: HomeViewModel by viewModels()
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                updateWithLatestLocation()

            } else {
                handleLocationPermissionDenied()
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkConnectivity()
        updateStateOnLocationPermissionState()
        setContent {
            WeatherForecastTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoadView()
                }
            }
        }
    }

    private fun checkConnectivity() {
        viewModel.checkConnectivity(this.applicationContext)
    }

    private fun updateStateOnLocationPermissionState() {
        if (checkLocationPermission()) {
            updateWithLatestLocation()
        } else {
            handleLocationPermissionDenied()
        }
    }

    private fun handleLocationPermissionDenied() {

        if (!ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        ) {
            viewModel.updateErrorState(
                "We need location permission to access your location, go to app settings to update permissions.",
                true
            ) {
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                val uri: Uri = Uri.fromParts("package", packageName, null)
                intent.data = uri
                startActivity(intent)
            }

        } else {
            viewModel.updateErrorState("location permission not granted.", true)
            { requestLocationPermission(requestPermissionLauncher) }
        }
    }

    private fun updateWithLatestLocation() {
        getLastKnownLocation()?.also {
            childViewModel.updateLocationData(getCountryFromLocation(it))
        } ?: run {
            viewModel.updateErrorState("location not found", true) { updateWithLatestLocation() }
            Log.e("Omnia", "location not found")
        }
    }

    @Composable
    fun LoadView() {
        val errorState = viewModel.errorState.observeAsState()

        if (errorState.value?.isError == false) {

            childViewModel.loadData()
            HomeScreen(context = this.applicationContext, childViewModel)
        } else {
            // load error view
            errorState.value?.also {
                ErrorView(it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherForecastTheme {

    }
}