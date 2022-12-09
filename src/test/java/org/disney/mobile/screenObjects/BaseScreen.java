package org.disney.mobile.screenObjects;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.disney.mobile.config.MobileOperations;

public abstract class BaseScreen extends MobileOperations {


    public BaseScreen(AndroidDriver<AndroidElement> driver) { super(driver); }


}
