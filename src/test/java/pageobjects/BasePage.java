package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitHelper;

public class BaseElements {
    protected final WebDriver driver;
    protected final WaitHelper waitHelper;

    // Кнопка личный кабинет
    private final By accountButton = By.xpath(".//p[text()='Личный Кабинет']");

    // Кнопка Конструктор
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");

    // Логотип Stellar Burger
    private final By logoStellarBurger = By.cssSelector("div[class*='AppHeader_header__logo'] a");

    public BaseElements(WebDriver driver){
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver);
    }

    @Step
    public void clickAccountButton(){
        waitHelper.waitForClickable(accountButton).click();
    }
    @Step
    public void clickConstructorButton(){
        waitHelper.waitForClickable(constructorButton).click();
    }
    @Step
    public void clickLogoButton(){
        waitHelper.waitForClickable(logoStellarBurger).click();
    }
}
