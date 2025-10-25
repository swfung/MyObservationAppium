## Local environment setup:
1. Download and install Java
2. Download and install Android Studio
3. Download and install Node
4. Set Java, Android SDK and Node Home Paths in system variables
5. Open Android Studio and configure a physical device (Emulator also fine, but make sure the setting is correct)
6. Insall Appium server via Node
7. Check out this project and open in IDE

## Running test:
1. Connect your physical device to PC or create a new virtual device in Android studio
2. Edit `appiumLibPath`, `appPath` and `deviceName` in `src/test/java/myObservatoryUiAutomation/Appium/AppiumMain.java` base on your local configuration
3. Ensure your android device is in developer mode (Settings > About phone, tap the Build number seven times)
4. Enable USB debugging in Developer options
5. Run `src/test/java/myObservatoryUiAutomation/Appium/AppiumMain.java` as TestNG Test
