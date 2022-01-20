package ui.steps;

import org.openqa.selenium.WebDriver;
import ui.pages.*;

public class SuiteSteps{
    LoginPage loginPage;
    ProjectsPage projectsPage;
    ProjectPage projectPage;
    DeleteSuiteModal deleteSuiteModal;
    EditSuiteModal editSuiteModal;

    public SuiteSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        projectPage = new ProjectPage(driver);
        projectsPage = new ProjectsPage(driver);
        deleteSuiteModal = new DeleteSuiteModal(driver);
        editSuiteModal = new EditSuiteModal(driver);
    }

    public SuiteSteps deleteSuite(String email, String password, String projectName, String suiteName) {
        loginPage.openLoginPage()
                .login(email, password)
                .openProject(projectName)
                .clickOnTrashIcon(suiteName)
                .clickOnDeleteSuiteButton()
                .refreshPage();
        return this;
    }

    public SuiteSteps updateSuite(String email, String password, String projectName, String suiteTitle, String newName, String description) {
        loginPage.openLoginPage()
                .login(email, password)
                .openProject(projectName)
                .clickOnEditSuiteIcon(suiteTitle)
                .changeSuiteName(newName)
                .addSuiteDescription(description)
                .clickOnSaveButton();
        return this;
    }


}