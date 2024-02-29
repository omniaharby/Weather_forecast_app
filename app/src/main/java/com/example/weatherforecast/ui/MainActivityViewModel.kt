package com.example.weatherforecast.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherforecast.domain.isNetworkAvailable

class MainActivityViewModel : ViewModel() {

    private val _isConnected = MutableLiveData<Boolean?>()
    val isConnected: LiveData<Boolean?>
        get() = _isConnected

    fun checkConnectivity(context: Context) = _isConnected.postValue(isNetworkAvailable(context))
}