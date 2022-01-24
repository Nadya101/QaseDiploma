package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ui.constants.IConstants;

@Log4j2
public class BasePage implements IConstants {
    WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
        log.debug("Initializing PageFactory");
        PageFactory.initElements(driver, this);
    }

    @Step("Open page: '{url}'")
    public void openPage(String url) {
        log.info("Open URL: " + url);
        driver.get(url);
    }

    public String getUrl() {
        log.info("Get current URl");
        return driver.getCurrentUrl();
    }

}