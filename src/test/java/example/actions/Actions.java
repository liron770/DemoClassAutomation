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


    public boolean doLoginErrorHandlingForIncorrectUser() throws InterruptedException {
        return loginPage.loginErrorHandelingForIncorrectUser("student1", "Password123");
    }

    public boolean doLoginErrorHandlingForIncorrectPassword() throws InterruptedException {
        return loginPage.loginErrorHandelingForIncorrectPassword("student", "Password1234");
    }

}
