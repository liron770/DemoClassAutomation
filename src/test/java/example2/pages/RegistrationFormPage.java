package example2.pages;

import all.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegistrationFormPage extends BasePage {


    public RegistrationFormPage(WebDriver driver) {
        super(driver, 10);
    }

   public void fillContactName(String name){
        typeText(By.cssSelector("input[name='ContactName']"), name);
    }

    public void fillContactNumber(String contactNumber){
        typeText(By.cssSelector("input[name='contactnumber']"), contactNumber);
    }

    public void selectPaymentMethod(String contactNumber){

    }

    public void fillDate(String date){
        typeText(By.cssSelector("input[name='pickupdate']"), date);
    }

    public void clickRegister(){
        click(By.cssSelector("button[type='submit']"));
    }

    public boolean validateForgotPassword(){
        return validateElementExists(By.id("confirmation-alert")) > 0;
    }

}

