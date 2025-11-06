package praktikum.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.pom.*;
import praktikum.utils.WaitUtils;

import static praktikum.config.Url.*;

@DisplayName("Тесты личного кабинета")
public class PersonalCabinetTests extends BaseTest {
    private ProfilePage profilePage;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private MainPage mainPage;
    private String expectedUrl;
    private String actualUrl;

    private final Faker faker = new Faker();

    private String name;
    private String email;
    private String password;

    @Before
    public void initPage() {
        name = faker.name().firstName();
        email = faker.internet().emailAddress();
        password = faker.internet().password();

        driver.get(REGISTER_PAGE);
        mainPage = new MainPage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        registerPage.register(name, email, password);
        WaitUtils.waitForUrl(driver, LOGIN_PAGE);
        loginPage.login(email, password);

    }

    @Test
    @DisplayName("Переход по кнопке 'Личный кабинет' на главной странице")
    @Description("Проверяет, что авторизованный пользователь попадает в личный кабинет при клике на кнопку 'Личный кабинет'")
    public void clickPersonalCabinetButtonOpensProfilePage() {
        mainPage.clickPersonalCabinetButton();

        expectedUrl = PROFILE_PAGE;
        actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("Переход по кнопке 'Личный кабинет' не открыл страницу профиля", expectedUrl, actualUrl);
    }

    @Test
    @DisplayName("Переход из личного кабинета по кнопке 'Конструктор'")
    @Description("Проверяет, что из личного кабинета можно вернуться на главную по кнопке 'Конструктор'")
    public void clickConstructorLinkFromPersonalCabinetOpensMainPage() {
        mainPage.clickPersonalCabinetButton();
        profilePage.clickConstructor();

        expectedUrl = MAIN_PAGE;
        actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("Переход по кнопке 'Конструктор' не открыл главную страницу", expectedUrl, actualUrl);
    }

    @Test
    @DisplayName("Переход по логотипу из личного кабинета")
    @Description("Проверяет, что клик по логотипу из личного кабинета ведет на главную страницу")
    public void clickLogoFromRegisterPageOpensMainPage() {
        mainPage.clickPersonalCabinetButton();
        profilePage.clickHeaderLogo();

        expectedUrl = MAIN_PAGE;
        actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("Переход по кнопке 'Конструктор' не открыл главную страницу", expectedUrl, actualUrl);
    }

    @Test
    @DisplayName("Выход из аккаунта через личный кабинет")
    @Description("Проверяет, что пользователь выходит из аккаунта по кнопке 'Выход' в личном кабинете и попадает на страницу логина")
    public void logoutFromProfilePageRedirectsToLogin() {
        mainPage.clickPersonalCabinetButton();
        profilePage.clickLogoutButton();

        expectedUrl = LOGIN_PAGE;
        actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("Выход из аккаунта не привёл на страницу логина", expectedUrl, actualUrl);
    }
}