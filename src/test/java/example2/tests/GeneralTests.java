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


    @BeforeSuite
    public void setUp()  {
        String URL = JsonUtils.readJsonFromFile("url");
        String BROWSER = JsonUtils.readJsonFromFile("browser");
        driver = GenerateDriverAll.initDriver(BROWSER, URL);
        actions = new Actions(driver);
    }


    @Test
    public void compareChromeCPU() {
        assert actions.compareChromeCpuValue();
    }

    @AfterSuite
    public void tearDown() {
        GenerateDriverAll.cleanDriver(driver);
    }

}
