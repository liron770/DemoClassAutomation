package example2.actions;

import all.utils.JsonUtils;
import all.utils.RandomUtils;
import example2.pages.*;
import org.openqa.selenium.WebDriver;

public class Actions {

    ForgotPasswordPage forgotPassword;

    RegistrationFormPage registrationForm;
    AutomationExercisePage automationExercisePage;
    HomePage homePage;
    SignUpSignInPage signUpSignInPage;

    SignUpFormPage signUpFormPage;

    /**
     * Constructor to initialize the Actions class with a WebDriver instance.
     *
     * @param driver the WebDriver instance to be used for interacting with web elements
     */
    public Actions(WebDriver driver) {
        forgotPassword = new ForgotPasswordPage(driver);
        registrationForm = new RegistrationFormPage(driver);
        automationExercisePage = new AutomationExercisePage(driver);
        homePage = new HomePage(driver);
        signUpSignInPage = new SignUpSignInPage(driver);
        signUpFormPage = new SignUpFormPage(driver);
    }


    public boolean loginValidCredentials() {
        String email = JsonUtils.readJsonFromFile("valid_email");
        String password = JsonUtils.readJsonFromFile("valid_password");
        String name = JsonUtils.readJsonFromFile("valid_name");
        boolean results = homePage.verifyHomePage();
        if (results) {
            homePage.accessSignUp();
            results = homePage.verifyAccessSignInSignUpPage();
            if (results) {
                signUpSignInPage.typeSignInEmail(email);
                signUpSignInPage.typeSignInPassword(password);
                signUpSignInPage.clickSignIn();
                results = signUpSignInPage.validateSucceedLogin(name);
                return results;
            }
        }
        return results;
    }

    /**
     * Performs the forgot password action by typing the email, clicking submit, and validating the result.
     *
     * @return true if the forgot password functionality is validated successfully, false otherwise
     */
    public boolean doForgotPassword() {
        forgotPassword.typeEmail("test@test.com");
        forgotPassword.clickSubmit();
        return forgotPassword.validateForgotPassword();
    }

    public boolean doForgotPasswordFromExcel(String email) {
        forgotPassword.typeEmail(email);
        forgotPassword.clickSubmit();
        return forgotPassword.validateForgotPassword();
    }

    /**
     * Performs the registration form action by filling the contact name, date, and clicking submit.
     *
     * @param name the contact name to be filled
     * @param date the date to be filled
     */
    public boolean doRegistrationForm(String name, String date) {
        registrationForm.fillContactName(name);
        registrationForm.fillContactNumber("012-3456789");
        registrationForm.fillDate(date);
        registrationForm.selectPaymentMethod("cashondelivery");
        registrationForm.clickRegister();
        return registrationForm.validateFormSuccessSubmitted();
    }

    /**
     * doSubscription form action by filling the contact name, date, and clicking submit.
     *
     * @param email the contact email to be filled
     */
    public boolean doSubscription(String email) {
        return automationExercisePage.fillSubscription(email);
    }

    public boolean verifyHomePage() {
        return homePage.verifyHomePage();
    }

    public boolean accessVerifySignInSignUpPage() {
        homePage.accessSignUp();
        return homePage.verifyAccessSignInSignUpPage();

    }

    public boolean verifyStartingSignUp() {
        int randomInt = RandomUtils.getRandomInt(6);
        String name = "Auto Test User " + randomInt;
        String email = "test_user" + randomInt + "@autotest.com";
        signUpSignInPage.typeSignUpName(name);
        signUpSignInPage.typeSignUpEmail(email);
        signUpSignInPage.clickSignUp();
        return signUpSignInPage.verifyStartingSignUp(name, email);
    }

    public boolean verifyFillingSignUp() {

        signUpFormPage.selectTitle("woman");
        boolean results = signUpFormPage.verifyDisabledEmailInput();
        if (!results) {
            results = signUpFormPage.verifySignUpFormPage();
        }
        signUpFormPage.typePassword("12345678");
        signUpFormPage.selectAyear("1990");
        signUpFormPage.signUpForNewsletters();
        signUpFormPage.signUpForOffers();
        signUpFormPage.typeFirstName("QA_firstName");
        signUpFormPage.typeLastName("QA_lastName");
        signUpFormPage.typeCompany("QA_company");
        signUpFormPage.typeAddress_1("QA_address_1");
        signUpFormPage.typeAddress_2("QA_address_2");
        signUpFormPage.selectCountry("United States");
        signUpFormPage.typeState("California");
        signUpFormPage.typeCity("Los Angeles");
        signUpFormPage.typeZipCode("90001");
        signUpFormPage.typeMobileNumber("1234567890");
        signUpFormPage.clickCreateAccount();
        if (!results) {
            results = signUpFormPage.verifySignUpSuccess();
        }
        return results;
    }





}