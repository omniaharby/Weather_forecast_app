package com.example.weatherforecast.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherforecast.data.Repository
import com.example.weatherforecast.data.datasource.Response
import com.example.weatherforecast.domain.DailyWeather
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: Repository,
) : ViewModel() {

    private val _forecastData = MutableLiveData<DailyWeather?>()
    val forecastData: LiveData<DailyWeather?>
        get() = _forecastData
    private val _isNetworkError = MutableLiveData(false)
    val networkError: LiveData<Boolean>
        get() = _isNetworkError

    private lateinit var _location: String

    fun updateLocationData(location: String) {
        _location = location
    }


    fun loadData() {
        _isNetworkError.postValue(false)
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = getForecast(_location)) {
                is Response.Success -> {
                    _forecastData.postValue(result.data)
                }

                is Response.Failure -> {
                    _isNetworkError.postValue(true)
                    Log.e("OMNIA", result.message)
                }
            }
        }
    }

    private suspend fun getForecast(location: String): Response<DailyWeather> {

        return repo.getForecastData(location)
    }
}