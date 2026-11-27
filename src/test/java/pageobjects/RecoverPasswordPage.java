package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.Constants.RECOVERY_URL;

public class RecoverPasswordPage extends BasePage{

    // Ссылка «Войти» на странице восстановления пароля
    private final By loginLink = By.xpath(".//a[text()='Войти']");

    // Заголовок восстановления пароля
    private final By recoverPasswordHeader = By.xpath(".//h2[text()='Восстановление пароля']");

    public RecoverPasswordPage(WebDriver driver){
        super(driver);
    }

    @Step("Открыть страницу восстановления пароля")
    public void openRecoveryPage(){
        driver.get(RECOVERY_URL);
    }

    @Step("Нажать на кнопку Войти на странице восстановления пароля")
    public void clickLoginLink(){
        waitHelper.waitForClickable(loginLink).click();
    }

}
