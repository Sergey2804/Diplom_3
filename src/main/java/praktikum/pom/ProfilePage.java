package praktikum.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import praktikum.utils.WaitUtils;

import static praktikum.config.Url.LOGIN_PAGE;

public class ProfilePage {

    private final WebDriver driver;


    private final By headerLogo = By.className("AppHeader_header__logo__2D0X2");
    private final By constructorLink = By.xpath("//p[text()='Конструктор']");

    private final By logoutButton = By.xpath("//button[text()='Выход']");


    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Клик по логотипу Stellar Burgers в шапке")
    public void clickHeaderLogo() {
        driver.findElement(headerLogo).click();
    }

    @Step("Клик по ссылке 'Конструктор' в шапке")
    public void clickConstructor() {
        driver.findElement(constructorLink).click();
    }


    @Step("Клик по кнопке 'Выйти' в личном кабинете")
    public void clickLogoutButton() {
        WaitUtils.waitForElementVisible(driver, logoutButton);
        driver.findElement(logoutButton).click();
        WaitUtils.waitForUrl(driver, LOGIN_PAGE);
    }
}