package tests.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import tests.utils.TestListener;
import ui.constants.IConstants;
import ui.pages.*;
import ui.steps.ProjectSteps;
import ui.steps.SuiteSteps;
import ui.steps.TestCaseSteps;
import utils.PropertyReader;

@Listeners(TestListener.class)
public class BaseTest implements IConstants {
    WebDriver driver;

    ProjectSteps projectSteps;
    SuiteSteps suiteSteps;
    TestCaseSteps testCaseSteps;
    LoginPage loginPage;
    ProjectsPage projectsPage;
    ProjectPage projectPage;
    MenuModal menuModal;

    protected static final String email = System.getProperty("EMAIL", PropertyReader.getProperty("EMAIL"));
    protected static final String password = System.getProperty("PASSWORD", PropertyReader.getProperty("PASSWORD"));

    @BeforeMethod
    public void initTest(ITestContext context) {
        initBrowser();
        String driverVariable = "driver";
        context.setAttribute(driverVariable, driver);
        initPages();
    }

    public void initBrowser() {
        if (System.getProperty("browser") != null) {
            if (System.getProperty("browser").equals("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if (System.getProperty("browser").equals("edge")) {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            } else if (System.getProperty("browser").equals("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
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
        if (driver != null) {
            driver.quit();
        }
    }

}