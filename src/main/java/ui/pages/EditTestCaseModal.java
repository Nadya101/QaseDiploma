package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waiters.waitForElementLocated;

@Log4j2
public class EditTestCaseModal extends BasePage {
    @FindBy(id = "title")
    private WebElement titleInput;
    @FindBy(xpath = "//*[@id='save-case']")
    private WebElement saveButton;

    EditTestCaseModal(WebDriver driver) {
        super(driver);
    }

    @Step("Change test case title to '{title}'")
    public EditTestCaseModal changeCaseTitle(String title) {
        waitForElementLocated(driver, titleInput, 5);
        log.info("Clear test case title input.");
        titleInput.clear();
        log.info(String.format("Type text: '%s' into title  input.", title));
        titleInput.sendKeys(title);
        return this;
    }

    @Step("Click on 'Save' button on Edit test case page")
    public ProjectPage clickOnSaveButton() {
        log.info("Click on 'Save' button.");
        saveButton.click();
        return new ProjectPage(driver);
    }

}