package org.espn.web.pageObjects;

import org.espn.web.config.WebOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends WebOperations {

    /**
     * SignUp Locators
     */

    @FindBy(id = "BtnCreateAccount")
    private WebElement signUpButton;
    @FindBy(css = "[role='text']")
    private WebElement signUpTitle;
    @FindBy(id = "InputFirstName")
    private WebElement firstNameInput;
    @FindBy(id = "InputLastName")
    private WebElement lastNameInput;
    @FindBy(id = "InputEmail")
    private WebElement emailSignUpInput;
    @FindBy(id = "password-new")
    private WebElement passwordSignUpInput;
    @FindBy(id = "close")
    private WebElement closeBtn;


    /**
     * Login Locators
     */
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

    /**
     * Logout Locators
     */

    @FindBy(css = "li[class='user hover'] div[class='global-user'] div[class='global-user-container'] ul[class='account-management'] li a[class='small']")
    private WebElement logOutButton;

    @FindBy(css = "div[class='container'] li:nth-child(5) a:nth-child(1)")
    private WebElement profileLink;

    @FindBy(css = ".user")
    private WebElement userIcon;

    @FindBy(id = "global-user-trigger")
    private WebElement notLoggedUserIcon;

    @FindBy(css = ".display-user")
    private WebElement userPanel;



    @FindBy(id = "AccountDeleteLink")
    private WebElement accountDeleteLink;

    @FindBy(id = "BtnCancel")
    private WebElement cancelBtn;
    @FindBy(css = "#TextError")
    private WebElement errorMsg;

    @FindBy(className = "watch")
    private WebElement watchLink;

    /**
     * HomePage constructor
     * @param driver: WebDriver
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicks SignUpButton
     */
    public void clickSignUpButton(){
        clickElement(signUpButton);
    }

    /**
     * Clicks UserLogin
     */
    public void userLogin(){
        clickElement(userLogin);
    }

    /**
     * Gets UserFrame
     */
    public WebElement getUserFrame() {
        return userFrame;
    }

    /**
     * Chages iFrame
     * @param iFrame
     */
    public void changingIframe(WebElement iFrame){
        super.getDriver().switchTo().frame(iFrame);
    }

    /**
     * Changes to default iFrame
     * @param iFrame
     */
    public void changingToDefaultIframe(WebElement iFrame){
        super.getDriver().switchTo().defaultContent();
    }

    /**
     * Validates if ESP Logo is displayed
     * @return True if ESP Logo is displayed
     */
    public boolean isEspnLogoDisplayed() {
        return espnLogo.isDisplayed();
    }

    /**
     * Waits for the ESPN logo to appear
     */
    public void waitForLogo(){
        waitForVisibility(espnLogo);
    }

    /**
     * Validates if submit button is displayed
     * @return True if submit button is displayed
     */
    public boolean validateIfBtnSubmitDisplayed() {
        return btnSubmit.isDisplayed();
    }

    /**
     * Validates if signup button is displayed
     * @return True if signup button is displayed
     */
    public boolean isBtnSignUpDisplayed() {
        return btnCreateAccount.isDisplayed();
    }

    /**
     * Sends user's email to the input field
     * @param email
     */
    public void sendUserEmail(String email){
        emailInput.sendKeys(email);
    }

    /**
     * Sends user's password to the input field
     * @param password
     */
    public void sendUserPassword(String password){
        passwordInput.sendKeys(password);
    }

    /**
     * Clicks submit button
     */
    public void logIn(){
        clickElement(btnSubmit);
    }

    /**
     * Clicks signup button
     */
    public void clickSignUp(){
        clickElement(btnSubmit);
    }

    /**
     * Clicks logout button
     */
    public void clickLogOutButton() {
        clickElement(logOutButton);
    }

    /**
     * Waits for user's icon to be visible
     * @return WebElement: userIcon
     */
    public WebElement getUserIcon() {
        waitForVisibility(userIcon);
        return userIcon;
    }

    /**
     * Waits for user's logged out icon to be visible
     * @return WebElement: notLoggedUserIcon
     */
    public WebElement getNotLoggedUserIcon() { return notLoggedUserIcon; }

    /**
     * Extracts the user's name from the WebElement
     * @return String: userName
     */
    public String validateUserName(){
        return userPanel.getText();
    }

    /**
     * Clicks profileLink
     */
    public void clickProfileLink() {
        clickElement(profileLink);
    }

    /**
     * Refreshes the page
     */
    public void refreshNavigation() {
        super.getDriver().navigate().refresh();
    }

    /**
     * Clicks delete account link
     */
    public void deleteAccountLink() {
        clickElement(accountDeleteLink);
    }

    /**
     * Clicks submit button
     */
    public void clickSubmitBtn(){
        clickElement(btnSubmit);
    }

    /**
     * Gets iFrame title
     * @return String: title
     */
    public String getIframeTitle(){
        waitForVisibility(frameTitle);
        return frameTitle.getText();
    }

    /**
     * Validates if title is Displayed
     * @return True if title is Displayed
     */
    public boolean validateIfTitleIsDisplayed(){
        return frameTitle.isDisplayed();
    }

    /**
     * Validates if First name input is displayed
     * @return True if First name input is displayed
     */
    public boolean validateIfFirstNameInputIsDisplayed(){
        return firstNameInput.isDisplayed();
    }

    /**
     * Validates if Last name input is displayed
     * @return True if Last name input is displayed
     */
    public boolean validateIfLastNameInputIsDisplayed(){
        return lastNameInput.isDisplayed();
    }

    /**
     * Validates if Email input is displayed
     * @return True if Email input is
     */
    public boolean validateIfEmailSignUpInputIsDisplayed(){
        return emailSignUpInput.isDisplayed();
    }

    /**
     * Validates if password input is displayed
     * @return True if password input is displayed
     */
    public boolean validateIfPasswordSignUpInputIsDisplayed(){
        return passwordSignUpInput.isDisplayed();
    }

    /**
     * Validates if close button is displayed
     * @return True if close button is displayed
     */
    public boolean validateIfCloseButtonIsDisplayed(){
        return closeBtn.isDisplayed();
    }

    /**
     * Sends user's first name
     * @param firstName
     */
    public void sendNewUserFirstName(String firstName){
        waitForVisibility(firstNameInput);
        clickElement(firstNameInput);
        firstNameInput.sendKeys(firstName);
    }

    /**
     * Sends user's last name
     * @param lastname
     */
    public void sendNewUserLastName(String lastname){
        waitForVisibility(lastNameInput);
        lastNameInput.sendKeys(lastname);
    }

    /**
     * Sends user's email
     * @param email
     */
    public void sendNewUserEmail(String email){
        waitForVisibility(emailSignUpInput);
        emailSignUpInput.sendKeys(email);
    }

    /**
     * Sends user's password
     * @param password
     */
    public void sendNewUserPassword(String password){
        waitForVisibility(passwordSignUpInput);
        passwordSignUpInput.sendKeys(password);
    }

    /**
     * Creates a new user account
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     */
    public void singUp(String firstName, String lastName, String email, String password){
        sendNewUserFirstName(firstName);
        sendNewUserLastName(lastName);
        sendNewUserEmail(email);
        sendNewUserPassword(password);
        clickElement(btnSubmit);
    }

    /**
     * Logs it to users account
     * @param email
     * @param password
     */
    public void loginToAccount(String email, String password){
        userLogin();
        changingIframe(userFrame);
        sendUserEmail(email);
        sendUserPassword(password);
        clickElement(btnSubmit);

    }

    /**
     * Navigates to WatchPage
     * @return WatchPage
     */
    public WatchPage navigateToWatch(){
        clickElement(watchLink);
        return new WatchPage(super.getDriver());
    }

    /**
     * Refreshes page
     */
    public void pageRefresh(){
        super.getDriver().navigate().refresh();
    }
}
