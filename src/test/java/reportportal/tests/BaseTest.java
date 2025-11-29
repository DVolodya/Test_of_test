package reportportal.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import reportportal.config.TestConfig;
import io.qameta.allure.Allure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
    protected WebDriver driver;
    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeEach
    public void setUp() {
        // Можно изменить на TestConfig.Browser.FIREFOX для тестов в Firefox
        TestConfig.initializeDriver(TestConfig.Browser.CHROME);
        driver = TestConfig.getDriver();

        logger.info("Browser initialized");
        Allure.addAttachment("Browser", "Chrome started");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            TestConfig.quitDriver();
            logger.info("Browser closed");
            Allure.addAttachment("Browser", "Chrome closed");
        }
    }
}