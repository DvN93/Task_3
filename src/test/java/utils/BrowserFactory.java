package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {

    public static WebDriver create() {
        String browser = System.getProperty("browser", "chrome");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");

        switch (browser.toLowerCase()) {
            case "chrome":
                return new ChromeDriver(options);
            case "yandex":
                System.setProperty("webdriver.chrome.driver", System.getProperty("yandex.driver.path"));
                options.setBinary(System.getProperty("yandex.binary.path"));
                return new ChromeDriver(options);
            default:
                throw new IllegalArgumentException("Неизвестный браузер: " + browser);
        }
    }
}
