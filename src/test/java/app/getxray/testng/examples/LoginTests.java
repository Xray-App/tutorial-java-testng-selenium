package app.getxray.testng.examples;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.Reporter;
import org.testng.reporters.XMLReporter;
import org.testng.ITestResult;
import app.getxray.xray.testng.annotations.XrayTest;
import app.getxray.xray.testng.annotations.Requirement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class LoginTests {
    WebDriver driver;
    RepositoryParser repo;

    @BeforeSuite
    public void setUp() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox"); // Bypass OS security model, to run in Docker
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        repo = new RepositoryParser("./src/configs/object.properties");
    }

    @AfterSuite
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    @Requirement(key = "XT-1")
    public void validLogin() {
        LoginPage loginPage = new LoginPage(driver).open();
        Assert.assertTrue(loginPage.isVisible());
        LoginResultsPage loginResultsPage = loginPage.login("demo", "mode");
        Assert.assertEquals(loginResultsPage.getTitle(), repo.getBy("expected.login.title"));
        Assert.assertTrue(loginResultsPage.contains(repo.getBy("expected.login.success")));
    }

    @Test
    @XrayTest(summary= "invalid login scenario", labels="authentication")
    public void invalidLogin() {
        LoginPage loginPage = new LoginPage(driver).open();
        Assert.assertTrue(loginPage.isVisible());
        LoginResultsPage loginResultsPage = loginPage.login("demo", "invalid");
        Assert.assertEquals(loginResultsPage.getTitle(), repo.getBy("expected.error.title"));
        Assert.assertTrue(loginResultsPage.contains(repo.getBy("expected.login.failed")));
    }

}
