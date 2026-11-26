package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class BasePage {
    protected final WebDriver driver;
    protected final WaitHelper waitHelper;

    // Кнопка личный кабинет
    private final By accountButton = By.xpath(".//p[text()='Личный Кабинет']");

    // Кнопка Конструктор
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");

    // Логотип Stellar Burger
    private final By logoStellarBurger = By.cssSelector("div[class*='AppHeader_header__logo'] a");

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver);
    }

    @Step("Нажать на кнопку Личный Кабинет")
    public void clickAccountButton(){
        waitHelper.waitForClickable(accountButton).click();
    }
    @Step("Нажать на кнопку Конструктор")
    public void clickConstructorButton(){
        waitHelper.waitForClickable(constructorButton).click();
    }
    @Step("Нажать на логотип")
    public void clickLogoButton(){
        waitHelper.waitForClickable(logoStellarBurger).click();
    }
}
