package org.disney.mobile.config;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class MobileOperations {

    protected final AndroidDriver<AndroidElement> driver;

    public MobileOperations(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(0)), this);
    }

    public AndroidDriver<AndroidElement> getDriver() { return driver; }

    public void swipeVertical(float percentage) {
        Dimension windowSize = this.getDriver().manage().window().getSize();
        TouchAction ta = new TouchAction(this.getDriver());
        ta.press(PointOption.point(207, 582)).moveTo(PointOption.point(
                8,-360)).release().perform();
    }

    public void click(AndroidElement element, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
    public void click(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15L);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void sendKeys(AndroidElement element, String sequence) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(sequence);
    }

    public boolean isElementAvailable(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

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
