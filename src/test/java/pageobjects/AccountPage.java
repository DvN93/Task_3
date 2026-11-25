package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BaseElements{

    private static final String ACCOUNT_URL = "https://qa-stellarburgers.education-services.ru/account/profile";

    // Кнопка выход
    private By logoutButton = By.xpath(".//button[text()='Выход']");

    public AccountPage(WebDriver driver){
        super(driver);
    }
}
