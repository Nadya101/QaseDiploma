package tests.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest{

    @Test
    public void createNewProjectTest(){
        loginPage.openLoginPage()
                .login(email, password)
                .clickOnButtonLogin();
        String projectName = "Five project";
        newProjectPage.openNewProjectPage()
                .createNewProject(projectName, newProjectPage.createRandomProjectCode(), "This is auto project")
                .makePublicProject(false)
                .clickOnCreateProjectButton();
        Assert.assertEquals(projectsPage.getProjectCreatedMessage(), "Project \""+ projectName +"\" was created successfully!");
    }

    @Test
    public void deleteProject(){
        String projectName = "Forth3 project";
        loginPage.openLoginPage()
                .login(email, password)
                .clickOnButtonLogin()
                .deleteProjectByName(projectName)
                .confirmDeleteProject();
        Assert.assertFalse(projectsPage.isProjectPresent(projectName));
    }

}