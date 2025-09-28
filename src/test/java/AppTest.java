import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By; //для локаторів
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URI;
import java.time.Duration; //дає змогу запустити сервер

public class AppTest {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setup() throws Exception {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("emulator-5554")
                .setApp(System.getProperty("user.dir") + "/General-Store.apk")
                .setAppPackage("com.androidsample.generalstore")
                .setAppActivity("com.androidsample.generalstore.SplashActivity");

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
        if (driver != null)
            driver.quit();

    }

    @Test // запускає тест
    void testAppLaunch() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.androidsample.generalstore:id/splashscreen")));
        Assertions.assertTrue(title.isDisplayed(), "Головний екран не завантажився");
    }

    @Test
    void testToolbarTitleAttributes() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("com.androidsample.generalstore:id/toolbar_title")));

        Assertions.assertTrue(title.isDisplayed(), "Toolbar title не відображається!");

        Assertions.assertEquals("General Store", title.getText(), "Неправильний текст!");

        Assertions.assertEquals("android.widget.TextView",
                title.getAttribute("className"), "Клас елемента не співпадає!");

        Assertions.assertTrue(title.isEnabled(), "Елемент має бути enabled!");

        Assertions.assertEquals("false", title.getAttribute("clickable"), "Елемент не повинен бути клікабельним!");

        Assertions.assertEquals("false", title.getAttribute("selected"), "Елемент не повинен бути вибраний!");

        String bounds = title.getAttribute("bounds");
        Assertions.assertTrue(bounds.matches("\\[\\d+,\\d+\\]\\[\\d+,\\d+\\]"), "Bounds мають бути координатами!");
    };

}
