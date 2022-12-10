package org.espn.web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WatchPage extends HomePage{

    /**
     * WatchPage constructor
     * @param driver: WebDriver
     */
    public WatchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "watch")
    private WebElement watchLink;


    @FindBy(css = ".BucketsContainer > div")
    private List<WebElement> carrouselContainer;

    @FindBy(css = ".BucketsContainer > div:nth-child(1) > section > div:nth-child(2) > div > div > ul > li")
    private List<WebElement> carrouselCards;

    @FindBy(css = ".BucketsContainer > div:nth-child(1) > section > div:nth-child(2) > div > div > ul > li:nth-child(2)")
    private WebElement secondCard;

    @FindBy(css = "button.lightbox__closebtn")
    private WebElement closeButton;

    @FindBy(css = ".user")
    private WebElement userOnline;

    @FindBy(css = ".display-user > span")
    private WebElement userName;

    /**
     * Validates carrousel's number of elements
     * @return Integer number of elements
     */
    public int getCarrouselContainerSize() {
        return carrouselContainer.size();
    }

    /**
     * Valedates the number of cards without Title or Description
     * @return Integer number of cards without Title or Description
     */
    public int getNoTitleCards() {
        int count = 0;
        for(WebElement carrouselCard : carrouselCards){
            if(carrouselCard.getAttribute("title") == null){
                count++;
            }
        } return count;
    }

    /**
     * Clicks the second card of the carrousel
     */
    public void clickSecondCard() {
        clickElement(secondCard);
    }

    /**
     * Validates if there is a close button
     * @return True if there is a close button
     */
    public boolean validateCloseButton() {
        waitForClickable(closeButton);
        return closeButton.isDisplayed();
    }

    /**
     * Waits for close button to be clickable
     */
    public void waitForCloseBtn(){
        waitForClickable(closeButton);
    }

    /**
     * Clicks the close button of the carrouselCard
     */
    public void clickCloseButton() {
        clickElement(closeButton);
    }

    /**
     * Navigates to HomePage
     * @return HomePage
     */
    public HomePage navigateToHomePage(){
        super.getDriver().navigate().back();
        return new HomePage(super.getDriver());
    }

    /**
     * User online getter
     * @return
     */
    public WebElement getUserOnline() {
        return userOnline;
    }

    /**
     * Extracts user name from the element
     * @return String: user name
     */
    public String getUserName() {
        return userName.getText();
    }

}
