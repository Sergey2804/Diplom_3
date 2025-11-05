package praktikum.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import praktikum.utils.WaitUtils;

import static praktikum.config.Url.PROFILE_PAGE;

public class MainPage {

    private final WebDriver driver;


    private final By loginButtonOnPage = By.xpath("//button[text()='Войти в аккаунт']");
    private final By personalCabinetButton = By.xpath("//p[text()='Личный Кабинет']");


    private final By bunsConstructorTab = By.xpath("//span[text()='Булки']");
    private final By saucesConstructorTab = By.xpath("//span[text()='Соусы']");
    private final By fillingsConstructorTab = By.xpath("//span[text()='Начинки']");

    private final By bunsTabSelected = By.xpath("//div[contains(@class,'tab_tab_type_current')]/span[text()='Булки']");
    private final By saucesTabSelected = By.xpath("//div[contains(@class,'tab_tab_type_current')]/span[text()='Соусы']");
    private final By fillingsTabSelected = By.xpath("//div[contains(@class,'tab_tab_type_current')]/span[text()='Начинки']");


    private final By placeOrderButton = By.xpath("//button[text()='Оформить заказ']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Клик по кнопке 'Войти в аккаунт' на Главной странице")
    public void clickLoginButton() {
        driver.findElement(loginButtonOnPage).click();
    }

    @Step("Клик по кнопке 'Личный кабинет' на Главной странице")
    public void clickPersonalCabinetButton() {
        driver.findElement(personalCabinetButton).click();
        WaitUtils.waitForUrl(driver, PROFILE_PAGE);
    }

    @Step("Проверка отображения кнопки 'Оформить заказ'")
    public boolean isPlaceOrderButtonVisible() {
        return driver.findElement(placeOrderButton).isDisplayed();
    }


    @Step("Клик по вкладке 'Булки' в конструкторе")
    public void clickBunsConstructorTab() {
        driver.findElement(bunsConstructorTab).click();
    }

    @Step("Клик по вкладке 'Соусы' в конструкторе")
    public void clickSaucesConstructorTab() {
        driver.findElement(saucesConstructorTab).click();
    }

    @Step("Клик по вкладке 'Начинки' в конструкторе")
    public void clickFillingsConstructorTab() {
        driver.findElement(fillingsConstructorTab).click();
    }

    @Step("Проверка, что вкладка 'Булки' выбрана")
    public boolean isBunSelect() {
        WaitUtils.waitForElementVisible(driver, bunsTabSelected);
        return driver.findElement(bunsTabSelected).isDisplayed();
    }

    @Step("Проверка, что вкладка 'Соусы' выбрана")
    public boolean isSaucesSelect() {
        WaitUtils.waitForElementVisible(driver, saucesTabSelected);
        return driver.findElement(saucesTabSelected).isDisplayed();
    }

    @Step("Проверка, что вкладка 'Начинки' выбрана")
    public boolean isFillingsSelect() {
        WaitUtils.waitForElementVisible(driver, fillingsTabSelected);
        return driver.findElement(fillingsTabSelected).isDisplayed();
    }
}
