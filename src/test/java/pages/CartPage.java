package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private AndroidDriver driver;

    private final By productList = By.id("com.androidsample.generalstore:id/productName");
    private final By productPrice = By.id("com.androidsample.generalstore:id/productPrice");
    private final By totalAmount = By.id("com.androidsample.generalstore:id/totalAmountLbl");
    private final By checkbox = By.className("android.widget.CheckBox");
    private final By proceedBtn = By.id("com.androidsample.generalstore:id/btnProceed");

    public CartPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public int getProductsCount() {
        return driver.findElements(productList).size();
    }

    public double getTotalPrice() {
        return Double.parseDouble(driver.findElement(totalAmount).getText().replace("$", ""));
    }

    public double sumProductsPrices() {
        List<WebElement> prices = driver.findElements(productPrice);
        return prices.stream()
                .mapToDouble(p -> Double.parseDouble(p.getText().replace("$", "")))
                .sum();
    }

    public void acceptTermsAndProceed() {
        driver.findElement(checkbox).click();
        driver.findElement(proceedBtn).click();
    }
}
