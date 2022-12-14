package org.disney.mobile.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.tinylog.Logger;

/**
 * DashBoard screen
 */
public class DashBoardScreen extends BaseScreen {

    /**
     * Constructor method.
     *
     * @param driver : AndroidDriver
     */
    public DashBoardScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*android:id/button2\")")
    private AndroidElement dismissPreferenceUpdateButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"dismiss-icon\")")
    private AndroidElement dismissWelcome;


    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").descriptionContains(\"Map\")")
    private AndroidElement mapButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"com.disney.wdpro.dlr:id/tab_icon\").descriptionContains(\"More\")")
    private AndroidElement menuButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\"com.disney.wdpro.dlr:id/tab_animated_icon\")")
    private AndroidElement addPlansButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.FrameLayout\").descriptionContains" +
            "(\"Check Dining Availability\")")
    private AndroidElement reserveOption;

    /**
     * First taps to close default initial screens
     *
     */
    public void tapingInitialButtons() {
        Logger.info("Taping dismissWelcome");
        if (this.isElementAvailable(dismissWelcome, 25)){
            click(dismissWelcome);
        }
        Logger.info("Taping dismissPreferenceUpdate");
        if (this.isElementAvailable(dismissPreferenceUpdateButton, 25)){
            click(dismissPreferenceUpdateButton);
        }
    }

    /**
     * Navigate to Map Screen from DashBoard Screen.
     * @return New Map Screen
     *
     */
    public MapScreen goToMapScreen() {

        tapingInitialButtons();

        Logger.info("Taping Map Button");

        if (this.isElementAvailable(mapButton)){
            click(mapButton);
        }
        return new MapScreen(getDriver());
    }

    /**
     * @return True if the map button is displayed in the bottom bar otherwise returns false
     *
     */
    public boolean mapButtonIsDisplayed() {
        return isElementAvailable(mapButton);
    }

    /**
     * Checks if the Menu button is displayed in the bottom bar
     * @return New Menu Screen
     *
     */
    public MenuScreen goToMenuScreen(){

        tapingInitialButtons();

        Logger.info("Taping menuButton");

        if (this.isElementAvailable(menuButton)){
            click(menuButton);
        }
        return new MenuScreen(getDriver());
    }

    /**
     * Checks if the Add Plans option is available on the bottom bar if so, taps the option.
     */
    public void goToAddPlans(){
        tapingInitialButtons();

        isElementAvailable(addPlansButton);

        click(addPlansButton);
    }

    /**
     * @return True if the reserve option is available in the add plans option on the bottom bar otherwise returns false
     */
    public boolean isReserveOptionVisible(){
        return isElementAvailable(reserveOption);
    }
}
