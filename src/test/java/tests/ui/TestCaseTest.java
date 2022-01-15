package tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseTest extends BaseTest {

    @Test
    public void createNewTestCaseMandatoryFieldOnlyTest() {
        testCaseSteps.createTestCase(email, password, "ComeMai", "Demo test case");
        Assert.assertEquals(projectPage.getMessage(), "Test case was created successfully!");
    }

    @Test
    public void deleteTestCase() {
        testCaseSteps.deleteTestCase(email, password, "ComeMai", "Demo test case");
        Assert.assertEquals(projectPage.getMessage(), "Test case [" + testCaseSteps.printCode() + "] was successfully deleted");
    }

}