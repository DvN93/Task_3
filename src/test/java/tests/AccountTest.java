package tests;

import api.UserSteps;
import model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobjects.AccountPage;
import pageobjects.LoginPage;
import pageobjects.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTest extends BaseTest{

    private User user;
    private final UserSteps userSteps = new UserSteps();
    private LoginPage loginPage;
    private MainPage mainPage;
    private AccountPage accountPage;

    @BeforeEach
    void setUpUserAndLogin(){
        user = User.generateUser();
        userSteps.create(user);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        loginPage.openLoginPage();
        loginPage.login(user.getEmail(), user.getPassword());
        assertTrue(mainPage.isOrderButtonDisplayed(), "Не удалось войти в аккаунт при подготовке теста");
    }

    @AfterEach
    void deleteUser(){
        userSteps.deleteIfExists(user);
    }

    @Test
    @DisplayName("Переход в личный кабинет с главной страницы")
    void accountOpenFromMainPage(){
        mainPage.clickAccountButton();
        assertTrue(accountPage.isProfileLinkDisplayed(), "«После клика на «Личный Кабинет» должен открыться личный кабинет»");
    }

    @Test
    @DisplayName("Переход по клику на «Конструктор»")
    void goToConstructor(){
        mainPage.clickAccountButton();
        mainPage.clickConstructorButton();
        assertTrue(mainPage.isConstructorBurgerDisplayed(), "После перехода должен отображаться Конструктор");
    }

    @Test
    @DisplayName("Переход по клику на логотип")
    void goToMainPageByLogo(){
        mainPage.clickAccountButton();
        mainPage.clickLogoButton();
        assertTrue(mainPage.isOrderButtonDisplayed(), "После перехода должна отображаться кнопка «Оформить заказ»");
    }

    @Test
    @DisplayName("Выход из аккаунта")
    void logout(){
        mainPage.clickAccountButton();
        accountPage.clickLogoutButton();
        assertTrue(loginPage.isLoginFormDisplayed(), "После выхода из аккаунта должна отображаться форма входа");
    }
}
