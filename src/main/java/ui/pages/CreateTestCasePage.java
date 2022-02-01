package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waiters.waitForElementLocated;

@Log4j2
public class CreateTestCasePage extends BasePage {

    @FindBy(id = "title")
    private WebElement titleInput;
    @FindBy(xpath = "//p[contains(@data-placeholder, 'We can authorize on page')]")
    private WebElement descriptionInput;
    @FindBy(xpath = "//*[@id='statusGroup']//*[contains(text(), 'Actual')]")
    private WebElement statusDropDown;
    @FindBy(xpath = "//*[@id='suiteGroup']//*[contains(text(), 'Test cases without suite')]")
    private WebElement suiteDropDown;
    @FindBy(xpath = "//*[@id='severityGroup']//*[contains(text(), 'Normal')]")
    private WebElement severityDropDown;
    @FindBy(xpath = "//*[@id='priorityGroup']//*[contains(text(), 'Not set')]")
    private WebElement priorityDropDown;
    @FindBy(xpath = "//*[@id='typeGroup']//*[contains(text(), 'Other')]")
    private WebElement typeDropDown;
    @FindBy(xpath = "//*[@id='layerGroup']//*[contains(text(), 'Unknown')]")
    private WebElement layerDropDown;
    @FindBy(xpath = "//*[@id='is_flakyGroup']//*[contains(text(), 'No')]")
    private WebElement flakyDropDown;
    @FindBy(xpath = "//*[@id='behaviorGroup']//*[contains(text(), 'Not set')]")
    private WebElement behaviorDropDown;
    @FindBy(xpath = "//*[@id='automationStatusGroup']//*[contains(text(), 'Not automated')]")
    private WebElement automationStatusDropDown;
    @FindBy(xpath = "//*[@id='pre-conditionGroup']//*[contains(@class, 'ProseMirror-container markdown-area')]")
    private WebElement preConditionInput;
    @FindBy(xpath = "//*[@id='post-conditionGroup']//*[contains(@class, 'ProseMirror-container markdown-area')]")
    private WebElement postConditionInput;
    @FindBy(xpath = "//*[contains(@class, 'btn-invisible btn-primary')]")
    private WebElement addParamButton;
    @FindBy(xpath = "//*[@class='quick-input']")
    private WebElement paramTitleInput;
    @FindBy(xpath = "//*[@name='param-value']")
    private WebElement paramValueInput;
    @FindBy(xpath = "//*[@id ='add-step']")
    private WebElement addStepButton;
    @FindBy(xpath = "//*[@id='action[0]Group']//*[@class='ProseMirror toastui-editor-contents']")
    private WebElement actionInput;
    @FindBy(xpath = "//*[@id='data[0]Group']//*[@class='ProseMirror toastui-editor-contents']")
    private WebElement inputDataInput;
    @FindBy(xpath = "//*[@id='expected_result[0]Group']//*[@class='ProseMirror toastui-editor-contents']")
    private WebElement expectedResultInput;
    @FindBy(xpath = "//*[@id='save-case']")
    private WebElement saveButton;

    public CreateTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Step("Set title '{title}' to case")
    public CreateTestCasePage setTitle(String title) {
        waitForElementLocated(driver, titleInput, 5);
        log.info("Clear input field.");
        titleInput.clear();
        log.info(String.format("Type text: '%s' into title input.", title));
        titleInput.sendKeys(title);
        return this;
    }

    @Step("Click on 'Save' button on Create test case page")
    public ProjectPage clickOnSaveButton() {
        waitForElementLocated(driver, saveButton, 5);
        log.info("Click on 'Save' button");
        saveButton.click();
        return new ProjectPage(driver);
    }

}