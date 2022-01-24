package tests.ui;

import api.adapters.TestSuiteAdapter;
import api.models.TestSuite;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;

@Log4j2
public class TestSuiteTest extends BaseTest {

    @Description("Test checks if the user can delete a test suite")
    @Test(description = "Create test suite via API and delete it via UI", groups = {"smoke"})
    public void deleteSuiteTest() {
        TestSuite testSuite = TestSuite.builder()
                .title("Create suite")
                .description("Test suite description")
                .precondition("Test suite preconditions")
                .build();
        Response response = new TestSuiteAdapter().createSuite("TMS3543", testSuite);
        int id = response.path("result.id");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(id > 0);

        suiteSteps.deleteSuite(System.getProperty("EMAIL", PropertyReader.getProperty("EMAIL")),
                               System.getProperty("PASSWORD", PropertyReader.getProperty("PASSWORD")),
                "TMS", "Create suite");
        Assert.assertEquals(projectPage.getMessage(), "Suite was successfully deleted.");
    }


    @Description("Test checks if the user can update a test suite")
    @Test(description = "Update test suite", groups = {"smoke"})
    public void updateSuiteTest() {
        TestSuite testSuite = TestSuite.builder()
                .title("Update")
                .description("Test suite description.")
                .precondition("Test suite preconditions")
                .build();
        Response response = new TestSuiteAdapter().createSuite("TMS3543", testSuite);
        int id = response.path("result.id");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(id > 0);

        suiteSteps.updateSuite(System.getProperty("EMAIL", PropertyReader.getProperty("EMAIL")),
                               System.getProperty("PASSWORD", PropertyReader.getProperty("PASSWORD")),
                "TMS", "Update", " suite", "New suite name 'Update suite'");
        Assert.assertEquals(projectPage.getMessage(), "Suite was successfully edited.");

        Response responseDelete = new TestSuiteAdapter().deleteSuite("TMS3543", id);
        Assert.assertEquals(responseDelete.getStatusCode(), 200);
    }

}