package reportportal.tests;

import reportportal.pages.DashboardPage;
import reportportal.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@Feature("Widget Management")
public class WidgetCreationTest extends BaseTest {

    @Test
    @Description("Test creating a new widget on dashboard")
    @Severity(SeverityLevel.NORMAL)
    public void testCreateNewWidget() {
        logger.info("Starting widget creation test");

        // Arrange
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        String validUsername = "default";
        String validPassword = "1q2w3e";

        // Act - Login
        loginPage.open();
        loginPage.login(validUsername, validPassword);

        assertTrue(dashboardPage.isUserLoggedIn(),
                "User should be logged in before creating widget");

        // Act - Navigate to dashboard and create widget
        dashboardPage.navigateToDashboards();
        dashboardPage.clickOnExistingDashboard();
        dashboardPage.clickAddWidget();
        dashboardPage.selectOverallStatisticsWidget();
        dashboardPage.saveWidget();

        // Assert
        assertTrue(dashboardPage.isWidgetAdded(),
                "Widget should be successfully added to dashboard");

        logger.info("Widget creation test completed successfully");
    }
}