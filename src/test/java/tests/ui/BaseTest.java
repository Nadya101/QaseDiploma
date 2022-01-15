package tests.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.pages.*;
import ui.steps.ProjectSteps;
import ui.steps.SuiteSteps;
import ui.steps.TestCaseSteps;

public class BaseTest {
    WebDriver driver;
    String email = "angel.nadii36@gmail.com";
    String password = "gQGdpPJ3AFZ*85Z";

    ProjectSteps projectSteps;
    SuiteSteps suiteSteps;
    TestCaseSteps testCaseSteps;
    LoginPage loginPage;
    ProjectsPage projectsPage;
    ProjectPage projectPage;
    MenuModal menuModal;

    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        initPages();
    }

    public void initPages() {
        loginPage = new LoginPage(driver);
        projectSteps = new ProjectSteps(driver);
        suiteSteps = new SuiteSteps(driver);
        testCaseSteps = new TestCaseSteps(driver);
        projectPage = new ProjectPage(driver);
        projectsPage = new ProjectsPage(driver);
        menuModal = new MenuModal(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }

}