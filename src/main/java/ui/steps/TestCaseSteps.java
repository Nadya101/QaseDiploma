package ui.steps;

import org.openqa.selenium.WebDriver;
import ui.pages.*;
import utils.Waiters;

public class TestCaseSteps {
    public static String caseCode = "";

    LoginPage loginPage;
    ProjectsPage projectsPage;
    MenuContainer menuContainer;
    MenuModal menuModal;
    NewProjectPage newProjectPage;
    CreateTestCasePage createTestCasePage;
    ProjectPage projectPage;
    DeleteSuiteModal deleteSuiteModal;


    public TestCaseSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        projectsPage = new ProjectsPage(driver);
        menuContainer = new MenuContainer(driver);
        menuModal = new MenuModal(driver);
        newProjectPage = new NewProjectPage(driver);
        createTestCasePage = new CreateTestCasePage(driver);
        projectPage = new ProjectPage(driver);
        deleteSuiteModal = new DeleteSuiteModal(driver);
    }

    public TestCaseSteps createTestCase(String email, String password, String projectName, String title) {
        loginPage.openLoginPage()
                .login(email, password)
                .openProject(projectName)
                .clickOnCreateCaseButton()
                .setTitle(title)
                .clickOnSaveButton();
        return this;
    }


    public TestCaseSteps deleteTestCase(String email, String password, String projectName, String caseTitle) {
        caseCode = loginPage.openLoginPage()
                .login(email, password)
                .openProject(projectName)
                .openCasesList()
                .selectTestCaseByName(caseTitle)
                .getCaseCode();
        projectPage.clickOnDeleteCaseButton()
                .clickOnDeleteButton();
        return this;
    }

    public TestCaseSteps updateTestCase(String email, String password, String projectName, String caseTitle, String newTitle) {
        loginPage.openLoginPage()
                .login(email, password)
                .openProject(projectName)
                .selectTestCaseByName(caseTitle)
                .clickOnEditTestCaseButton()
                .changeCaseTitle(newTitle)
                .clickOnSaveButton();
        return this;
    }


    public String printCode() {
        return caseCode;
    }

}