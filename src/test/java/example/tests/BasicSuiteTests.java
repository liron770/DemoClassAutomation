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

    @BeforeSuite(groups = {"sanity", "smoke"})
    public void setUp() {
        driver = GenerateDriverNew.initDriver("chrome", "https://practicetestautomation.com/practice-test-login/");
        actions = new Actions(driver);
    }

    @Test(description="Validating login with correct credentials", groups = {"smoke"})
    public void validateLogin() throws InterruptedException {
        Assert.assertTrue(actions.doValidLogin(), "failed to login");
    }


    @Test(description="Validating login error message when incorrect user", groups = {"sanity"})
    public void InValidUserNameLogin() throws InterruptedException {
        Assert.assertTrue(actions.doLoginErrorHandlingForIncorrectUser(), "failed to validate error message in login");
    }

    @Test(description="Validating login with incorrect credentials", groups = {"sanity"})
    public void InValidPasswordLogin() throws InterruptedException {
        Assert.assertTrue(actions.doLoginErrorHandlingForIncorrectPassword(), "failed to validate error message in login");
    }

    @AfterSuite(groups = {"sanity", "smoke"})
    public void tearDown() {
        driver.quit();
    }
}
