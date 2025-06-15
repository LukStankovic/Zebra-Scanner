# Zebra Scanner

This is a simple barcode scanner app that uses the intent to scan barcodes.

## Implementation

- The app listens for the broadcast intent `com.stankovic.zebrascanner.scan` and extracts the
  barcode data from the intent extras.
- Scanned data are saved to the view model and displayed in the UI.

### Files

- `ScanningConfig.kt` - contains the intent action and extras keys
- `ScannerViewModel.kt` - contains the view model that holds the scanned data
- `ScanBroadcastReceiver.kt` - contains the broadcast receiver that listens for the scan intent
- `AndroidManifest.xml` - contains the broadcast receiver declaration

## How to enable intent broadcast on Zebra devices via DataWedge

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

## How to test scanning in the emulator

`adb shell am broadcast -a com.stankovic.zebrascanner.scan -e com.symbol.datawedge.data_string "123456789" -e com.symbol.datawedge.source scanner -e com.symbol.datawedge.label_type EAN13`
