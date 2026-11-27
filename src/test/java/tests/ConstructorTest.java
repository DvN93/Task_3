package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageobjects.MainPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConstructorTest extends BaseTest{

    private MainPage mainPage;

    @BeforeEach
    void openMainPage(){
        mainPage = new MainPage(driver);
        mainPage.openMainPage();
    }

    @Test
    @DisplayName("Проверка перехода на вкладку Булки")
    public void goToBunsTab(){
        mainPage.clickSaucesTab();
        mainPage.clickBunsTab();
        assertTrue(mainPage.isBunsTabSelected(), "Вкладки Булки не отобразилась");
    }

    @Test
    @DisplayName("Проверка перехода на вкладку Соусы")
    public void goToSaucesTab(){
        mainPage.clickSaucesTab();
        assertTrue(mainPage.isSaucesTabSelected(), "Вкладка Соусы не отобразилась");
    }

    @Test
    @DisplayName("Проверка перехода на вкладку Начинки")
    public void goToFillingsTab(){
        mainPage.clickFillingsTab();
        assertTrue(mainPage.isFillingsTabSelected(), "Вкладка Начинки не отобразилась");
    }
}
