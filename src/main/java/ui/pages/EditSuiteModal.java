package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSuiteModal extends BasePage {

    @FindBy(xpath = "//*[contains(text(), 'Description')]/ancestor::*[@class='form-group']/input")
    private WebElement descriptionInput;
    @FindBy(xpath = "//*[contains(text(), 'Suite name')]/ancestor::*[@class='form-group']/input")
    private WebElement suiteNameInput;
    @FindBy(id = "save-suite-button")
    private WebElement saveButton;

    public EditSuiteModal(WebDriver driver) {
        super(driver);
    }

    @Step("Rename suite to '{name}'")
    public EditSuiteModal changeSuiteName(String name) {
        suiteNameInput.sendKeys(name);
        return this;
    }

    @Step("Add suite description")
    public EditSuiteModal addSuiteDescription(String text) {
        descriptionInput.sendKeys(text);
        return this;
    }

    @Step("Click on 'Save' button on Edit suite page")
    public ProjectPage clickOnSaveButton() {
       saveButton.click();
        return new ProjectPage(driver);
    }

}