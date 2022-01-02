package tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignOutTest extends BaseTest {

    @Test
    public void signOutUserTest() {
        loginPage.openLoginPage()
                .login(email, password)
                .clickOnButtonLogin();
        String url = menuModal.openMenu()
                .clickOnSignOutLink()
                .getUrl();
        Assert.assertEquals(url, "https://app.qase.io/login");
    }

}