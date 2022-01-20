package tests.api;

import api.adapters.ProjectAdapter;
import api.adapters.TestCaseAdapter;
import api.adapters.TestSuiteAdapter;
import api.models.Project;
import api.models.TestCase;
import api.models.TestSuite;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetRequestApiTests {

    @Description("Checks if we can get test suite by id via API")
    @Test(description = "Get test suite by id", groups = {"smoke"})
    public void getTestSuiteByIdTest() {
        TestSuite testSuite = TestSuite.builder()
                .title("Get suite")
                .description("Test suite description")
                .precondition("Test suite preconditions")
                .build();
        Response response = new TestSuiteAdapter().createSuite("TMS3543", testSuite);
        int id = response.path("result.id");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(id > 0);

        Response responseGet = new TestSuiteAdapter().getSuiteById("TMS3543", id);
        Assert.assertEquals(responseGet.getStatusCode(), 200);
        Assert.assertEquals(responseGet.path("result.title"), "Get suite");
    }

    @Description("Checks if we can get test case by id via API")
    @Test(description = "Get test case by id", groups = {"smoke"})
    public void getTestCaseByIdTest() {
        TestCase testCase = TestCase.builder()
                .title("Get case")
                .description("Case description")
                .build();
        Response response = new TestCaseAdapter().createCase("FP9548", testCase);
        Integer id = response.path("result.id");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(id > 0);

        Response responseGet = new TestCaseAdapter().getCaseById("FP9548", id);
        Assert.assertEquals(responseGet.getStatusCode(), 200);
        Assert.assertEquals(responseGet.path("result.title"), "Get case");
        Assert.assertEquals(responseGet.path("result.description"), "Case description");
    }

    @Description("Checks if we can create project and get it by code via API")
    @Test(description = "Create project and get it by code via API", groups = {"smoke"})
    public void getProjectByCodeTest() {
        Project project = Project.builder()
                .title("Get project")
                .code("NB101")
                .description("This is public project")
                .build();
        Response response = new ProjectAdapter().createProject(project);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.path("result.code"), "NB101");

        Response responseGet = new ProjectAdapter().getProjectByCode("NB101");
        Assert.assertEquals(responseGet.getStatusCode(), 200);
        Assert.assertEquals(responseGet.path("result.title"), "Get project");
        Assert.assertEquals(responseGet.path("result.code"), "NB101");

        Response responseDelete = new ProjectAdapter().deleteProjectByCode("NB101");
        Assert.assertEquals(responseDelete.getStatusCode(), 200);
    }

}