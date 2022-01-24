package tests.ui;

import api.adapters.ProjectAdapter;
import api.models.Project;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
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
        projectSteps.createNewProject(EMAIL, PASSWORD, "TMS", "This is auto project", false);
        Assert.assertEquals(projectPage.getMessage(), "Project \"TMS\" was created successfully!");
    }

    @Description("Test checks if the user can delete a new project")
    @Test(description = "Delete a project", groups = {"smoke"})
    public void deleteProjectTest() {
        Project project = Project.builder()
                .title("Qase project")
                .code("NB101")
                .description("This is public project")
                .build();
        Response response = new ProjectAdapter().createProject(project);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.path("result.code"), "NB101");

        projectSteps.deleteProject(EMAIL, PASSWORD, "Qase project");
        Assert.assertFalse(projectsPage.isProjectPresent("Qase project"));
    }

}