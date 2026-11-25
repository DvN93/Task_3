package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseElements{

    private static final String LOGIN_URL = "https://qa-stellarburgers.education-services.ru/login";
    private final WebDriver driver;

    // Кнопка войти на странице входа
    private By loginPageButton = By.xpath(".//button[text()='Войти']");
}
