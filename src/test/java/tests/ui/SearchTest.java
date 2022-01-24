package tests.ui;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyReader;


public class SearchTest extends BaseTest {

    @Description("Test checks if the user can find an existing project through the search box")
    @Test(description = "Search existing project by name", groups = {"smoke"})
    public void searchExistingProjectByNameTest() {
        projectSteps.searchProject(System.getProperty("EMAIL", PropertyReader.getProperty("EMAIL")),
                System.getProperty("PASSWORD", PropertyReader.getProperty("PASSWORD")), "ComeMai");
        Assert.assertTrue(projectsPage.isProjectPresent("ComeMai"));
    }

    @Description("Test checks that the user receives a message when searching for a non-existent project through the search box")
    @Test(description = "Search non existing project by name", groups = {"smoke"})
    public void searchNonExistingProjectByNameTest() {
        projectSteps.searchProject(System.getProperty("EMAIL", PropertyReader.getProperty("EMAIL")),
                System.getProperty("PASSWORD", PropertyReader.getProperty("PASSWORD")), "$$$$$$");
        Assert.assertEquals(projectsPage.getNoSuchProjectMessage(), "Looks like you don’t have any projects yet.");
    }

}