package org.disney.mobile.config;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class MobileOperations {

    protected final AndroidDriver<AndroidElement> driver;

    /**
     * Constructor method for Mobile Operations
     * @param driver
     */
    public MobileOperations(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(0)), this);
    }

    /**
     * Driver getter
     * @return driver
     */
    public AndroidDriver<AndroidElement> getDriver() { return driver; }

    public void swipeVertical(float percentage) {
        Dimension windowSize = this.getDriver().manage().window().getSize();
        TouchAction ta = new TouchAction(this.getDriver());
        ta.press(PointOption.point(207, 582)).moveTo(PointOption.point(
                8,-360)).release().perform();
    }

    /**
     * Waits for de element and clicks on it
     * @param element
     */
    public void click(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15L);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    /**
     * Waits for the element and sends a string to it
     * @param element
     * @param sequence
     */
    public void sendKeys(AndroidElement element, String sequence) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(sequence);
    }

    /**
     * Validates the visibility Of the element
     * @param element
     * @return boolean
     */
    public boolean isElementAvailable(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    /**
     * Validates the visibility Of the element but receives a wait time
     * @param element
     * @param timeout
     * @return boolean
     */
    public boolean isElementAvailable(AndroidElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver,15);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

}
