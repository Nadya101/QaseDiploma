package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class ProjectsPage extends BasePage {


    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "createButton")
    private WebElement createProjectButton;
    @FindBy(xpath = "//*[@class = 'form-control']")
    private WebElement searchInput;
    @FindAll(@FindBy(xpath = "//*[@class='defect-title']"))
    private List<WebElement> projectsTitle;
    @FindBy(xpath = "//*[@class='dropdown-menu dropdown-menu-end show']//*[@class='text-danger']")
    private WebElement deleteProjectButton;
    @FindBy(xpath = "//*[@class='alert-message']")
    private WebElement projectCreatedMessage;




    public ProjectsPage searchProjectByName(String projectName) {
        searchInput.clear();
        searchInput.sendKeys(projectName);
        searchInput.click();
        return this;
    }


    //think abt label
    public DeleteProjectPage deleteProjectByName(String projectName) {
        By menuDropDown = By.xpath("//*[contains(text(), '" + projectName + "')]/ancestor::tr[@class='project-row']//*[@class ='fa fa-ellipsis-h']");
        waitForElementLocated(driver, menuDropDown, 3);
        WebElement deleteMenu = driver.findElement(menuDropDown);
        deleteMenu.click();
        deleteProjectButton.click();
        return new DeleteProjectPage(driver);
    }

    public ProjectPage openProject(String projectName) {
        By projectTitle = By.xpath("//*[contains(text(), '" + projectName + "')]");
        waitForElementLocated(driver, projectTitle, 3);
        driver.findElement(projectTitle).click();
        return new ProjectPage(driver);
    }


    public String getProjectCreatedMessage(){
        return projectCreatedMessage.getText();
    }

    public boolean isProjectPresent(String projectName) {
        List<WebElement> targetProject = driver.findElements(By.xpath("//*[@class='project-row']//*[contains(text(),'" + projectName + "')]"));
        return !(targetProject.size() <= 0);
    }

}
