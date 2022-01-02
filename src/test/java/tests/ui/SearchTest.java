package tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void findExistingProjectByNameTest() {
        loginPage.openLoginPage()
                .login(email, password)
                .clickOnButtonLogin()
                .searchProjectByName("Demo Project");
        Assert.assertTrue(projectsPage.isProjectPresent("Demo Project"));
    }


    @Test
    public void findNonExistingProjectByNameTest() {
        loginPage.openLoginPage()
                .login(email, password)
                .clickOnButtonLogin()
                .searchProjectByName("$$$$$$");
        //assert: message abt not found shows
        Assert.assertFalse(projectsPage.isProjectPresent("$$$$$$"));
    }
}
