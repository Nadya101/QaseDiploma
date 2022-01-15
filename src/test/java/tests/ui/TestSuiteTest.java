package tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuiteTest extends BaseTest {

    @Test
    public void deleteTestSuiteTest() {
     suiteSteps.deleteSuite(email, password, "ComeMai", "TestSuite");
        Assert.assertFalse(projectPage.isSuitePresent("SouceDemo"));
    }

    @Test
    public void updateTestSuiteTest() {
        suiteSteps.updateSuite(email, password, "ComeMai", "POST", " test", "New suite name 'Smoke test'");
        Assert.assertEquals(projectPage.getMessage(), "Suite was successfully edited.");
    }

}