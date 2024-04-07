package otus.appium.factory;

import io.appium.java_client.android.options.UiAutomator2Options;

public class MobileOptions {
    public static UiAutomator2Options getOptions() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("Appium");
        options.setDeviceName("emulator-5554");
        options.setApp("C:\\Users\\Bato\\IdeaProjects\\mobile_autotest\\src\\test\\resources\\apk\\kari.apk");

        return options;
    }
}
