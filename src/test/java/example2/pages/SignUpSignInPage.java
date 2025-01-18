package example2.pages;

import all.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignUpSignInPage extends BasePage {


    public SignUpSignInPage(WebDriver driver) {
        super(driver, 10);
    }

    public void typeSignUpName(String name){
        typeText(By.xpath("//input[@data-qa='signup-name']"), name);
    }
    public void typeSignUpEmail(String email){
        typeText(By.xpath("//input[@data-qa='signup-email']"), email);
    }

    public void clickSignUp(){
        click(By.xpath("//button[@data-qa=\"signup-button\"]"));
    }

    public boolean verifyStartingSignUp(){
        return validateElementExist(By.xpath("//h2/b[text()='Enter Account Information']"));
    }
}

