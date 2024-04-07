package otus.appium.screens;

import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$x;

import com.codeborne.selenide.appium.AppiumScrollOptions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CatalogScreen {

    private final static String MEN_PRODUCTS_XPATH = "(//android.widget.FrameLayout[@resource-id=\"ru.kari.android:id/cardCategory\"])[2]/androidx.appcompat.widget.LinearLayoutCompat";

    private final static String SEE_ALL_XPATH = "//android.widget.TextView[@resource-id=\"ru.kari.android:id/tvCategoryName\" and @text=\"Смотреть все\"]";

    private final static String PRODUCT_PRICE_XPATH = "//android.widget.TextView[@resource-id=\"ru.kari.android:id/tvProductPrice\"]";

    private final static String SIZE_XPATH = "//android.widget.TextView[@resource-id=\"ru.kari.android:id/sizeValue\" and @text=\"40\"]";
    private final static String BUY_BUTTON_ID = "ru.kari.android:id/floatingBtnBuy";

    public CatalogScreen(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    @FindBy(xpath = MEN_PRODUCTS_XPATH)
    private WebElement elMenProductsButton;

    @FindBy(xpath = SEE_ALL_XPATH)
    private WebElement elSeeAllButton;

    @FindBy(xpath = PRODUCT_PRICE_XPATH)
    private WebElement elProductPrice;

    @FindBy(xpath = SIZE_XPATH)
    private WebElement elSizeButton;

    @FindBy(id = BUY_BUTTON_ID)
    private WebElement elBuyButton;

    public CatalogScreen clickMenProductsButton() {
        elMenProductsButton.click();

        return this;
    }

    public CatalogScreen clickSeeAllButton() {
        elSeeAllButton.click();

        return this;
    }

    public void clickProductById(int index) {
        String productXpath = "(//android.widget.ImageView[@resource-id=\"ru.kari.android:id/ivProductImage\"])[" + index + "]";
        $(By.xpath(productXpath)).click();
    }

    public String getProductPrice() {
        $x(PRODUCT_PRICE_XPATH).scroll(AppiumScrollOptions.up());
        String cleanedInput = elProductPrice.getText().replaceAll("[^\\d,]", "");
        return cleanedInput.replace(",", "");
    }

    public CatalogScreen clickSizeButton(){
        $x(SIZE_XPATH).scroll(AppiumScrollOptions.down());
        elSizeButton.click();

        return this;
    }

    public CatalogScreen clickBuyButton(){
        elBuyButton.click();

        return this;
    }
}

