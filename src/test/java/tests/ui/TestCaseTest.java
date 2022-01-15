package tests.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.utils.Retry;

public class TestCaseTest extends BaseTest {

    @Description("Test checks if the user can create a new test case with required fields only")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Create new test case", groups = {"test case"}, retryAnalyzer = Retry.class)
    public void createNewTestCaseMandatoryFieldOnlyTest() {
        testCaseSteps.createTestCase(email, password, "ComeMai", "Demo test case");
        Assert.assertEquals(projectPage.getMessage(), "Test case was created successfully!");
    }

    @Description("Test checks if the user can delete a test case")
    @Test(description = "Delete test case", groups = {"test case"})
    public void deleteTestCaseTest() {
        testCaseSteps.deleteTestCase(email, password, "ComeMai", "Demo test case");
        Assert.assertEquals(projectPage.getMessage(), "Test case [" + testCaseSteps.printCode() + "] was successfully deleted");
    }

}