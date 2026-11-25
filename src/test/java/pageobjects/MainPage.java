package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pageobjects.Constants.BASE_URL;

public class MainPage extends BaseElements{

    private static final String URL = "https://qa-stellarburgers.education-services.ru/";


    // Кнопка войти в аккаунт
    private By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");

    // Вкладка Булки
    private By bunsTab = By.xpath(".//span[text()='Булки']");

    // Вкладка Соусы
    private By soucesTab = By.xpath(".//span[text()='Соусы']");

    // Вкладка Начинки
    private By fillingsTab = By.xpath(".//span[text()='Начинки']");

    public MainPage(WebDriver driver){
        super(driver);
    }

    public void openPage(){
        driver.get(BASE_URL);
    }

    public void clickloginButton(){
        driver.findElement(loginButton).click();
    }

    public void clickBunsTab(){
        driver.findElement(bunsTab).click();
    }

    public void clickSoucesTab(){
        driver.findElement(soucesTab).click();
    }

    public void FillingsTab(){
        driver.findElement(fillingsTab).click();
    }
}
