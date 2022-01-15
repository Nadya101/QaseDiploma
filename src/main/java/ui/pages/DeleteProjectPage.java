package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteProjectPage extends BasePage {

    @FindBy(xpath = "//*[@class='btn btn-cancel']")
    private WebElement confirmDeleteButton;

    public DeleteProjectPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on 'Delete project' button on Delete project page" )
    public ProjectsPage confirmDeleteProject() {
        confirmDeleteButton.click();
        return new ProjectsPage(driver);
    }

}