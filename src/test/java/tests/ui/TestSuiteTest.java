package tests.ui;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class TestSuiteTest extends BaseTest {

    @Description("Test checks if the user can delete a test suite")
    @Test(description = "Delete test suite", groups = {"smoke"})
    public void deleteTestSuiteTest() {
     suiteSteps.deleteSuite(email, password, "ComeMai", "TestSuite");
        Assert.assertFalse(projectPage.isSuitePresent("SouceDemo"));
    }

    @Description("Test checks if the user can update a test suite")
    @Test(description = "Update test suite", groups = {"smoke"})
    public void updateTestSuiteTest() {
        suiteSteps.updateSuite(email, password, "ComeMai", "POST", " test", "New suite name 'Smoke test'");
        Assert.assertEquals(projectPage.getMessage(), "Suite was successfully edited.");
    }

}