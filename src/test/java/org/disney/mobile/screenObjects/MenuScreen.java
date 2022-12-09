package org.disney.mobile.screenObjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuScreen extends BaseScreen {
    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author John Arango
     */
    public MenuScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.RelativeLayout\").descriptionContains(\"My Profile\")")
    private AndroidElement myProfileOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.RelativeLayout\").descriptionContains(\"Property Rules\")")
    private AndroidElement propertyRulesOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.RelativeLayout\").descriptionContains(\"Link to Account\")")
    private AndroidElement linkToAccountOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.RelativeLayout\").descriptionContains(\"Help\")")
    private AndroidElement helpOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.RelativeLayout\").descriptionContains(\"Privacy & Legal\")")
    private AndroidElement privacyAndLegalOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Privacy Policy\")")
    private AndroidElement privacyPolicyOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Terms of Use\")")
    private AndroidElement termsOfUseOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Supplemental Terms\")")
    private AndroidElement supplementalTermsOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Legal Notices\")")
    private AndroidElement legalNoticesOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").text(\"Property Rules\")")
    private AndroidElement propertyRules2Option;
    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.TextView\").textContains(\"Electronic Communication\")")
    private AndroidElement electronicCommOption;

    /**
     * Swipes the screen down to the bottom
     * @author John Arango
     */
    public void swipeDown() {
        driver.findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true)).flingToEnd(10)"));
    }

    /**
     *
     * @return True if the Profile Option is available, otherwise returns false
     * @author John Arango
     */
    public boolean isMyProfileVisible() {
        return isElementAvailable(myProfileOption);
    }

    /**
     *
     * @return True if the Property Rules option is available, otherwise returns false
     * @author John Arango
     */
    public boolean isPropertyRulesVisible() {
        return isElementAvailable(propertyRulesOption);
    }

    /**
     *
     * @return True if the Link to Account Option is available, otherwise returns false
     * @author John Arango
     */
    public boolean isLinkToAccountVisible() {
        return isElementAvailable(linkToAccountOption);
    }

    /**
     *
     * @return True if the Help Option is available, otherwise returns false
     * @author John Arango
     */
    public boolean isHelpVisible() {
        return isElementAvailable(helpOption);
    }

    /**
     *
     * @return True if the Privacy & Legacy Option is available, otherwise returns false
     * @author John Arango
     */
    public boolean isPrivacyAndLegaVisible() {
        return isElementAvailable(privacyAndLegalOption);
    }

    /**
     *
     * Taps the Privacy & Legal Option
     * @author John Arango
     */
    public void tapPrivacyAndLegal() {
        isElementAvailable(privacyAndLegalOption);
        click(privacyAndLegalOption);
    }

    /**
     *
     * @return True if the Privacy & Policy Option is available, otherwise returns false
     * @author John Arango
     */
    public boolean isPrivacyPolicyVisible() {
        return isElementAvailable(privacyPolicyOption);
    }

    /**
     *
     * @return True if the Terms of Use Option is available, otherwise returns false
     * @author John Arango
     */
    public boolean isTermsOfUseVisible() {
        return isElementAvailable(termsOfUseOption);
    }

    /**
     *
     * @return True if the Supplemental Terms Option is available, otherwise returns false
     * @author John Arango
     */
    public boolean isSupplementalTermsVisible() {
        return isElementAvailable(supplementalTermsOption);
    }

    /**
     *
     * @return True if the Legal Notices Option is available, otherwise returns false
     * @author John Arango
     */
    public boolean isLegalNoticesVisible() {
        return isElementAvailable(legalNoticesOption);
    }

    /**
     *
     * @return True if the Proper Rules Option is available in this menu, otherwise returns false
     * @author John Arango
     */
    public boolean isPropertyRules2Visible() {
        return isElementAvailable(propertyRules2Option);
    }

    /**
     *
     * @return True if the Electronic Communication Disclosure Option is available, otherwise returns false
     * @author John Arango
     */
    public boolean isElectronicCommVisible() {
        return isElementAvailable(electronicCommOption);
    }
}
