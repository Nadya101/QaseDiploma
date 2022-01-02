package tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.constants.IConstants;

public class LoginTest extends BaseTest implements IConstants {

    @Test
    public void loginUserWithValidDataTest() {
        String url = loginPage.openLoginPage()
                .login(email, password)
                .clickOnButtonLogin()
                .getUrl();
        Assert.assertEquals(url, "https://app.qase.io/projects");
    }

    @Test
    public void loginUserWithInvalidDataTest() {
        loginPage.openLoginPage()
                .login("none@yandex.by", "Q111111475zxcv")
                .clickOnButtonLogin();
        Assert.assertEquals(loginPage.getErrorMessage(), "These credentials do not match our records.");
    }


    @Test
    public void loginUserWithEmptyFieldsTest() {
        loginPage.openLoginPage()
                .login("", "")
                .clickOnButtonLogin();
        Assert.assertTrue(loginPage.hasAttributeRequiredAndErrorMessageAppears());
    }

}