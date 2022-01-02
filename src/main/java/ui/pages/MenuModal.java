package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuModal extends MenuContainer {

    public MenuModal(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[contains(@class, 'fa-sign-out-alt')]")
    WebElement signOutLink;


    public LoginPage clickOnSignOutLink(){
        signOutLink.click();
        return new LoginPage(driver);
    }
}
