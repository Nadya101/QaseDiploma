package tests.ui;

import io.qameta.allure.Description;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.utils.Retry;

public class LoginTest extends BaseTest {

    @Description("Test checks if the user can log in with valid data")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Login user with valid data", groups = {"login", "smoke"}, retryAnalyzer = Retry.class)
    public void loginUserWithValidDataTest() {
        String url = loginPage.openLoginPage()
                .login(EMAIL, PASSWORD)
                .getUrl();
        Assert.assertEquals(url, "https://app.qase.io/projects");
    }

    @Description("Test checks if the user cannot log in with invalid data")
    @Test(description = "Login user with in valid data", groups = {"login", "smoke"})
    public void loginUserWithInvalidDataTest() {
        loginPage.openLoginPage()
                .login("none@yandex.by", "Q111111475zxcv");
        Assert.assertEquals(loginPage.getErrorMessage(), "These credentials do not match our records.");
    }

    @Description("Test checks if the user cannot log in by submitting a form with empty fields")
    @Test(description = "Login user with in empty fields", groups = {"login", "smoke"})
    public void loginUserWithEmptyFieldsTest() {
        String url = loginPage.openLoginPage()
                .login("", "")
                .getUrl();
        Assert.assertEquals(url, "https://app.qase.io/login");
    }

}