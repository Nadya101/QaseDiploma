package utils;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class Waiters {

    public static void waitForElementLocated(WebDriver driver, By element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        log.info(String.format("Wait visibility of Element located '%s' up to %d sec.", element, timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void waitForElementLocated(WebDriver driver, WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        log.info(String.format("Wait visibility of WebElement '%s' up to %d sec.", element, timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
