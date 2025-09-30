package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Utils {
    Utilscted WebElement waitForElement(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Не вдалося знайти елемент: " + locator + " | Причина: " + e.getMessage());
            throw e;
        }
    }

    // Перевірка чи елемент відображається
    public boolean isElementDisplayed(By locator) {
        try {
            boolean displayed = driver.findElement(locator).isDisplayed();
            System.out.println("Елемент відображається: " + locator);
            return displayed;
        } catch (NoSuchElementException e) {
            System.out.println(" Елемент не знайдено: " + locator);
            return false;
        } catch (Exception e) {
            System.out.println("Помилка при перевірці елемента: " + locator + " | Причина: " + e.getMessage());
            return false;
        }
    }

    // Клік по елементу
    public void click(By locator) {
        try {
            waitForElement(locator).click();
            System.out.println(" Клік по елементу: " + locator);
        } catch (Exception e) {
            System.out.println(" Помилка кліку по елементу: " + locator + " | Причина: " + e.getMessage());
            throw e;
        }
    }

    // Введення тексту
    public static void type(By locator, String text) {
        try {
            WebElement el = waitForElement(locator);
            el.clear();
            el.sendKeys(text);
            System.out.println("Введено текст '" + text + "' у поле: " + locator);
        } catch (Exception e) {
            System.out.println("Помилка при введенні тексту '" + text + "' у поле: " + locator + " | Причина: " + e.getMessage());
            throw e;
        }
    }

    // Отримати текст
    public String getText(By locator) {
        try {
            String text = waitForElement(locator).getText();
            System.out.println("Отримано текст з елемента: " + locator + " | Значення: " + text);
            return text;
        } catch (Exception e) {
            System.out.println("Помилка при отриманні тексту з елемента: " + locator + " | Причина: " + e.getMessage());
            throw e;
        }
    }
}
    