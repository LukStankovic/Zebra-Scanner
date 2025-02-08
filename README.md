# Zebra Scanner

This is a simple barcode scanner app that uses the intent to scan barcodes.

## Implementation

- The app listens for the broadcast intent `com.stankovic.zebrascanner.scan` and extracts the
  barcode data from the intent extras.
- Scanned data are saved to the view model and displayed in the UI.

## How to enable intent broadcast on Zebra devices

- Install/Open DataWedge app on the device.
- Click on three dots in top right corner
- Click on New Profile
- Enter name of profile: `YourProfileName`
- Click on profile `YourProfileName`
- Profile should be enabled
- Click on associated apps
- Click on three dots in top right corner and click on New app/activity
- Scroll in the menu, find `com.stankovic.zebrascanner` and click on it.
- Scroll down to Keystroke section
- Click on Disabled and enable it
- Choose * from activity Select activity menu
- Go back
- Scroll down to Intent output section
- Click on Enabled and enable it
- Click on Intent action and enter `com.stankovic.zebrascanner.scan` action and click OK. (
  `APP_SCANNER_INTENT` in ScanningConfig)
- Clcik on Intent delivery and choose Broadcast intent

## How to test scanning in the emulator
`adb shell am broadcast -a com.stankovic.zebrascanner.scan -e com.symbol.datawedge.data_string "123456789" -e com.symbol.datawedge.source scanner -e com.symbol.datawedge.label_type EAN13`
