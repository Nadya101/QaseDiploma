package tests.api;

import api.adapters.TestCaseAdapter;
import api.models.TestCase;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j
public class TestCaseApiTest {

    @Description("Test checks if the user can create a new test case via API")
    @Test(description = "Create a new test case", groups = {"API", "smoke"})
    public void createTestCaseTest() {
        TestCase testCase = TestCase.builder()
                .title("CAMERA")
                .description("This is test case")
                .preconditions("This is precondition")
                .postconditions("This is post-condition")
                .severity(2) //Critical
                .priority(1) //High
                .behavior(2) //Positive
                .type(2) //Functional
                .layer(2) //API
                .isFlaky(0) //No
                .automation(2) //automated
                .status(0) //actual
                .build();
        Response response = new TestCaseAdapter().createTestCase("FP9548", testCase);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Description("Checks if the user can get a test case by id via API")
    @Test(description = "Get test case by id", groups = {"API", "smoke"})
    public void getTestCaseByIdTest() {
        TestCase testCase = TestCase.builder()
                .title("CAMERA")
                .description("Case description")
                .build();
        Response responsePost = new TestCaseAdapter().createTestCase("FP9548", testCase);
        Integer id  = responsePost.path("result.id");
        Assert.assertEquals(responsePost.getStatusCode(), 200);

        Response responseGet = new TestCaseAdapter().getTestById("FP9548", id);
        Assert.assertEquals(responseGet.getStatusCode(), 200);
        Assert.assertEquals(responseGet.path("result.title"), "CAMERA");
        Assert.assertEquals(responseGet.path("result.description"), "Case description");
    }

}