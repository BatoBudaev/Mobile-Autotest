package otus.appium.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasketScreen {
    private final static String BASKET_PRICE_ID = "ru.kari.android:id/productPriceBasketV2";

    private final static String DELETE_XPATH = "//androidx.appcompat.widget.LinearLayoutCompat[@resource-id=\"ru.kari.android:id/removeBasketItem\"]/android.widget.ImageView";

    private final static String ACCEPT_DELETE_ID = "ru.kari.android:id/deleteBasketItemAccept";
    @FindBy(id = BASKET_PRICE_ID)
    private WebElement elBasketPrice;

    @FindBy(xpath = DELETE_XPATH)
    private WebElement elDeleteButton;

    @FindBy(id = ACCEPT_DELETE_ID)
    private WebElement elAcceptDeleteButton;

    public BasketScreen(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public String getBasketPrice() {
        String cleanedInput = elBasketPrice.getText().replaceAll("[^\\d,]", "");
        return cleanedInput.replace(",", "");
    }

    public BasketScreen clickDeleteButton(){
        elDeleteButton.click();

        return this;
    }

    public BasketScreen clickAcceptDeleteButton(){
        elAcceptDeleteButton.click();

        return this;
    }
}
