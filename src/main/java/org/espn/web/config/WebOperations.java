package org.espn.web.config;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public class WebOperations {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions action;


    /**
     * Constructor method for Web Operations
     * @param driver
     */
    public WebOperations(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15L);
        this.action = new Actions(driver);
        initElements(driver, this);
    }

    /**
     * Driver getter
     * @return driver
     */
    public WebDriver getDriver(){
        return driver;
    }

    /**
     * Waits for de element and clicks on it
     * @param element
     */
    public void clickElement(WebElement element) {
        waitForClickable(element);
        element.click();
    }

    /**
     * Waits for an element until is clickable
     * @param element
     */
    public void waitForClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits for an element until is visible
     * @param element
     */
    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Moves the mouse to the specified element
     * @param element
     */
    public void performMouseHover(WebElement element){
        waitForVisibility(element);
        action.moveToElement(element).perform();
    }
}
