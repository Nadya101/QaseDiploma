package tests.ui;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchTest extends BaseTest {

    @Description("Test checks if the user can find an existing project through the search box")
    @Test(description = "Search existing project by name", groups = {"search"})
    public void searchExistingProjectByNameTest() {
        projectSteps.searchProject(email, password, "ComeMai");
        Assert.assertTrue(projectsPage.isProjectPresent("ComeMai"));
    }

    @Description("Test checks that the user receives a message when searching for a non-existent project through the search box")
    @Test(description = "Search non existing project by name", groups = {"search"})
    public void searchNonExistingProjectByNameTest() {
        projectSteps.searchProject(email, password, "$$$$$$");
        Assert.assertEquals(projectsPage.getNoSuchProjectMessage(),"Looks like you don’t have any projects yet.");
    }

}