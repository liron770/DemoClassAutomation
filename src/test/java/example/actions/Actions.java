package example.actions;

import org.openqa.selenium.WebDriver;
import example.pages.LoginPage;

public class Actions {

    LoginPage loginPage;

    public Actions(WebDriver driver){
        loginPage = new LoginPage(driver);
    }

    public boolean doValidLogin() throws InterruptedException {
        return loginPage.login("student", "Password123");
    }


}
