package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteCaseModal extends BasePage {
    @FindBy(xpath = "//*[@name='confirm']")
    private WebElement confirmInput;
    @FindBy(xpath = "//*[@class='btn btn-danger']")
    private WebElement deleteButton;

    DeleteCaseModal(WebDriver driver) {
        super(driver);
    }

    public DeleteCaseModal clickDeleteButton() {
        confirmInput.sendKeys("CONFIRM");
        return this;
    }

}