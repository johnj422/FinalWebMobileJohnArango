package org.disney.mobile.config;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Driver {

    private final AndroidDriver<AndroidElement> driver;

    public Driver(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }
}
