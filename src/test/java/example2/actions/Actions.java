package example2.actions;


import example2.pages.TableTask;
import org.openqa.selenium.WebDriver;

public class Actions {

    TableTask tableTask;
    public Actions(WebDriver driver) {
        tableTask = new TableTask(driver);
    }

    public boolean compareChromeCpuValue() {
        String cpuValue = tableTask.getChromeCpuValue();
        return true;

    }

}
