package org.disney.mobile.screenObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

/**
 * Map screen.
 *
 */
public class MapScreen extends BaseScreen {

    /**
     * Constructor method.
     *
     * @param driver the driver
     */
    public MapScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*categoryTitle\")")
    private AndroidElement categoryList;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*facilityTypeTitle\")")
    private List<AndroidElement> categoryListContainer;

    @AndroidFindBy(uiAutomator = "UiSelector().resourceIdMatches(\".*facilityTypeTitle\").text(\"Hotels\")")
    private AndroidElement hotelsIncluded;

    /**
     * Checks if categoryList is displayed
     * return true if Category List element is displayed in screen, otherwise false.
     */

    public boolean categoryIsDisplayed() {
        return isElementAvailable(categoryList);
    }

    /**
     * Checks if the Category Button is displayed at the top bar, if so, taps the Category option
     *
     */
    public void tapCategoryButton(){
        if(categoryIsDisplayed()){
            click((categoryList));
        }
    }

    /**
     * Checks the Category List
     * @return The amount of items included in the list
     */
    public int checkCategoryContainerSize(){
        isElementAvailable(categoryList);
        return categoryListContainer.size();
    }

    /**
     * @return True if the Category Hotels is available, otherwise returns false
     */
    public boolean isHotelsIncluded() {
        return isElementAvailable(hotelsIncluded);
    }

}
