package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {

    private final WebDriver driver;
    private final WebDriverWait wait;
    // Таймаут ожидания в секундах
    private final static int WAITING_TIMEOUT = 10;

    public WaitHelper(WebDriver driver){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAITING_TIMEOUT));
    }

    public WebElement waitForVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
