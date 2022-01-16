package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.Waiters.waitForElementLocated;

@Log4j2
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
        log.info("Click on 'Create case' button");
        createCaseButton.click();
        return new CreateTestCasePage(driver);
    }

    @Step("Select '{caseName}' test case")
    public ProjectPage selectTestCaseByName(String caseName) {
        waitForElementLocated(driver, By.xpath(String.format(TEST_CASE_NAME_XPATH, caseName)), 5);
        log.info(String.format("Click on '%s' test case.", caseName));
        driver.findElement(By.xpath(String.format(TEST_CASE_NAME_XPATH, caseName))).click();
        return this;
    }

    public String getCaseCode() {
        waitForElementLocated(driver, previewCode,3);
        return previewCode.getText();
    }

    @Step("Click on 'Delete' button on Project page")
    public DeleteTestCaseModal clickOnDeleteCaseButton() {
        waitForElementLocated(driver, deleteCaseButton, 3);
        log.info("Click on 'Delete case' button");
        deleteCaseButton.click();
        return new DeleteTestCaseModal(driver);
    }

    @Step("Click on trash icon on Project page")
    public ProjectPage clickOnTrashIcon(String suiteName) {
        waitForElementLocated(driver,By.xpath(String.format(TRASH_ICON_XPATH, suiteName)), 5 );
        log.info(String.format("Click on trash icon of %s suite case", suiteName));
        driver.findElement(By.xpath(String.format(TRASH_ICON_XPATH, suiteName))).click();
        return this;
    }

    @Step("Click on 'Delete suite' button on Project page")
    public DeleteSuiteModal clickOnDeleteSuiteButton() {
        log.info("Click on 'Delete suite' button");
        deleteSuiteButton.click();
        return new DeleteSuiteModal(driver);
    }

    public boolean isSuitePresent(String suiteName) {
        List<WebElement> suiteTitle = driver.findElements(By.xpath(String.format(SUITE_TITLE_XPATH, suiteName)));
        boolean isSuitePresent = suiteTitle.size() > 0;
        log.info(String.format("It is '%s' that suite case present.", isSuitePresent));
        return isSuitePresent;
    }

    @Step("Click on edit (pencil) icon on Project page")
    public EditSuiteModal clickOnEditIcon(String suiteName) {
        log.info(String. format("Click on edit (pencil) icon of '%s' suite case.", suiteName));
        driver.findElement(By.xpath(String.format(PENCIL_ICON_XPATH, suiteName))).click();
        return new EditSuiteModal(driver);
    }

    public String getMessage() {
        waitForElementLocated(driver, alertMessage, 10);
        return alertMessage.getText();
    }

}