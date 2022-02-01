package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waiters.waitForElementLocated;

public class DeleteTestCaseModal extends BasePage{

    @FindBy(xpath = "//*[@class = 'modal-footer']//*[contains(text(), 'Delete')]")
    private WebElement deleteCaseButton;
    @FindBy(xpath = "//*[contains(@class, 'text-danger')]")
    private WebElement exclamationTriangle;

    public DeleteTestCaseModal(WebDriver driver) {
        super(driver);
    }

    @Step("Click on 'Delete' button on Delete test case page")
    public ProjectPage clickOnDeleteButton(){
        waitForElementLocated(driver, exclamationTriangle, 5);
        deleteCaseButton.click();
        return new ProjectPage(driver);
    }



}