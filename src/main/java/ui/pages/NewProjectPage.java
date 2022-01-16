package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

@Log4j2
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
        String randomCode = String.format("%4d", random.nextInt(10000));
        log.info(String.format("Generate random code %s.", randomCode));
        return randomCode;
    }

    @Step("Set project name: '{name}' and description: '{description}'")
    public NewProjectPage createNewProject(String name, String description) {
        log.info(String.format("Type text: '%s' into project name input.", name));
        titleInput.sendKeys(name);
        projectCodeInput.sendKeys(generateRandomProjectCode());
        log.info(String.format("Type text: '%s' into description input.", description));
        descriptionInput.sendKeys(description);
        return this;
    }

    @Step("Make project public - '{isPublicProject}'")
    public NewProjectPage makePublicOrPrivateProject(boolean isPublicProject) {
        if (isPublicProject) {
            log.info("Select public access radio button.");
            publicAccessRadioButton.isSelected();
        } else {
            log.info("Select private access radio button.");
            privateAccessRadioButton.isSelected();
        }
        return this;
    }

    @Step("Click on 'Create project' button on New project page")
    public ProjectsPage clickOnCreateProjectButton() {
        log.info("Click on 'Create project' button.");
        createProjectButton.click();
        return new ProjectsPage(driver);
    }

}