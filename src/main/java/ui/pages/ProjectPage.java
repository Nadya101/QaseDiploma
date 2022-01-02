package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class ProjectPage extends BasePage {

    @FindBy(id = "create-case-button")
    private WebElement createTestCaseButton;
    @FindBy(xpath = "//*[contains(text(), 'Delete')]")
    private WebElement deleteCaseButton;
    @FindBy(xpath = "//*[@class = 'style_item-2O69D style_delete-3r6xI']")
    private WebElement deleteSuiteButton;
    @FindBy(xpath = "//*[@class='alert-message']")
    private WebElement createSuiteMessage;



    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    public NewTestCasePage clickOnCreateNewCaseButton() {
        waitForElementLocated(driver, createTestCaseButton, 3);
        createTestCaseButton.click();
        return new NewTestCasePage(driver);
    }


    public ProjectPage selectTestCaseByName(String caseName) {
        WebElement caseLine = driver.findElement(By.xpath("//*[contains(text(), 'Case101')]"));
        caseLine.click();
        Actions action = new Actions(driver);
        By selectCaseCheckBox = By.xpath("//*[contains(text(), '" + caseName + "')]/ancestor::*[@class='common_draggable-2vPcC']//input[@type='checkbox']");
        WebElement caseCheckBox = driver.findElement(selectCaseCheckBox);
        action.moveToElement(caseCheckBox).click().perform();
        return this;
    }

    public DeleteCaseModal clickOnDeleteButton() {
        deleteCaseButton.click();
        return new DeleteCaseModal(driver);
    }

    public ProjectPage deleteSuite(String suiteName) {
        WebElement suiteMenu = driver.findElement(By.xpath("//*[@title='"+ suiteName +"']/ancestor::*[@class='common_draggable-2vPcC']//*[@class='fa fa-ellipsis-h']"));
        suiteMenu.click();
        return this;
    }

    public DeleteSuiteModal clickOnDeleteSuiteButton(){
        deleteSuiteButton.click();
        return new DeleteSuiteModal(driver);
    }

    public String getCreateSuiteMessage(){
    return createSuiteMessage.getText();
    }

    public boolean isSuitePresent(String suiteName){
        List<WebElement> suiteTitle = driver.findElements(By.xpath("//*[@title='"+ suiteName +"']"));
        return suiteTitle.size() > 0;
    }

}