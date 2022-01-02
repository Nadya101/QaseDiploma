package tests.ui;

import org.testng.annotations.Test;

public class TestCaseTest extends BaseTest {

    @Test
    public void createNewTestCaseMandatoryFieldsOnlyTest() {
        loginPage.openLoginPage()
                .login(email, password)
                .clickOnButtonLogin()
                .openProject("First project")
                .clickOnCreateNewCaseButton()
                .setTitle("Test Case Title")
                .clickOnAddStepsButton()
                .addStepsToReproduce("Action", "101", "Passed")
                .clickOnSaveButton();
    }

    @Test
    public void createNewTestCaseTest() {
        loginPage.openLoginPage()
                .login(email, password)
                .clickOnButtonLogin()
                .openProject("First project")
                .clickOnCreateNewCaseButton()
                .setTitle("Full test case")
             //   .setStatus("Draft")
                .setDescription("This second test case")
                .setSeverity("Critical")
                .setPriority("High")
                .setType("Smoke")
                .setLayer("E2E")
                .isFlaky("No")
                .setBehavior("Positive")
                .setAutomationStatus("Automated")
                .setPreCondition("Pre_Condition")
                .setPostCondition("Post_Condition")
                .addParamAndValue("login", "login@gamil.com")
                .addParamAndValue("password", "12345")
                .addStepsToReproduce("First action", "101", "Passed")
                .addStepsToReproduce("Second action", "101", "Passed")
                .clickOnSaveButton();
    }


    @Test
    public void deleteTestCase(){
        loginPage.openLoginPage()
                .login(email, password)
                .clickOnButtonLogin()
                .openProject("Third project")
                .selectTestCaseByName("Case101")
                .clickOnDeleteButton()
                .typeConfirmDelete()
                .clickOnDeleteButton();

    }

}