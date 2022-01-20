package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utils.Waiters.waitForElementLocated;

@Log4j2
public class DeleteSuiteModal extends BasePage{

    public final String EXCLAMATION_TRIANGLE_XPATH = "//*[contains(@class, 'text-danger')]";

    @FindBy(xpath = "//*[contains(text(), 'Delete suite')]")
    private WebElement deleteSuiteButton;

    public DeleteSuiteModal(WebDriver driver) {
        super(driver);
    }

    @Step("Click on 'Delete suite' button on Delete suite page")
    public ProjectPage clickOnConfirmDeleteSuiteButton(){
        waitForElementLocated(driver, By.xpath(EXCLAMATION_TRIANGLE_XPATH), 5);
        log.info("Click on 'Delete suite' button to confirm deleting.");
        deleteSuiteButton.click();
        return new ProjectPage(driver);
    }

}