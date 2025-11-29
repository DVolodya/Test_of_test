package reportportal.tests;

import reportportal.pages.DashboardPage;
import reportportal.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@Feature("Login Functionality")
public class LoginPositiveTest extends BaseTest {

    @Test
    @Description("Test login with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginWithValidCredentials() {
        logger.info("Starting positive login test");

        // Arrange
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        String validUsername = "default";
        String validPassword = "1q2w3e";

        // Act
        loginPage.open();
        loginPage.login(validUsername, validPassword);

        // Assert
        assertTrue(dashboardPage.isUserLoggedIn(),
                "User should be successfully logged in and see the dashboard");

        logger.info("Positive login test completed successfully");
    }
}