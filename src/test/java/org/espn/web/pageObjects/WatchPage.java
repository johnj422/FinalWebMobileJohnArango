package org.espn.web.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WatchPage extends HomePage{

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

    public int getCarrouselContainerSize() {
        return carrouselContainer.size();
    }

    public int getNoTitleCards() {
        int count = 0;
        for(WebElement carrouselCard : carrouselCards){
            if(carrouselCard.getAttribute("title") == null){
                count++;
            }
        } return count;
    }

    public void clickSecondCard() {
        clickElement(secondCard);
    }

    public boolean validateCloseButton() {
        waitForClickable(closeButton);
        return closeButton.isDisplayed();
    }

    public void waitForCloseBtn(){
        waitForClickable(closeButton);
    }

    public void clickCloseButton() {
        clickElement(closeButton);
    }

    public HomePage navigateToHomePage(){
        super.getDriver().navigate().back();
        return new HomePage(super.getDriver());
    }

    public WebElement getUserOnline() {
        return userOnline;
    }

    public String getUserName() {
        return userName.getText();
    }

}
