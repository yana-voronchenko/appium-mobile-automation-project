package tests;

import base.BaseTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.HomePage;
import pages.SplashPage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HomeTest extends BaseTest {

    private HomePage home;
    private SplashPage splash;

    @BeforeEach
    void setUpHome() {
        splash = new SplashPage(driver);
        assertTrue(splash.isDisplayed(), "Splash screen should be visible");

        wait.until(ExpectedConditions
                .invisibilityOfElementLocated(By.id("com.androidsample.generalstore:id/splashscreen")));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("com.androidsample.generalstore:id/toolbar_title")));

        home = new HomePage(driver);
    }

    @Test
    void testHomeScreenFlow() {
        home.selectCountry("Argentina");
        home.enterName("Viktor");
        home.selectGender("Male");
        home.clickLetsShop();
    }
}
