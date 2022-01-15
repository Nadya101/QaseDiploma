package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static utils.Waiters.waitForElementLocated;

@Log4j2
public class ProjectsPage extends BasePage {

    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public final String PROJECT_MENU_XPATH = "//*[contains(text(), '%s')]/ancestor::tr[@class='project-row']" +
            "//*[@class ='fa fa-ellipsis-h']";
    public final String PROJECT_NAME_XPATH = "//*[contains(text(), '%s')]";
    public final String DEMO_PROJECT_XPATH = "//*[contains(text(), 'Demo Project')]/ancestor::tr[@class='project-row']//*[@class ='fa fa-ellipsis-h']";
    public final String TARGET_PROJECT_XPATH = "//*[@class='project-row']" +
            "//*[contains(text(),'%s')]";


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
        log.info(String.format("Type text: '%s' into search box.", projectName));
        searchInput.sendKeys(projectName);
        log.info("Click on 'Search input'.");
        searchInput.click();
        return this;
    }

    @Step("Click on '{name}' project's menu on Projects page")
    public ProjectsPage openProjectMenu(String name) {
        By menuDropDown = By.xpath(String.format(PROJECT_MENU_XPATH, name));
        waitForElementLocated(driver, menuDropDown, 3);
        log.info(String.format("Click on '%s' project's menu dropdown.", name));
        driver.findElement(menuDropDown).click();
        return this;
    }

    @Step("Click 'Delete' button on Projects page")
    public DeleteProjectPage clickOnDeleteProjectButton() {
        log.info("Click on 'Delete' button.");
        deleteProjectButton.click();
        return new DeleteProjectPage(driver);
    }

    @Step("Open '{name}' project")
    public ProjectPage openProject(String name) {
        By projectTitle = By.xpath(String.format(PROJECT_NAME_XPATH, name));
        waitForElementLocated(driver, projectTitle, 3);
        log.info(String.format("Click on '%s' project.", name));
        driver.findElement(projectTitle).click();
        return new ProjectPage(driver);
    }

    public boolean isProjectPresent(String name) {
      waitForElementLocated(driver, By.xpath(DEMO_PROJECT_XPATH), 5);
      log.info(String.format("Find a list of '%s' projects.", name));
        List<WebElement> targetProject = driver.findElements(By.xpath(String.format(TARGET_PROJECT_XPATH, name)));
        return !(targetProject.size() <= 0);
    }

    public String getNoSuchProjectMessage() {
        waitForElementLocated(driver, noSuchProjectMessage, 5);
        return noSuchProjectMessage.getText();
    }

}