package otus.appium.screens;

import static io.appium.java_client.android.nativekey.AndroidKey.ENTER;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainScreen {
    private AndroidDriver driver;
    private final static String MAIN_MENU_XPATH = "(//android.widget.ImageView[@resource-id=\"ru.kari.android:id/navigation_bar_item_icon_view\"])[1]";
    private final static String CATALOG_MENU_XPATH = "(//android.widget.ImageView[@resource-id=\"ru.kari.android:id/navigation_bar_item_icon_view\"])[2]";

    private final static String BASKET_MENU_XPATH = "(//android.widget.ImageView[@resource-id=\"ru.kari.android:id/navigation_bar_item_icon_view\"])[3]";

    private final static String FAVORITES_MENU_XPATH = "(//android.widget.ImageView[@resource-id=\"ru.kari.android:id/navigation_bar_item_icon_view\"])[4]";

    private final static String ACCOUNT_MENU_XPATH = "(//android.widget.ImageView[@resource-id=\"ru.kari.android:id/navigation_bar_item_icon_view\"])[5]";

    private final static String TOOLBAR_TITLE_ID = "ru.kari.android:id/defaultToolbarTitle";

    private final static String SEARCH_TEXT_XPATH = "//android.widget.EditText[@resource-id=\"ru.kari.android:id/search_src_text\"]";

    private final static String ERROR_TITLE_ID = "ru.kari.android:id/emptySearchHeader";
    @FindBy(xpath = MAIN_MENU_XPATH)
    private WebElement elMainMenuButton;
    @FindBy(xpath = CATALOG_MENU_XPATH)
    private WebElement elCatalogMenuButton;

    @FindBy(xpath = BASKET_MENU_XPATH)
    private WebElement elBasketMenuButton;

    @FindBy(xpath = FAVORITES_MENU_XPATH)
    private WebElement elFavoritesMenuButton;

    @FindBy(xpath = ACCOUNT_MENU_XPATH)
    private WebElement elAccountMenuButton;

    @FindBy(id = TOOLBAR_TITLE_ID)
    private WebElement elToolbarTitle;

    @FindBy(xpath = SEARCH_TEXT_XPATH)
    private WebElement elSearchText;

    @FindBy(id = ERROR_TITLE_ID)
    private WebElement elErrorTitle;

    public MainScreen(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
        this.driver = driver;
    }

    public MainScreen clickMainMenuButton(){
        elMainMenuButton.click();

        return this;
    }

    public MainScreen clickCatalogMenuButton(){
        elCatalogMenuButton.click();

        return this;
    }

    public MainScreen clickBasketMenuButton(){
        elBasketMenuButton.click();

        return this;
    }

    public MainScreen clickFavoritesMenuButton(){
        elFavoritesMenuButton.click();

        return this;
    }

    public MainScreen clickAccountMenuButton(){
        elAccountMenuButton.click();

        return this;
    }


    public String getToolbarTitle(){
        return elToolbarTitle.getText();
    }

    public void sendTextToSearch(String text){
        elSearchText.sendKeys(text);
        elSearchText.click();
        driver.pressKey(new KeyEvent(ENTER));
    }

    public String getErrorTitle(){
        return elErrorTitle.getText();
    }
}

