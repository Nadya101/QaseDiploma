package tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuiteTest extends BaseTest {

    @Test
    public void deleteTestSuite() {
     suiteSteps.deleteSuite(email, password, "ComeMai", "TestSuite");
        Assert.assertFalse(projectPage.isSuitePresent("SouceDemo"));
    }

    @Test
    public void updateTestSuite() {
        suiteSteps.updateSuite(email, password, "ComeMai", "Smoke", " test", "New suite name 'Smoke test'");
        Assert.assertEquals(projectPage.getMessage(), "Suite was successfully edited.");
    }

}