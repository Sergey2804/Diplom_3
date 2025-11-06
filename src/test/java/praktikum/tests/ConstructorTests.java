package praktikum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.pom.MainPage;

import static praktikum.config.Url.MAIN_PAGE;

@DisplayName("Тесты главной страницы (Конструктор)")
public class ConstructorTests extends BaseTest{
    private MainPage mainPage;

    @Before
    public void initPage() {
        driver.get(MAIN_PAGE);
        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Переход к разделу 'Булки'")
    @Description("Проверяет, что при клике на раздел 'Булки' открывается соответствующий контент")
    public void clickBunsButtonSelectsBunsTab() {
        mainPage.clickSaucesConstructorTab();
        mainPage.clickBunsConstructorTab();

        Assert.assertTrue("Таб 'Булки' не стал активным", mainPage.isBunSelect());
    }

    @Test
    @DisplayName("Клик по кнопке 'Соусы' выбирает соответствующий таб")
    @Description("Проверяет, что при клике на таб 'Соусы' он становится активным")
    public void clickSaucesButtonSelectsSaucesTab() {
        mainPage.clickSaucesConstructorTab();

        Assert.assertTrue("Таб 'Соусы' не стал активным", mainPage.isSaucesSelect());
    }

    @Test
    @DisplayName("Клик по кнопке 'Начинки' выбирает соответствующий таб")
    @Description("Проверяет, что при клике на таб 'Начинки' он становится активным")
    public void clickFillingsButtonSelectsFillingsTab() {
        mainPage.clickFillingsConstructorTab();


        Assert.assertTrue("Таб 'Начинки' не стал активным", mainPage.isFillingsSelect());
    }
}