package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.Constants.BASE_URL;

public class MainPage extends BasePage {


    // Кнопка войти в аккаунт
    private By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");

    // Кнопка Оформить заказ
    private final By orderButton = By.xpath(".//button[text()='Оформить заказ']");

    // Конструктор
    private final By constructor = By.xpath(".//h1[text()='Соберите бургер']");

    // Вкладка Булки
    private final By bunsTab = By.xpath(".//span[text()='Булки']/parent::div");

    // Вкладка Соусы
    private final By saucesTab = By.xpath(".//span[text()='Соусы']/parent::div");

    // Вкладка Начинки
    private final By fillingsTab = By.xpath(".//span[text()='Начинки']/parent::div");

    // Имя класса для текущей вкладки в конструкторе бургера
    private static final String CURRENT_TAB_CLASS = "tab_tab_type_current";

    public MainPage(WebDriver driver){
        super(driver);
    }

    @Step("Открыть главную страницу")
    public void openMainPage(){
        driver.get(BASE_URL);
    }

    @Step("Нажать кнопку Войти в аккаунт")
    public void clickLoginButton(){
        waitHelper.waitForClickable(loginButton).click();
    }

    @Step("Нажать на вкладку Булки")
    public void clickBunsTab(){
        waitHelper.waitForClickable(bunsTab).click();
    }

    @Step("Нажать на вкладку Соусы")
    public void clickSaucesTab(){
        waitHelper.waitForClickable(saucesTab).click();
    }

    @Step("Нажать на вкладку Начинки")
    public void clickFillingsTab(){
        waitHelper.waitForClickable(fillingsTab).click();
    }

    @Step("Проверить что отображается кнопка Оформить заказ")
    public boolean isOrderButtonDisplayed(){
        return waitHelper.isElementDisplayed(orderButton);
    }

    @Step("Проверить что отображается кнопка Соберите бургер")
    public boolean isConstructorBurgerDisplayed(){
        return waitHelper.isElementDisplayed(constructor);
    }

    @Step("Проверить что выбрана вкладка Булки")
    public boolean isBunsTabSelected(){
        return waitHelper.hasClass(bunsTab, CURRENT_TAB_CLASS);
    }

    @Step("Проверить что выбрана вкладка Соусы")
    public boolean isSaucesTabSelected(){
        return waitHelper.hasClass(saucesTab, CURRENT_TAB_CLASS);
    }

    @Step("Проверить что выбрана вкладка Начинки")
    public boolean isFillingsTabSelected(){
        return waitHelper.hasClass(fillingsTab, CURRENT_TAB_CLASS);
    }
}
