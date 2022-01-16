package tests.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.utils.Retry;

@Log4j
public class ProjectTest extends BaseTest {

    @Description("Test checks if the user can create a new project")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Create new project", groups = {"critical"}, retryAnalyzer = Retry.class)
    public void createNewProjectTest() {
        projectSteps.createNewProject(email, password, "TMS", "This is auto project", false);
        Assert.assertEquals(projectPage.getMessage(), "Project \"TMS\" was created successfully!");
    }


    @Description("Test checks if the user can delete a new project")
    @Test(description = "Delete a project", groups = {"smoke"})
    public void deleteProjectTest() {
     projectSteps.deleteProject(email, password,"TMS" );
     Assert.assertFalse(projectsPage.isProjectPresent("TMS"));
    }

}