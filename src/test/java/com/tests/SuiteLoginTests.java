package com.tests;

import com.actions.Action;
import com.utils.GenerateDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class SuiteLoginTests {

    WebDriver driver;
    Action actions;


    @BeforeSuite
    public void setUp()  {
        driver = GenerateDriver.initDriver("chrome", "https://practicetestautomation.com/practice-test-login/");
        actions = new Action(driver);
    }


    @Test
    public void testLogin() {
        assert actions.performLoginSuccessfully();
    }



    @AfterSuite
    public void tearDown() {
        GenerateDriver.cleanDriver(driver);
    }

}
