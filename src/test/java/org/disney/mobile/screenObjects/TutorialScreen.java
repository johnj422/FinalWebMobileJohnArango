package org.disney.mobile.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.tinylog.Logger;


/**
 * Object of the first screen that appears when we open the application.
 *
 */
public class TutorialScreen extends BaseScreen {

    /**
     * Constructor method.
     *
     * @param driver: AndroidDriver
     */
    public TutorialScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }


    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*permission_primary_btn\")")
    private AndroidElement getStartedButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*permission_primary_btn\")")
    private AndroidElement shareLocationButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*android:id/button1\")")
    private AndroidElement allowLocationButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*permission_allow_foreground_only_button\")")
    private AndroidElement allowButton;

    /**
     * Start permissions process.
     */
    public void startPermissionsProcess() {
        super.click(getStartedButton);
    }

    /**
     * Share Location permissions process.
     */
    public DashBoardScreen shareLocationPermissions() {
        Logger.info("Taping shareLocationButton");
        super.click(shareLocationButton);
        Logger.info("Taping allowLocationButton");
        super.click(allowLocationButton);
        Logger.info("Taping allowButton");
        super.click(allowButton);
        return new DashBoardScreen(getDriver());
    }
}
