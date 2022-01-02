package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteCaseModal extends BasePage{
    @FindBy(xpath = "//*[@name='confirm']")
    WebElement confirmInput;
    @FindBy(xpath = "//*[@class='btn btn-danger']")
    WebElement deleteButton;

    DeleteCaseModal(WebDriver driver) {
        super(driver);
    }


    public DeleteCaseModal typeConfirmDelete(){
        confirmInput.sendKeys("CONFIRM");
        return this;
    }

    public ProjectPage clickOnDeleteButton(){
        deleteButton.click();
        return new ProjectPage(driver);
    }

}