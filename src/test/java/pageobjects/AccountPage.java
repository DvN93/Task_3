package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    // Кнопка выход
    private final By logoutButton = By.xpath(".//button[text()='Выход']");

    // Ссылка на профиль
    private final By profileLink = By.xpath(".//a[text()='Профиль']");

    public AccountPage(WebDriver driver){
        super(driver);
    }

    @Step("Проверить, что отображается ссылка на профиль")
    public boolean isProfileLinkDisplayed(){
        return waitHelper.isElementDisplayed(profileLink);
    }

    @Step("Выйти из личного кабинета")
    public void clickLogoutButton(){
        waitHelper.waitForClickable(logoutButton).click();
    }
}
