package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.Constants.REGISTER_URL;

public class RegistrationPage extends BasePage {

    // Заголовок формы регистрации
    private final By registrationHeader = By.xpath(".//h2[text()='Регистрация']");

    // Кнопка зарегистрироваться
    private final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");

    // Кнопка войти через страницу регистрации
    private final By loginLink = By.xpath(".//a[text()='Войти']");

    // Поле ввода имени
    private final By nameInput = By.xpath(".//label[text()='Имя']/following-sibling::input");

    // Поле ввода email
    private final By emailInput = By.xpath(".//label[text()='Email']/following-sibling::input");

    // Поле ввода пароля
    private final By passwordInput = By.xpath(".//label[text()='Пароль']/following-sibling::input");

    // Сообщение о некорректном пароле
    private final By incorrectPassword = By.xpath(".//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    @Step("Открыть страницу регистрации")
    public void openRegistrationPage(){
        driver.get(REGISTER_URL);
    }

    @Step("Нажать на кнопку Зарегистрироваться на странице регистрации")
    public void clickRegistrationButton(){
        waitHelper.waitForClickable(registrationButton).click();
    }

    @Step("Нажать на кнопку Войти на странице регистрации")
    public void clickLoginLink(){
        waitHelper.waitForClickable(loginLink).click();
    }

    @Step("Проверить что отображается форма регистрации")
    public boolean isRegistrationFormDisplayed() {
        return waitHelper.isElementDisplayed(registrationHeader);
    }

    @Step("Проверить что отображается сообщение о некорректном пароле")
    public boolean isIncorrectPasswordMessageDisplayed() {
        return waitHelper.isElementDisplayed(incorrectPassword);
    }

    @Step("Зарегистрировать пользователя")
    public void register(String name, String email, String password){
        waitHelper.type(nameInput, name);
        waitHelper.type(emailInput, email);
        waitHelper.type(passwordInput, password);
        clickRegistrationButton();
    }
}
