package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteProjectPage extends BasePage {

    @FindBy(xpath = "//*[@class='btn btn-cancel']")
    WebElement confirmDeleteButton;

    public DeleteProjectPage (WebDriver driver) {
        super(driver);
    }

    public ProjectsPage confirmDeleteProject(){
        confirmDeleteButton.click();
       return new ProjectsPage(driver);
    }
}
