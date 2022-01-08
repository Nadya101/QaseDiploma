package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteSuiteModal extends BasePage{

    @FindBy(xpath = "//*[contains(text(), 'Delete suite')]")
    private WebElement deleteSuiteButton;

    public DeleteSuiteModal(WebDriver driver) {
        super(driver);
    }

    @Step("Click on 'Delete suite' button on Delete suite page")
    public ProjectPage clickOnConfirmDeleteSuiteButton(){
        deleteSuiteButton.click();
        return new ProjectPage(driver);
    }

}