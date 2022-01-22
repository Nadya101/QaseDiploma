package ui.steps;

import org.openqa.selenium.WebDriver;
import ui.pages.*;

public class ProjectSteps {

    LoginPage loginPage;
    ProjectsPage projectsPage;
    ProjectPage projectPage;
    NewProjectPage newProjectPage;

    public ProjectSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        projectsPage = new ProjectsPage(driver);
        projectPage = new ProjectPage(driver);
        newProjectPage = new NewProjectPage(driver);
    }

    public ProjectSteps createNewProject(String email, String password, String name, String description, boolean isPublicProject) {
        loginPage.openLoginPage()
                .login(email, password);
        newProjectPage.openNewProjectPage()
                .createNewProject(name, description)
                .makePublicOrPrivateProject(isPublicProject)
                .clickOnCreateProjectButton();
        return this;
    }

    public ProjectSteps deleteProject(String email, String password, String name) {
        loginPage.openLoginPage()
                .login(email, password)
                .openProjectMenu(name)
                .clickOnDeleteProjectButton()
                .confirmDeleteProject();
        return this;
    }

    public ProjectSteps searchProject(String email, String password, String name) {
     loginPage.openLoginPage()
             .login(email, password)
             .searchProjectByName(name);
     return this;
    }

}