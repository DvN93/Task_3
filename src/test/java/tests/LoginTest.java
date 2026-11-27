package tests;

import api.UserSteps;
import model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.RecoverPasswordPage;
import pageobjects.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest{

    private User user;
    private final UserSteps userSteps = new UserSteps();
    private LoginPage loginPage;
    private MainPage mainPage;

    @BeforeEach
    void setUpUser(){
        user = User.generateUser();
        userSteps.create(user);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    void deleteUser(){
        userSteps.deleteIfExists(user);
    }

    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    void loginFromMainPageButton() {
        mainPage.openMainPage();
        mainPage.clickLoginButton();
        loginPage.login(user.getEmail(), user.getPassword());
        assertTrue(mainPage.isOrderButtonDisplayed(), "После входа должна отображаться кнопка «Оформить заказ»");
    }

    @Test
    @DisplayName("Вход через кнопку «Личный Кабинет»")
    void loginFromAccountButton() {
        mainPage.openMainPage();
        mainPage.clickAccountButton();
        loginPage.login(user.getEmail(), user.getPassword());
        assertTrue(mainPage.isOrderButtonDisplayed(), "После входа должна отображаться кнопка «Оформить заказ»");
    }

    @Test
    @DisplayName("Вход через ссылку в форме регистрации")
    void loginFromRegisterPage() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.openRegistrationPage();
        registrationPage.clickLoginLink();
        loginPage.login(user.getEmail(), user.getPassword());
        assertTrue(mainPage.isOrderButtonDisplayed(), "После входа должна отображаться кнопка «Оформить заказ»");
    }

    @Test
    @DisplayName("Вход через ссылку в форме восстановления пароля")
    void loginFromRecoverPasswordPage() {
        RecoverPasswordPage recoverPasswordPage = new RecoverPasswordPage(driver);
        recoverPasswordPage.openRecoveryPage();
        recoverPasswordPage.clickLoginLink();
        loginPage.login(user.getEmail(), user.getPassword());
        assertTrue(mainPage.isOrderButtonDisplayed(), "После входа должна отображаться кнопка «Оформить заказ»");
    }
}
