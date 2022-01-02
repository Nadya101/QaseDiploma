package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class NewTestCasePage extends BasePage {

    @FindBy(id = "title")
    private WebElement titleInput;
    @FindBy(xpath = "//p[@data-placeholder='For example: We can authorize on page http://example.com/login']")
    private WebElement descriptionInput;
    @FindBy(xpath = "//*[@id='statusGroup']//*[@class=' css-1hwfws3']")
    private WebElement statusDropDown;
    @FindBy(xpath = "//*[@id='suiteGroup']//*[@class=' css-1hwfws3']")
    private WebElement suiteDropDown;
    @FindBy(xpath = "//*[@id='severityGroup']//*[@class=' css-1hwfws3']")
    private WebElement severityDropDown;
    @FindBy(xpath = "//*[@id='priorityGroup']//*[@class=' css-1hwfws3']")
    private WebElement priorityDropDown;
    @FindBy(xpath = "//*[@id='typeGroup']//*[@class=' css-1hwfws3']")
    private WebElement typeDropDown;
    @FindBy(xpath = "//*[@id='layerGroup']//*[@class=' css-1hwfws3']")
    private WebElement layerDropDown;
    @FindBy(xpath = "//*[@id='is_flakyGroup']//*[@class=' css-1hwfws3']")
    private WebElement flakyDropDown;
    @FindBy(xpath = "//*[@id='behaviorGroup']//*[@class=' css-1hwfws3']")
    private WebElement behaviorDropDown;
    @FindBy(xpath = "//*[@id='automationStatusGroup']//*[@class=' css-1hwfws3']")
    private WebElement automationStatusDropDown;
    @FindBy(xpath = "//*[@id='pre-conditionGroup']//*[@class='ProseMirror-container markdown-area wysiwyg']")
    private WebElement preConditionInput;
    @FindBy(xpath = "//*[@id='post-conditionGroup']//*[@class='ProseMirror-container markdown-area wysiwyg']")
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
    private WebElement saveTestCaseButton;

    public NewTestCasePage(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage clickOnSaveButton() {
        saveTestCaseButton.click();
        return new ProjectsPage(driver);
    }

    public NewTestCasePage setTitle(String title) {
        waitForElementLocated(driver, titleInput, 10);
        titleInput.sendKeys(title);
        return this;
    }

    public NewTestCasePage clickOnAddStepsButton() {
       addStepButton.click();
        return this;
    }



    public NewTestCasePage addStepsToReproduce(String action, String inputData, String expectedResult) {
        waitForElementLocated(driver, actionInput, 10);
        actionInput.sendKeys(action);
        actionInput.click();
        inputDataInput.sendKeys(inputData);
        inputDataInput.click();
        expectedResultInput.sendKeys(expectedResult);
        expectedResultInput.click();
        return this;
    }

    public NewTestCasePage setStatus(String status) {
        statusDropDown.sendKeys(status);
        return this;
    }

    public NewTestCasePage setDescription(String description) {
        descriptionInput.click();
        descriptionInput.sendKeys(description);
        descriptionInput.click();
        return this;
    }

    public NewTestCasePage setSeverity(String severity) {
        severityDropDown.click();
        severityDropDown.sendKeys(severity);
        severityDropDown.click();
        return this;
    }

    public NewTestCasePage setPriority(String severity) {
        priorityDropDown.click();
        priorityDropDown.sendKeys(severity);
        priorityDropDown.click();
        return this;
    }

    public NewTestCasePage setType(String type) {
        typeDropDown.click();
        typeDropDown.sendKeys(type);
        typeDropDown.click();
        return this;
    }

    public NewTestCasePage setLayer(String layer) {
        layerDropDown.click();
        layerDropDown.sendKeys(layer);
        layerDropDown.click();
        return this;
    }

    public NewTestCasePage isFlaky(String flaky) {
        flakyDropDown.click();
        flakyDropDown.sendKeys(flaky);
        flakyDropDown.click();
        return this;
    }

    public NewTestCasePage setBehavior(String behavior) {
        behaviorDropDown.click();
        behaviorDropDown.sendKeys(behavior);
        behaviorDropDown.click();
        return this;
    }

    public NewTestCasePage setAutomationStatus(String automationStatus) {
        automationStatusDropDown.click();
        automationStatusDropDown.sendKeys(automationStatus);
        automationStatusDropDown.click();
        return this;
    }

    public NewTestCasePage setPreCondition(String preCondition) {
        preConditionInput.click();
        preConditionInput.sendKeys(preCondition);
        preConditionInput.click();
        return this;
    }

    public NewTestCasePage setPostCondition(String postCondition) {
        postConditionInput.click();
        postConditionInput.sendKeys(postCondition);
        postConditionInput.click();
        return this;
    }

    public NewTestCasePage addParamAndValue(String param, String value) {
        paramTitleInput.sendKeys(param);
        paramTitleInput.click();
        paramValueInput.sendKeys(value);
        paramValueInput.click();
        return this;
    }


}
