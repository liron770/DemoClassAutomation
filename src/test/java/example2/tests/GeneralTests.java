package example2.tests;

import all.utils.GenerateDriverAll;
import all.utils.JsonUtils;
import example2.actions.Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class GeneralTests {

    WebDriver driver;
    Actions actions;

    /**
     * Sets up the test environment by initializing the WebDriver and Actions.
     * Reads the URL and browser type from the JSON configuration file.
     */
    @BeforeSuite
    public void setUp() {
        String URL = JsonUtils.readJsonFromFile("url");
        String BROWSER = JsonUtils.readJsonFromFile("browser");
        driver = GenerateDriverAll.initDriver(BROWSER, URL);
        actions = new Actions(driver);
    }

    /**
     * Test to compare the Chrome CPU value.
     * Asserts that the comparison is successful.
     */
    @Test(description = "Compare Chrome CPU value")
    public void compareChromeCPU() {
        assert actions.compareChromeCpuValue();
    }

    /**
     * Cleans up the test environment by quitting the WebDriver.
     */
    @AfterSuite
    public void tearDown() {
        GenerateDriverAll.cleanDriver(driver);
    }
}