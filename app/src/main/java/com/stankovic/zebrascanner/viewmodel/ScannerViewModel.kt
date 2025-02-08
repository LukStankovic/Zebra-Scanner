package com.stankovic.zebrascanner.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ScannerViewModel @Inject constructor() : ViewModel() {
    private val _scannedData = MutableStateFlow<String?>(null)
    val scannedData = _scannedData.asStateFlow()

    fun updateScannedData(data: String) {
        _scannedData.value = data
    }

    fun clearScannedData() {
        _scannedData.value = null
    }
}
