package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import utils.Utils;

public class HomePage {
    private AndroidDriver driver;

    private final By countryDropdown = By.id("com.androidsample.generalstore:id/spinnerCountry");
    private final By nameField = By.id("com.androidsample.generalstore:id/nameField");
    private final By maleRadio = By.id("com.androidsample.generalstore:id/radioMale");
    private final By femaleRadio = By.id("com.androidsample.generalstore:id/radioFemale");
    private final By letsShopBtn = By.id("com.androidsample.generalstore:id/btnLetsShop");

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void selectCountry(String country) {
        driver.findElement(countryDropdown).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + country + "\"))")).click();
    }

    // public void enterName(String name) {
    //     driver.findElement(nameField).sendKeys(name);
    // }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("Male"))
            driver.findElement(maleRadio).click();
        else
            driver.findElement(femaleRadio).click();
    }

    public void clickLetsShop() {
        driver.findElement(letsShopBtn).click();
    }

    public void enterName(String name) {
        Utils.type(nameField, name);
    }
}
