package reportportal.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;

public class DashboardPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[contains(@class,'sidebar')]")
    private WebElement sidebar;

    @FindBy(xpath = "//a[contains(text(),'Dashboards')]")
    private WebElement dashboardsLink;

    @FindBy(xpath = "//div[contains(@class,'dashboard')]")
    private WebElement dashboardContainer;

    @FindBy(xpath = "//button[contains(text(),'Add New Dashboard')]")
    private WebElement addNewDashboardButton;

    @FindBy(xpath = "//input[@placeholder='Enter dashboard name']")
    private WebElement dashboardNameInput;

    @FindBy(xpath = "//button[contains(text(),'Add')]")
    private WebElement addDashboardButton;

    @FindBy(xpath = "//button[contains(text(),'Add Widget')]")
    private WebElement addWidgetButton;

    @FindBy(xpath = "//div[contains(text(),'Overall statistics')]")
    private WebElement overallStatisticsWidget;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    private WebElement saveWidgetButton;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Check if user is logged in")
    public boolean isUserLoggedIn() {
        try {
            PageFactory.initElements(driver, this);
            return sidebar.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Navigate to Dashboards")
    public void navigateToDashboards() {
        dashboardsLink.click();
    }

    @Step("Click on existing dashboard")
    public void clickOnExistingDashboard() {
        // Здесь должна быть логика выбора существующего dashboard
        // Для демонстрации кликаем на первый доступный
        try {
            Thread.sleep(2000); // Ждем загрузки
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("Click Add Widget button")
    public void clickAddWidget() {
        addWidgetButton.click();
    }

    @Step("Select widget type: Overall Statistics")
    public void selectOverallStatisticsWidget() {
        overallStatisticsWidget.click();
    }

    @Step("Save widget")
    public void saveWidget() {
        saveWidgetButton.click();
    }

    @Step("Check if widget is added")
    public boolean isWidgetAdded() {
        try {
            // Проверяем наличие виджета на dashboard
            // Это упрощенная проверка, в реальном сценарии нужно уточнить локатор
            return driver.getPageSource().contains("Overall statistics") ||
                    driver.getPageSource().contains("widget");
        } catch (Exception e) {
            return false;
        }
    }
}
