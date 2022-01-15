package ui.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class DeleteCaseModal extends BasePage {
    @FindBy(xpath = "//*[@name='confirm']")
    private WebElement confirmInput;
    @FindBy(xpath = "//*[@class='btn btn-danger']")
    private WebElement deleteButton;

    DeleteCaseModal(WebDriver driver) {
        super(driver);
    }

    public DeleteCaseModal clickDeleteButton() {
        log.info("Type text: 'CONFIRM' into confirm delete input");
        confirmInput.sendKeys("CONFIRM");
        return this;
    }

}