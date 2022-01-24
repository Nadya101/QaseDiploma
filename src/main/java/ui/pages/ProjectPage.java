package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waiters.waitForElementLocated;

@Log4j2
public class ProjectPage extends BasePage {

    public final String TEST_CASE_NAME_XPATH = "//*[contains(text(), '%s')]";
    public final String TRASH_ICON_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@class, " +
            "'style_header')]//*[contains(@class, 'trash')]";
    public final String SUITE_PENCIL_ICON_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@class," +
            " 'style_header')]//*[contains(@class, 'pencil')]";
    public final String HAND_ICON_XPATH = "//*[@title= 'Not automated']";

    @FindBy(id = "create-case-button")
    private WebElement createCaseButton;
    @FindBy(xpath = "//*[contains(text(), 'Delete suite')]")
    private WebElement deleteSuiteButton;
    @FindBy(xpath = "//*[@class='alert-message']")
    private WebElement alertMessage;
    @FindBy(xpath = "//*[@title='Delete case']")
    private WebElement deleteCaseButton;
    @FindBy(xpath = "//*[contains(@class, 'style_code')]")
    private WebElement previewCode;
    @FindBy(xpath = "//*[contains(@title, 'Test cases without suite')]")
    private WebElement casesList;
    @FindBy(xpath = "//*[@title='Edit case']")
    private WebElement editCaseButton;

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on '+Case' button on Project page")
    public CreateTestCasePage clickOnCreateCaseButton() {
        waitForElementLocated(driver, createCaseButton, 5);
        log.info("Click on 'Create case' button.");
        createCaseButton.click();
        return new CreateTestCasePage(driver);
    }

    @Step("Open list of test cases")
    public ProjectPage openCasesList() {
        waitForElementLocated(driver, casesList, 5);
        log.info("Click on 'Test cases without suite' for open list of cases.");
        casesList.click();
        return this;
    }

    @Step("Select '{caseName}' test case")
    public ProjectPage selectTestCaseByName(String caseName) {
        waitForElementLocated(driver, By.xpath(HAND_ICON_XPATH), 5);
        log.info(String.format("Select '%s' test case", caseName));
        driver.findElement(By.xpath(String.format(TEST_CASE_NAME_XPATH, caseName))).click();
        return this;
    }

    public String getCaseCode() {
        String code = previewCode.getText();
        log.info(String.format("Case code is '%s'", code));
        return code;
    }

    @Step("Click on 'Delete' button on Project page")
    public DeleteTestCaseModal clickOnDeleteCaseButton() {
        waitForElementLocated(driver, deleteCaseButton, 10);
        log.info("Click on 'Delete case' button");
        deleteCaseButton.click();
        return new DeleteTestCaseModal(driver);
    }

    @Step("Click on trash icon on Project page")
    public ProjectPage clickOnTrashIcon(String suiteName) {
        waitForElementLocated(driver, By.xpath(String.format(TRASH_ICON_XPATH, suiteName)), 5);
        log.info(String.format("Click on trash icon of %s suite case", suiteName));
        driver.findElement(By.xpath(String.format(TRASH_ICON_XPATH, suiteName))).click();
        return this;
    }

    @Step("Click on 'Delete suite' button on Project page")
    public DeleteSuiteModal clickOnDeleteSuiteButton() {
        waitForElementLocated(driver, deleteSuiteButton, 5);
        log.info("Click on 'Delete suite' button");
        deleteSuiteButton.click();
        return new DeleteSuiteModal(driver);
    }

    @Step("Click on edit (pencil) suite on Project page")
    public EditSuiteModal clickOnEditSuiteIcon(String suiteName) {
        waitForElementLocated(driver, By.xpath(String.format(SUITE_PENCIL_ICON_XPATH, suiteName)), 5);
        log.info(String.format("Click on edit (pencil) icon of '%s' suite case.", suiteName));
        driver.findElement(By.xpath(String.format(SUITE_PENCIL_ICON_XPATH, suiteName))).click();
        return new EditSuiteModal(driver);
    }

    @Step("Click on 'Edit' test case button on Project page")
    public EditTestCaseModal clickOnEditTestCaseButton() {
        waitForElementLocated(driver, editCaseButton, 10);
        log.info("Click on 'Edit' case button.");
        editCaseButton.click();
        return new EditTestCaseModal(driver);
    }

    public String getMessage() {
        waitForElementLocated(driver, alertMessage, 10);
        return alertMessage.getText();
    }

}