package org.disney.mobile.screenObjects;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


/**
 * Base class for all screens Objects.
 *
 * @author Arley.Bolivar
 */
public abstract class BaseScreen {

    /**
     * The driver.
     */
    protected final AndroidDriver<AndroidElement> driver;


    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Arley.Bolivar, Hans.Marquez
     */
    public BaseScreen(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(
                driver, Duration.ofSeconds(0)), this);
    }

    /**
     * Swipe vertical.
     *
     * @param percentage of swipe
     */
    @SuppressWarnings({"rawtypes", "unused"})
    public void swipeVertical(float percentage) {
        Dimension windowSize = driver.manage().window().getSize();
        TouchAction ta = new TouchAction(driver);
        ta.press(PointOption.point(207, 582)).moveTo(PointOption.point(
                8,-360)).release().perform();
    }


    /**
     * Wrapper for click  event specifying custom wait.
     *
     * @param element : AndroidElement
     * @author Hans.Marquez
     */
    public void click(AndroidElement element, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }


    /**
     * Wrapper for click event.
     *
     * @param element : AndroidElement
     * @author Hans.Marquez
     */
    public void click(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15L));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }


    /**
     * Wrapper for sendKeys event.
     *
     * @param element   : AndroidElement
     * @param sequence: String
     * @author Hans.Marquez
     */
    public void sendKeys(AndroidElement element, String sequence) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15L));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(sequence);
    }

    /**
     * Wrapper for Visibility event.
     *
     * @param element : AndroidElement
     * @author Hans.Marquez
     */
    public boolean isElementAvailable(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3L));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    /**
     * Wrapper for Visibility event.
     *
     * @param element : AndroidElement
     * @param timeout : int
     * @author Hans.Marquez
     */
    public boolean isElementAvailable(AndroidElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

}
