package tests.api;

import api.adapters.TestSuiteAdapter;
import api.models.TestSuite;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuiteApiTest {

    @Test
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

    @Test
    public void getSmokeTestSuiteByIdTest() {
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