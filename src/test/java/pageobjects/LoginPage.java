package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.Constants.LOGIN_URL;

public class LoginPage extends BasePage {

    // Заголовок формы входа
    private final By loginHeader = By.xpath(".//h2[text()='Вход']");

    // Кнопка войти на странице входа
    private final By loginPageButton = By.xpath(".//button[text()='Войти']");

    // Поле ввода email
    private final By emailInput = By.xpath(".//label[text()='Email']/following-sibling::input");

    // Поле ввода пароля
    private final By passwordInput = By.xpath(".//label[text()='Пароль']/following-sibling::input");

    // Кнопка зарегистрироваться
    private final By registerLink = By.xpath(".//a[text()='Зарегистрироваться']");

    // Кнопка восстановления пароля
    private final By forgotPasswordLink = By.xpath(".//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @Step("Открыть страницу входа")
    public void openLoginPage(){
        driver.get(LOGIN_URL);
    }

    @Step("Ввести email")
    public void enterEmail(String email){
        waitHelper.type(emailInput, email);
    }

    @Step("Ввести пароль")
    public void enterPassword(String password){
        waitHelper.type(passwordInput, password);
    }

    @Step("Нажать на кнопку Войти на странице входа")
    public void clickLoginPageButton(){
        waitHelper.waitForClickable(loginPageButton).click();
    }

    @Step("Нажать на ссылку Зарегистрироваться на странице входа")
    public void clickRegisterLink(){
        waitHelper.waitForClickable(registerLink).click();
    }

    @Step("Нажать на ссылку Восстановить пароль")
    public void clickForgotPasswordLink(){
        waitHelper.waitForClickable(forgotPasswordLink).click();
    }

    @Step("Авторизоваться пользователем")
    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLoginPageButton();
    }

    @Step("Проверить что отображается форма входа")
    public boolean isLoginFormDisplayed() {
        return waitHelper.isElementDisplayed(loginHeader);
    }
}
