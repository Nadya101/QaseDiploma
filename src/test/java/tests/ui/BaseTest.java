package tests.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.pages.*;


public class BaseTest {

    String email = "";
    String password = "";

    WebDriver driver;
    LoginPage loginPage;
    ProjectsPage projectsPage;
    MenuContainer menuContainer;
    MenuModal menuModal;
    NewProjectPage newProjectPage;
    NewTestCasePage newTestCasePage;
    ProjectPage projectPage;
    DeleteSuiteModal deleteSuiteModal;

    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        projectsPage = new ProjectsPage(driver);
        menuContainer = new MenuContainer(driver);
        menuModal = new MenuModal(driver);
        newProjectPage = new NewProjectPage(driver);
        newTestCasePage = new NewTestCasePage(driver);
        projectPage = new ProjectPage(driver);
        deleteSuiteModal = new DeleteSuiteModal(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }
}
