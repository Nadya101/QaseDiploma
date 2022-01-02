package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteSuiteModal extends BasePage{

    @FindBy(xpath = "//*[@class = 'btn btn-danger']")
    WebElement deleteSuiteButton;

    public DeleteSuiteModal(WebDriver driver) {
        super(driver);
    }
    public ProjectPage clickOnConfirmDeleteSuiteButton(){
        deleteSuiteButton.click();
        return new ProjectPage(driver);
    }
}
