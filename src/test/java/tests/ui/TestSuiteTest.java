package tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuiteTest extends BaseTest {

    @Test
    public void deleteTestSuite() {
        String suiteName = "DemoPipeline";
        loginPage.openLoginPage()
                .login(email, password)
                .clickOnButtonLogin()
                .openProject("Five project")
                .deleteSuite(suiteName)
                .clickOnDeleteSuiteButton()
                .clickOnConfirmDeleteSuiteButton()
                .refreshPage();
        Assert.assertFalse(projectPage.isSuitePresent(suiteName));

    }
}
