package com.stankovic.zebrascanner

import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.stankovic.zebrascanner.config.ScanningConfig
import com.stankovic.zebrascanner.scanning.ScanBroadcastReceiver
import com.stankovic.zebrascanner.ui.screen.ScanningScreen
import com.stankovic.zebrascanner.ui.theme.ZebraScannerTheme
import com.stankovic.zebrascanner.viewmodel.ScannerViewModel
import kotlin.getValue

class MainActivity : ComponentActivity() {
    private val scannerViewModel: ScannerViewModel by viewModels()
    private lateinit var scannerReceiver: ScanBroadcastReceiver


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        scannerReceiver = ScanBroadcastReceiver(
            scannerViewModel,
        )
        registerScannerReceiver()

        setContent {
            ZebraScannerTheme {
                ScanningScreen(
                    scannerViewModel = scannerViewModel,
                )
            }
        }
    }

    private fun registerScannerReceiver() {
        val filter = IntentFilter()
        filter.addCategory(Intent.CATEGORY_DEFAULT)
        filter.addAction(ScanningConfig.APP_SCANNER_INTENT)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(scannerReceiver, filter, RECEIVER_EXPORTED)
        } else {
            @SuppressLint("UnspecifiedRegisterReceiverFlag")
            registerReceiver(scannerReceiver, filter)
        }
    }

    override fun onResume() {
        super.onResume()

        registerScannerReceiver()
    }
}
