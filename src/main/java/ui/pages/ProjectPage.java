package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.Waiters.waitForElementLocated;

public class ProjectPage extends BasePage {

    public final String TEST_CASE_NAME_XPATH = "//*[contains(@class, 'style_caseTitle')][contains(text(),'%s')]";
    public final String TRASH_ICON_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@class, " +
            "'style_header')]//*[contains(@class, 'trash')]";
    public final String SUITE_TITLE_XPATH = "//*[@title='%s']";
    public final String PENCIL_ICON_XPATH = "//*[contains(text(), '%s')]/ancestor::*[contains(@class," +
            " 'style_header')]//*[contains(@class, 'pencil')]";


    @FindBy(id = "create-case-button")
    private WebElement createCaseButton;
    @FindBy(xpath = "//*[contains(text(), 'Delete')]")
    private WebElement deleteSuiteButton;
    @FindBy(xpath = "//*[@class='alert-message']")
    private WebElement alertMessage;
    @FindBy(xpath = "//*[@title = 'Delete case']")
    private WebElement deleteCaseButton;
    @FindBy(xpath = "//*[@class= 'preview-code']/a")
    private WebElement previewCode;


    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on '+Case' button on Project page")
    public CreateTestCasePage clickOnCreateCaseButton() {
        waitForElementLocated(driver, createCaseButton, 3);
        createCaseButton.click();
        return new CreateTestCasePage(driver);
    }

    @Step("Select '{caseName}' test case")
    public ProjectPage selectTestCaseByName(String caseName) {
        waitForElementLocated(driver, By.xpath(String.format(TEST_CASE_NAME_XPATH, caseName)), 5);
        driver.findElement(By.xpath(String.format(TEST_CASE_NAME_XPATH, caseName))).click();
        return this;
    }

    public String getCaseCode() {
        waitForElementLocated(driver, previewCode,3);
        return previewCode.getText();
    }

    @Step("Click on 'Delete' button on Project page")
    public DeleteCaseModal clickOnDeleteButton() {
        deleteCaseButton.click();
        return new DeleteCaseModal(driver);
    }

    @Step("Click on 'Delete' button on Project page")
    public DeleteTestCaseModal clickOnDeleteCaseButton() {
        waitForElementLocated(driver, deleteCaseButton, 3);
        deleteCaseButton.click();
        return new DeleteTestCaseModal(driver);
    }

    @Step("Click on trash icon on Project page")
    public ProjectPage clickOnTrashIcon(String suiteName) {
        waitForElementLocated(driver,By.xpath(String.format(TRASH_ICON_XPATH, suiteName)), 5 );
        driver.findElement(By.xpath(String.format(TRASH_ICON_XPATH, suiteName))).click();
        return this;
    }

    @Step("Click on 'Delete suite' button on Project page")
    public DeleteSuiteModal clickOnDeleteSuiteButton() {
        deleteSuiteButton.click();
        return new DeleteSuiteModal(driver);
    }

    public boolean isSuitePresent(String suiteName) {
        List<WebElement> suiteTitle = driver.findElements(By.xpath(String.format(SUITE_TITLE_XPATH, suiteName)));
        return suiteTitle.size() > 0;
    }

    @Step("Click on edit(pencil) icon on Project page")
    public EditSuiteModal clickOnEditIcon(String suiteName) {
        driver.findElement(By.xpath(String.format(PENCIL_ICON_XPATH, suiteName))).click();
        return new EditSuiteModal(driver);
    }

    public String getMessage() {
        waitForElementLocated(driver, alertMessage, 10);
        return alertMessage.getText();
    }

}