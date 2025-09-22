# Zebra DataWedge Scanner Demo (Kotlin + Jetpack Compose)

A simple and modern Android barcode scanner app for **Zebra devices** (like TC21, TC22) using **Kotlin**, **Jetpack Compose**, and the **DataWedge Intent API**. It listens for broadcast intents and displays scanned barcode data in real time.

> [!NOTE]
> This is a **demo application** intended for learning and demonstration purposes only.

## Features

- Uses Zebra’s **DataWedge** to handle scanning — **no low-level SDK integration needed**.
- Scanned barcodes are broadcasted and captured via a **BroadcastReceiver**.
- Data is stored in a **ViewModel** and rendered instantly in the UI with **Jetpack Compose**.
- Lightweight and easy to integrate.

## Project Structure

| File                       | Purpose                                                                  |
|----------------------------|--------------------------------------------------------------------------|
| `ScanningConfig.kt`        | Defines the intent action and keys for extras.                           |
| `ScannerViewModel.kt`      | Holds the scanned barcode data and exposes it to the UI using StateFlow. |
| `ScanBroadcastReceiver.kt` | Listens for broadcast intents from DataWedge and updates the ViewModel.  |
| `AndroidManifest.xml`      | Registers the BroadcastReceiver for the scan action.                     |

## How It Works

1. **Broadcast Intent Listening**
   The app listens for the intent action:
   ```
   com.stankovic.zebrascanner.scan
   ```
   This is configured in `ScanningConfig.kt`.

2. **Data Extraction**
   When a barcode is scanned, DataWedge sends the data as an intent extra:
   ```
   com.symbol.datawedge.data_string
   ```

3. **ViewModel and UI Update**
   The `ScanBroadcastReceiver` extracts the barcode, updates the `ScannerViewModel`, which then updates the Compose UI in real time.


## How to Enable Intent Broadcast on Zebra Devices (DataWedge)

> [!IMPORTANT]
> You have to create a profile **after** installing this app on the Zebra device!

1. Open DataWedge app on the device.
2. Click on three dots in top right corner
3. Click on `New Profile`
4. Enter any name of your profile
5. Click on the profile you just created
6. Ensure that the profile is enabled (should be by default)
7. Associate that profile with the sample application
    - Click on `Associated apps`
    - Click on three dots in top right corner and click on `New app/activity`
    - Scroll in the menu, find `com.stankovic.zebrascanner` and click on it.
    - In the `Select activity` menu choose `*`
    - Go back to the profile screen
8. Ensure that `Barcode input` is enabled
9. Ensure that `Keystroke output` is enabled
10. Scroll down to `Intent output` section
11. Click on checkbox to enable it
12. Click on `Intent action` and enter `com.stankovic.zebrascanner.scan` action and click OK.
    - _Intent action must be same as set in `ScanningConfig.kt` in `APP_SCANNER_INTENT` constant._
13. Click on `Intent delivery` and choose `Broadcast intent`

## How to Test Scanning in an Emulator

You can simulate a scan using ADB:

`adb shell am broadcast -a com.stankovic.zebrascanner.scan -e com.symbol.datawedge.data_string "123456789" -e com.symbol.datawedge.source scanner -e com.symbol.datawedge.label_type EAN13`

This command mimics a scan so you can test without a physical Zebra device.

## Learn More

For a detailed step-by-step explanation and implementation guide, check out the full Medium article.

[Implementing Zebra Scanner in Kotlin with Jetpack Compose & DataWedge API](https://medium.com/@lukasstankovic/implementing-zebra-scanner-in-kotlin-with-jetpack-compose-datawedge-api-e98507e21ac1)
