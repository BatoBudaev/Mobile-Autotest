package otus.appium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import com.codeborne.selenide.WebDriverRunner;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import otus.appium.factory.MobileFactory;
import otus.appium.screens.BasketScreen;
import otus.appium.screens.CatalogScreen;
import otus.appium.screens.MainScreen;

public class MainTests {
    private static AndroidDriver driver;
    private static MainScreen mainScreen;

    @BeforeAll
    public static void setup() {
        driver = MobileFactory.getAndroidDriver();
        mainScreen = new MainScreen(driver);
        WebDriverRunner.setWebDriver(driver);
    }

    @Test
    public void checkMenu() throws InterruptedException {
        mainScreen
                .clickCatalogMenuButton()
                .clickCatalogMenuButton();
        String catalogText = "\u041A\u0430\u0442\u0430\u043B\u043E\u0433";  // "каталог"
        assertEquals(catalogText, mainScreen.getToolbarTitle());
        Thread.sleep(1000);

        mainScreen
                .clickBasketMenuButton()
                .clickFavoritesMenuButton();
        String basketText = "\u0418\u0437\u0431\u0440\u0430\u043D\u043D\u043E\u0435";// "избранное"

        assertEquals(basketText, mainScreen.getToolbarTitle());
        mainScreen.clickMainMenuButton();
    }

    @Test
    public void checkPrice() throws InterruptedException {
        mainScreen.clickCatalogMenuButton();
        CatalogScreen catalogScreen = new CatalogScreen(driver);
        catalogScreen
                .clickMenProductsButton()
                .clickSeeAllButton()
                .clickProductById(1);

        String price = catalogScreen.getProductPrice();
        catalogScreen
                .clickSizeButton()
                .clickBuyButton();
        Thread.sleep(1000);
        mainScreen.clickBasketMenuButton();

        BasketScreen basketScreen = new BasketScreen(driver);
        assertNotEquals(price, basketScreen.getBasketPrice());
        basketScreen
                .clickDeleteButton()
                .clickAcceptDeleteButton();
        mainScreen
                .clickCatalogMenuButton()
                .clickMainMenuButton();
    }

    @Test
    public void searchNegativeText() throws InterruptedException {
        mainScreen.sendTextToSearch("qwerty");
        Thread.sleep(1000);

        String error = "\u041D\u0438\u0447\u0435\u0433\u043E \u043D\u0435 \u043D\u0430\u0439\u0434\u0435\u043D\u043E :("; // "ничего не найдено"
        assertEquals(error, mainScreen.getErrorTitle());
        mainScreen.clickMainMenuButton();
    }
}
