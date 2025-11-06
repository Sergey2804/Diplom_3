package praktikum.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import praktikum.utils.WaitUtils;

import static praktikum.config.Url.MAIN_PAGE;

public class LoginPage {

    private final WebDriver driver;


    private final By emailField = By.xpath("//input[@name='name']");
    private final By passwordField = By.xpath("//input[@type='password']");
    private final By loginButton = By.xpath("//button[text()='Войти']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнение поля email")
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    @Step("Заполнение поля пароль")
    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    @Step("Клик по кнопке Войти")
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Вход в аккаунт: email = {email}, пароль = {password}")
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        WaitUtils.waitForUrl(driver, MAIN_PAGE);
    }
}