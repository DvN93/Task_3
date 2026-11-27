package tests;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void setUp(){
        String browser = System.getProperty("browser", "chrome");
        driver = BrowserFactory.create();
        driver.manage().window().maximize();
        Allure.parameter("browser", System.getProperty("browser", "chrome"));
        Allure.parameter("browser", browser);
        Allure.label("parentSuite", browser);
        Allure.getLifecycle().updateTestCase(result ->
                result.setHistoryId(result.getFullName() + "[" + browser + "]"));
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
