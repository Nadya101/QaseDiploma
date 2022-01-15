package tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test
    public void createNewProjectTest() {
        projectSteps.createNewProject(email, password, "TMS", "This is auto project", false);
        Assert.assertEquals(projectPage.getMessage(), "Project \"TMS\" was created successfully!");
    }

    @Test
    public void deleteProjectTest() {
     projectSteps.deleteProject(email, password,"TMS" );
     Assert.assertFalse(projectsPage.isProjectPresent("TMS"));
    }

}