package tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void searchExistingProjectByNameTest() {
        projectSteps.searchProject(email, password, "ComeMai");
        Assert.assertTrue(projectsPage.isProjectPresent("ComeMai"));
    }

    @Test
    public void searchNonExistingProjectByNameTest() {
        projectSteps.searchProject(email, password, "$$$$$$");
        Assert.assertEquals(projectsPage.getNoSuchProjectMessage(),"Looks like you don’t have any projects yet.");
    }

}