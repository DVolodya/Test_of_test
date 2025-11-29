package reportportal.tests;

import reportportal.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@Feature("Login Functionality")
public class LoginNegativeTest extends BaseTest {

    @Test
    @Description("Test login with invalid credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void testLoginWithInvalidCredentials() {
        logger.info("Starting negative login test");

        // Arrange
        LoginPage loginPage = new LoginPage(driver);
        String invalidUsername = "invalidUser";
        String invalidPassword = "wrongPass";

        // Act
        loginPage.open();
        String initialUrl = loginPage.getCurrentUrl();

        loginPage.login(invalidUsername, invalidPassword);

        // Assert
        assertAll("Login error validation",
                () -> assertTrue(loginPage.isErrorMessageDisplayed(),
                        "Error message should be displayed for invalid credentials"),
                () -> assertTrue(loginPage.isLoginFormDisplayed(),
                        "Login form should still be displayed after failed login"),
                () -> assertTrue(loginPage.getCurrentUrl().contains("login") ||
                                loginPage.getCurrentUrl().equals(initialUrl),
                        "User should remain on login page")
        );

        logger.info("Negative login test completed successfully");
    }
}
