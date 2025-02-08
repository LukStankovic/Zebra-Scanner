package com.stankovic.zebrascanner.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.stankovic.zebrascanner.ui.theme.ZebraScannerTheme
import com.stankovic.zebrascanner.viewmodel.ScannerViewModel

@Composable
fun ScanningScreen(
    scannerViewModel: ScannerViewModel = hiltViewModel(),
) {
    val scannedData by scannerViewModel.scannedData.collectAsState()

    ScanningScreenContent(
        scannedData = scannedData,
    )
}

@Composable
fun ScanningScreenContent(
    scannedData: String?,
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
        ) {
            Text(
                text = scannedData ?: "Waiting for scan...",
            )
        }
    }
}

@Preview
@Composable
fun ScanningScreenPreview() {
    ZebraScannerTheme {
        ScanningScreenContent(
            scannedData = "1234567890",
        )
    }
}