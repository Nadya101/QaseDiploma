package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.Waiters.waitForElementLocated;


public class ProjectsPage extends BasePage {

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "createButton")
    private WebElement createProjectButton;
    @FindBy(xpath = "//input[contains(@class, 'search-input')]")
    private WebElement searchInput;
    @FindAll(@FindBy(xpath = "//*[@class='defect-title']"))
    private List<WebElement> projectsTitle;
    @FindBy(xpath = "//*[contains(@class, 'no-project')]")
    private WebElement noSuchProjectMessage;
    @FindBy(xpath = "//*[@class='dropdown-menu dropdown-menu-end show']//*[@class='text-danger']")
    private WebElement deleteProjectButton;
    @FindBy(xpath = "//*[@class='alert-message']")
    private WebElement projectCreatedMessage;


    @Step("Find project by name '{projectName}'")
    public ProjectsPage searchProjectByName(String projectName) {
        waitForElementLocated(driver, searchInput, 4);
        searchInput.clear();
        searchInput.sendKeys(projectName);
        searchInput.click();
        return this;
    }

    @Step("Click on '{name}' project's menu on Projects page")
    public ProjectsPage openProjectMenu(String name) {
        By menuDropDown = By.xpath(String.format("//*[contains(text(), '%s')]/ancestor::tr[@class='project-row']" +
                "//*[@class ='fa fa-ellipsis-h']", name));
        waitForElementLocated(driver, menuDropDown, 3);
        driver.findElement(menuDropDown).click();
        return this;
    }

    @Step("Click 'Delete' button on Projects page")
    public DeleteProjectPage clickOnDeleteProjectButton() {
        deleteProjectButton.click();
        return new DeleteProjectPage(driver);
    }


    @Step("Open '{name}' project")
    public ProjectPage openProject(String name) {
        By projectTitle = By.xpath(String.format("//*[contains(text(), '%s')]", name));
        waitForElementLocated(driver, projectTitle, 3);
        driver.findElement(projectTitle).click();
        return new ProjectPage(driver);
    }

    public boolean isProjectPresent(String name) {
        waitForElementLocated(driver, By.xpath(String.format("//*[@class='project-row']" +
                "//*[contains(text(),'%s')]", name)), 5);
        List<WebElement> targetProject = driver.findElements(By.xpath(String.format("//*[@class='project-row']" +
                "//*[contains(text(),'%s')]", name)));
        return !(targetProject.size() <= 0);
    }

    public String getNoSuchProjectMessage() {
        waitForElementLocated(driver, noSuchProjectMessage, 5);
        return noSuchProjectMessage.getText();
    }

}