package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
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
        log.info(String.format("Type text: '%s' into suite name input.", name));
        suiteNameInput.sendKeys(name);
        return this;
    }

    @Step("Add suite description: '{text}'")
    public EditSuiteModal addSuiteDescription(String description) {
        log.info(String.format("Type text: '%s' into suite description input.", description));
        descriptionInput.sendKeys(description);
        return this;
    }

    @Step("Click on 'Save' button on Edit suite page")
    public ProjectPage clickOnSaveButton() {
        log.info("Click on 'Save' button.");
        saveButton.click();
        return new ProjectPage(driver);
    }

}