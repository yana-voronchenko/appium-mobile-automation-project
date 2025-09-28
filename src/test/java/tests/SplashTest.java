package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pages.SplashPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SplashTest extends BaseTest {

    @Test
    void testSplashIsDisplayed() {
        SplashPage splash = new SplashPage(driver);
        assertTrue(splash.isDisplayed(), "Splash screen should be visible");
    }
}