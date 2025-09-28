package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.Set;

public class WebViewPage {
    private AndroidDriver driver;

    private final By googleSearchField = By.name("q");

    public WebViewPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void switchToWebView() {
        Set<String> contexts = driver.getContextHandles();
        for (String context : contexts) {
            if (context.contains("WEBVIEW")) {
                driver.context(context);
                break;
            }
        }
    }

    public void searchInGoogle(String query) {
        driver.findElement(googleSearchField).sendKeys(query + "\n");
    }
}
