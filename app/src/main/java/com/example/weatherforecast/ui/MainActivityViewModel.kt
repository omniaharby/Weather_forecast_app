package com.example.weatherforecast.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherforecast.domain.isNetworkAvailable

class MainActivityViewModel : ViewModel() {

    private val _errorState = MutableLiveData<ErrorState>()
    val errorState: LiveData<ErrorState>
        get() = _errorState

    fun updateErrorState(message: String, isError: Boolean, action: (() -> Unit)? = null) =
        _errorState.postValue(ErrorState(message, isError, action))

    fun checkConnectivity(context: Context, retryAction: (() -> Unit)? = null) {
        if (isNetworkAvailable(context)) {
            updateErrorState("", false, retryAction)
        } else {
            updateErrorState("Please check your connection and retry", true)
        }
    }
}

data class ErrorState(
    val message: String,
    val isError: Boolean,
    val tryAgainAction: (() -> Unit)? = null
)