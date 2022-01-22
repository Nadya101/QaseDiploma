package tests.ui;

import api.adapters.TestCaseAdapter;
import api.models.TestCase;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.utils.Retry;

public class TestCaseTest extends BaseTest {

    @Description("Test checks if the user can create a new test case with required fields only")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Create new test case", groups = {"critical"})
    public void createNewTestCaseMandatoryFieldOnlyTest() {
        testCaseSteps.createTestCase(email, password, "ComeMai", "Demo test case");
        Assert.assertEquals(projectPage.getMessage(), "Test case was created successfully!");
    }

    @Description("Test checks if the user can delete a test case")
    @Test(description = "Create test case via API and delete it via UI", groups = {"smoke"}, retryAnalyzer = Retry.class)
    public void deleteTestCaseTest() {
        TestCase testCase = TestCase.builder()
                .title("Delete test")
                .description("This is test case description")
                .build();
        Response response = new TestCaseAdapter().createCase("TMS3543", testCase);
        boolean status = response.path("status");
        int id = response.path("result.id");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(status);
        Assert.assertTrue(id > 0);

        testCaseSteps.deleteTestCase(email, password, "TMS", "Delete test");
        Assert.assertEquals(projectPage.getMessage(), "Test case [" + testCaseSteps.printCode() + "] was successfully deleted");
    }

    @Description("Checks if the user can update a test case ")
    @Test(description = "Create test case via API and update it via UI", groups = {"smoke"}, retryAnalyzer = Retry.class)
    public void updateTestCaseTest() {
        TestCase testCase = TestCase.builder()
                .title("Update test")
                .description("Case description")
                .build();
        Response response = new TestCaseAdapter().createCase("TMS3543", testCase);
        boolean status = response.path("status");
        int id = response.path("result.id");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(status);
        Assert.assertTrue(id > 0);

        testCaseSteps.updateTestCase(email, password, "TMS", "Update test", "Edited test");
        Assert.assertEquals(projectPage.getMessage(),  "Test case was edited successfully!");

        Response responseDelete = new TestCaseAdapter().deleteCase("TMS3543", id);
        Assert.assertEquals(responseDelete.getStatusCode(), 200);
    }

}