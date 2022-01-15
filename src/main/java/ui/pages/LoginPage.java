package ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        rememberMeCheckBox.click();
        clickOnButtonLogin();
        return new ProjectsPage(driver);
    }


    @Step("Click 'Login' button on Login page")
    public void clickOnButtonLogin() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

}