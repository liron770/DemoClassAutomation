package example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public boolean login(String username, String password) throws InterruptedException {
        typeUsername(username);
        typePassword(password);
        clickLoginButton();
        return validateLogin();
    }

    public boolean loginErrorHandelingForIncorrectUser(String username, String password) throws InterruptedException {
        typeUsername(username);
        typePassword(password);
        clickLoginButton();
        return InvalidUserLogin();
    }

    public boolean loginErrorHandelingForIncorrectPassword(String username, String password) throws InterruptedException {
        typeUsername(username);
        typePassword(password);
        clickLoginButton();
        return InvalidPasswordLogin();
    }


    public boolean validateLogin(){
        return isElementDisplayed(By.xpath("//h1[text()=\"Logged In Successfully\"]"));
    }

    public boolean InvalidUserLogin(){
        return isElementDisplayed(By.xpath("//div[text()='Your username is invalid!']"));
    }

    public boolean InvalidPasswordLogin(){
        return isElementDisplayed(By.xpath("//div[text()='Your password is invalid!']"));
    }


    public void typeUsername(String username){
        typeText(By.id("username"), username);

    }

    public void typePassword(String password){
        typeText(By.id("password"), password);
    }

    public void clickLoginButton(){
        clickElement(By.id("submit"));

    }

}
