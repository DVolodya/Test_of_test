package reportportal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import reportportal.config.TestConfig;
import io.qameta.allure.Step;

public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class,'notificationItem')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[contains(@class,'loginForm')]")
    private WebElement loginForm;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Open login page")
    public void open() {
        driver.get(TestConfig.getBaseUrl() + "/ui/#login");
    }

    @Step("Enter username: {username}")
    public void enterUsername(String username) {
        TestConfig.getWait().until(ExpectedConditions.visibilityOf(usernameInput));
        usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    @Step("Enter password: {password}")
    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    @Step("Click login button")
    public void clickLogin() {
        loginButton.click();
    }

    @Step("Check if error message is displayed")
    public boolean isErrorMessageDisplayed() {
        try {
            TestConfig.getWait().until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Check if login form is displayed")
    public boolean isLoginFormDisplayed() {
        try {
            return loginForm.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Perform login with username: {username} and password: {password}")
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    @Step("Get current URL")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}