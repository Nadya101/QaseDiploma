package ui.pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "inputEmail")
    private WebElement emailInput;
    @FindBy(id = "inputPassword")
    private WebElement passwordInput;
    @FindBy(xpath = "//*[@class = 'custom-control-indicator']")
    private WebElement rememberMeCheckBox;
    @FindBy(id = "btnLogin")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@class = 'form-control-feedback']")
    private WebElement errorMessage;


    public LoginPage openLoginPage() {
        openPage(LOGIN_URL);
        return this;
    }

    @Step("Login as username: '{email}' and password: '{password}'")
    public ProjectsPage login(String email, String password) {
        log.info(String.format("Type text: '%s into username input.", email));
        emailInput.sendKeys(email);
        log.info(String.format("Type text: '%s' into password  input.", password));
        passwordInput.sendKeys(password);
        log.info("Select 'Remember me' check box.");
        rememberMeCheckBox.click();
        clickOnButtonLogin();
        return new ProjectsPage(driver);
    }


    @Step("Click 'Login' button on Login page")
    public void clickOnButtonLogin() {
        log.info("Click on 'Login' button.");
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

}