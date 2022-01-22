package tests.ui;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

public class SignOutTest extends BaseTest {

    @Description("Test checks if the user can log out of the system")
    @Test(description = "Sigh out user", groups = {"smoke"})
    public void signOutUserTest() {
        loginPage.openLoginPage()
                .login(System.getProperty("EMAIL", PropertyReader.getProperty("EMAIL")),
                        System.getProperty("PASSWORD", PropertyReader.getProperty("PASSWORD")));
        String url = menuModal.openMenu()
                .clickOnSignOutLink()
                .getUrl();
        Assert.assertEquals(url, "https://app.qase.io/login");
    }

}