package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteTestCaseModal extends BasePage{

    @FindBy(xpath = "//*[@class = 'modal-footer']//*[contains(text(), 'Delete')]")
    private WebElement deleteCaseButton;

    public DeleteTestCaseModal(WebDriver driver) {
        super(driver);
    }

    @Step("Click on 'Delete' button on Delete test case page")
    public ProjectPage clickOnDeleteButton(){
        deleteCaseButton.click();
        return new ProjectPage(driver);
    }



}