package example2.pages;

import all.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TableTask extends BasePage {


    public TableTask(WebDriver driver) {
        super(driver, 10);
    }

    public String getChromeCpuValue(){
        return "TEST";
    }



}

