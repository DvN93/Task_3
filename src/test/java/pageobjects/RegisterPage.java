package pageobjects;

import org.openqa.selenium.By;

public class RegisterPage extends BaseElements{

    // Кнопка зарегистрироваться
    private By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");

    // Кнопка войти через страницу регистрации
    private By loginFromRegisterPageButton = By.xpath(".//button[text()='Войти']");
}
