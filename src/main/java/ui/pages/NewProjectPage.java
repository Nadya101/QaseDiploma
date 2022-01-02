package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class NewProjectPage extends MenuContainer {
    Select select;

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "inputTitle")
    WebElement titleInput;
    @FindBy(id = "inputCode")
    WebElement projectCodeInput;
    @FindBy(id = "inputDescription")
    WebElement descriptionInput;
    @FindBy(id = "public-access-type")
    WebElement publicAccessRadioButton;
    @FindBy(id = "private-access-type")
    WebElement privateAccessRadioButton;
    @FindBy(xpath = "//*[contains(text(), 'Create project')]")
    WebElement createProjectButton;

    public NewProjectPage openNewProjectPage() {
        openPage(CREATE_PROJECT_URL);
        return this;
    }

    public String createRandomProjectCode() {
        Random random = new Random();
        return String.format("%4d", random.nextInt(10000));
    }

    public NewProjectPage createNewProject(String projectName, String projectCode, String description) {
        titleInput.sendKeys(projectName);
        projectCodeInput.sendKeys(projectCode);
        descriptionInput.sendKeys(description);
        return this;
    }

    public NewProjectPage makePublicProject(boolean isPublicProject) {
        if (isPublicProject) {
            publicAccessRadioButton.isSelected();
            System.out.println("select public");
        } else {
            privateAccessRadioButton.isSelected();
            System.out.println("select private");
        }
        return this;
    }

    public ProjectsPage clickOnCreateProjectButton() {
        createProjectButton.click();
        return new ProjectsPage(driver);
    }

}