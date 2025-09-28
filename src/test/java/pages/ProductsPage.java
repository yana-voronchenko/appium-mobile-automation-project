package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ProductsPage {
    private AndroidDriver driver;

    private final By productTitle = By.id("com.androidsample.generalstore:id/toolbar_title");
    private final By firstAddToCartBtn = By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]");
    private final By cartIcon = By.id("com.androidsample.generalstore:id/appbar_btn_cart");

    public ProductsPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.findElement(productTitle).getText();
    }

    public void addFirstProductToCart() {
        driver.findElement(firstAddToCartBtn).click();
    }

    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}
