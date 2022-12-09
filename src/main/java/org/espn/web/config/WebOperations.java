package org.espn.web.config;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public abstract class WebOperations {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions action;

    public WebOperations(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15L));
        this.action = new Actions(driver);
        initElements(driver, this);
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void clickElement(WebElement element) {
        waitForClickable(element);
        element.click();
    }
    public void waitForClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void performMouseHover(WebElement element){
        waitForVisibility(element);
        action.moveToElement(element).perform();
    }
}
