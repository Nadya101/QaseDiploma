package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class MenuModal extends MenuContainer {

    public MenuModal(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class, 'fa-sign-out-alt')]")
    private WebElement signOutLink;


    @Step("Click on 'Sign out' button")
    public LoginPage clickOnSignOutLink() {
        log.info("Click on 'Sign out' button.");
        signOutLink.click();
        return new LoginPage(driver);
    }

}