package example.tests;

import example.utils.GenerateDriverNew;
import example.actions.Actions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BasicSuiteTests {

    WebDriver driver;
    Actions actions;

    @BeforeSuite
    public void setUp() {
        driver = GenerateDriverNew.initDriver("chrome", "https://practicetestautomation.com/practice-test-login/");
        actions = new Actions(driver);
    }

    @Test(description="Validating login with correct credentials")
    public void validateLogin() throws InterruptedException {
        Assert.assertTrue(actions.doValidLogin(), "failed to login");
    }


    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
