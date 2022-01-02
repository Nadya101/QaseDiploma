package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "inputEmail")
    WebElement emailInput;
    @FindBy(id = "inputPassword")
    WebElement passwordInput;
    @FindBy(xpath = "//*[@class = 'custom-control-indicator']")
    WebElement rememberMeCheckBox;
    @FindBy(id = "btnLogin")
    WebElement loginButton;
    @FindBy(xpath = "//*[@class = 'form-control-feedback']")
    WebElement errorMessage;

    public LoginPage openLoginPage() {
        openPage(LOGIN_URL);
        return this;
    }

    public LoginPage login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        rememberMeCheckBox.click();
        return this;
    }

    public ProjectsPage clickOnButtonLogin() {
        loginButton.click();
        return new ProjectsPage(driver);
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

    //HTML5 standard and error message not exist in DOM
    public boolean hasAttributeRequiredAndErrorMessageAppears(){
       emailInput.getAttribute("required");
       return true;
    }

}