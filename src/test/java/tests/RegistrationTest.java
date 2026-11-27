package tests;

import api.UserSteps;
import model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationTest extends BaseTest{

    private RegistrationPage registrationPage;
    private User user;
    private UserSteps userSteps;
    private LoginPage loginPage;
    private MainPage mainPage;

    @BeforeEach
    void openRegistrationPage(){
        user = User.generateUser();
        registrationPage = new RegistrationPage(driver);
        registrationPage.openRegistrationPage();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    @AfterEach
    void deleteUser(){
        userSteps = new UserSteps();
        userSteps.deleteIfExists(user);
    }

    @Test
    @DisplayName("Успешная регистрация клиента")
    void registerWithValidData(){
        assertTrue(registrationPage.isRegistrationFormDisplayed(), "Не отображается форма регистрации");
        registrationPage.register(user.getName(), user.getEmail(), user.getPassword());
        assertTrue(loginPage.isLoginFormDisplayed(), "Форма входа после регистрации не отобразилась");
    }

    @Test
    @DisplayName("При вводе некорректного пароля появляется сообщение об ошибке")
    void registerWithInvalidPassword(){
        assertTrue(registrationPage.isRegistrationFormDisplayed(), "Не отображается форма регистрации");
        registrationPage.register(user.getName(), user.getEmail(), "12345");
        assertTrue(registrationPage.isIncorrectPasswordMessageDisplayed(), "Отсутствует сообщение о некорректном пароле");
    }
}
