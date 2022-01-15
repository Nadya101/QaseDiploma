package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class NewProjectPage extends MenuContainer {

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "inputTitle")
    private WebElement titleInput;
    @FindBy(id = "inputCode")
    private WebElement projectCodeInput;
    @FindBy(id = "inputDescription")
    private WebElement descriptionInput;
    @FindBy(id = "public-access-type")
    private WebElement publicAccessRadioButton;
    @FindBy(id = "private-access-type")
    private WebElement privateAccessRadioButton;
    @FindBy(xpath = "//*[contains(text(), 'Create project')]")
    private WebElement createProjectButton;

    public NewProjectPage openNewProjectPage() {
        openPage(CREATE_PROJECT_URL);
        return this;
    }

    @Step("Generate random project code ")
    public String generateRandomProjectCode() {
        Random random = new Random();
        return String.format("%4d", random.nextInt(10000));
    }

    @Step("Set project name: '{name}' and description: '{description}'")
    public NewProjectPage createNewProject(String name, String description) {
        titleInput.sendKeys(name);
        projectCodeInput.sendKeys(generateRandomProjectCode());
        descriptionInput.sendKeys(description);
        return this;
    }

    @Step("Make project public - '{isPublicProject}'")
    public NewProjectPage makePublicOrPrivateProject(boolean isPublicProject) {
        if (isPublicProject) {
            publicAccessRadioButton.isSelected();
        } else {
            privateAccessRadioButton.isSelected();
        }
        return this;
    }

    @Step("Click on 'Create project' button on New project page")
    public ProjectsPage clickOnCreateProjectButton() {
        createProjectButton.click();
        return new ProjectsPage(driver);
    }

}