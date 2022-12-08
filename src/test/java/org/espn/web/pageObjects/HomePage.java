package org.espn.web.pageObjects;

import org.espn.web.helpers.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {


    //Promo Banner Locators
    @FindBy(css = ".promo-banner-container > iframe")
    private WebElement promoBannerIFrame;

    @FindBy(css = "#fittPageContainer .PromoBanner__CloseBtn")
    private WebElement bannerCloseButton;

    //Login Locators
    @FindBy(css = "article[id='sideLogin-left-rail'] button[class='button-alt med']")
    private WebElement userLogin;

    @FindBy(className = "input-InputLoginValue")
    private WebElement emailInput;

    @FindBy(className = "input-InputPassword")
    private WebElement passwordInput;

    @FindBy(id = "oneid-iframe")
    private WebElement userFrame;

    @FindBy(css = "#Title")
    private WebElement frameTitle;

    @FindBy(id ="logo")
    private WebElement espnLogo;

    @FindBy(id = "BtnSubmit")
    private WebElement btnSubmit;

    @FindBy(id = "BtnCreateAccount")
    private WebElement btnCreateAccount;

    //Logout Locators

    @FindBy(css = "li[class='user hover'] div[class='global-user'] div[class='global-user-container'] ul[class='account-management'] li a[class='small']")
    private WebElement logOutButton;

    @FindBy(css = "div[class='container'] li:nth-child(5) a:nth-child(1)")
    private WebElement profileLink;

    @FindBy(css = ".user")
    private WebElement userIcon;

    @FindBy(css = ".display-user")
    private WebElement userOffline;

    @FindBy(id = "AccountDeleteLink")
    private WebElement accountDeleteLink;

    @FindBy(id = "BtnCancel")
    private WebElement cancelBtn;
    @FindBy(css = "#TextError")
    private WebElement errorMsg;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage(){
        navigateTo(Constants.URL);
    }
    public void closeBanner() {
        if (promoBannerIFrame == null) {
            super.getDriver().switchTo().defaultContent();
        }

        super.getDriver().switchTo().frame(promoBannerIFrame);
        clickElement(bannerCloseButton);
    }

    public void userLogin(){
        clickElement(userLogin);
    }

    public WebElement getUserFrame() {
        return userFrame;
    }

    public void changingIframe(WebElement iFrame){
        super.getDriver().switchTo().frame(iFrame);
    }

    public boolean isEspnLogoDisplayed() {
        return espnLogo.isDisplayed();
    }

    public void waitForLogo(){
        waitForVisibility(espnLogo);
    }

    public boolean isBtnSubmitDisplayed() {
        return btnSubmit.isDisplayed();
    }

    public boolean isBtnSignUpDisplayed() {
        return btnCreateAccount.isDisplayed();
    }

    public void sendUserEmail(String email){
        emailInput.sendKeys(email);
    }

    public void sendUserPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void logIn(){
        clickElement(btnSubmit);
    }

    public void clickLogOutButton() {
        clickElement(logOutButton);
    }

    public WebElement getUserIcon() {
        return userIcon;
    }

    public String validateNoUserName(){
        return userOffline.getText();
    }

    public void clickProfileLink() {
        clickElement(profileLink);
    }
    public void refreshNavigation() {
        super.getDriver().navigate().refresh();
    }

    public void deleteAccountLink() {
        clickElement(accountDeleteLink);
    }

    public void clickSubmitBtn(){
        clickElement(btnSubmit);
    }

    public String getIframeTitle(){
        waitForVisibility(frameTitle);
        return frameTitle.getText();
    }

    public void waitForCancelBtn(){
        waitForClickable(cancelBtn);
    }

    public void waitForErrorMsg(){
        waitForClickable(errorMsg);
    }

    public void validateReLogin(String email, String password){
        userLogin();
        changingIframe(userFrame);
        sendUserEmail(email);
        sendUserPassword(password);
        clickElement(btnSubmit);

    }
}
