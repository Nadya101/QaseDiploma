package tests.api;

import api.adapters.TestSuiteAdapter;
import api.models.TestSuite;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuiteApiTest {

    @Description("Test checks if the user can create a new test suite via API")
    @Test(description = "Create new suite test", groups = {"API", "smoke"})
    public void createTestSuiteTest() {
        TestSuite testSuite = TestSuite.builder()
                .title("Regression test")
                .description("Test suite description.")
                .precondition("Test suite preconditions")
                .parentId(null)
                .build();
        Response response = new TestSuiteAdapter().createSuite("COMEMAI", testSuite);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Description("Checks if the user can get a test suite by id via API")
    @Test(description = "Get test suite by id", groups = {"API", "smoke"})
    public void getTestSuiteByIdTest() {
        TestSuite testSuite = TestSuite.builder()
                .title("Smoke test")
                .description("Test suite description.")
                .precondition("Test suite preconditions")
                .build();
        Response responsePost = new TestSuiteAdapter().createSuite("COMEMAI", testSuite);
        Integer id = responsePost.path("result.id");
        Assert.assertEquals(responsePost.getStatusCode(), 200);

        Response responseGet = new TestSuiteAdapter().getSuiteById("COMEMAI", id);
        Assert.assertEquals(responseGet.getStatusCode(), 200);
        Assert.assertEquals(responseGet.path("result.title"), "Smoke test");
    }

}