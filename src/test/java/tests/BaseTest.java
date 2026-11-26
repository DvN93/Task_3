package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import utils.BrowserFactory;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void setUp(){
        driver = BrowserFactory.create();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
