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
        Response response = new TestSuiteAdapter().createSuite("FP9548", testSuite);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void getSmokeTestSuiteById() {
        Response response = new TestSuiteAdapter().getSuiteById("COMEMAI", 1);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

}