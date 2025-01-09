package example2.actions;


import example2.pages.ForgotPasswordPage;
import example2.pages.TableTask;
import org.openqa.selenium.WebDriver;

public class Actions {

    TableTask tableTask;
    ForgotPasswordPage forgotPassword;
    public Actions(WebDriver driver) {
        tableTask = new TableTask(driver);
        forgotPassword = new ForgotPasswordPage(driver);
    }

    public boolean doForgotPassword() {
        return forgotPassword.validateForgotPasswordFunctionality();

    }

}
