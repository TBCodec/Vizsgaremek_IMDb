package Tests;

import Tests.BaseTests;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.SignInPage;


public class RegistrationTests extends BaseTests {

    @Test
    public void testSuccessfulRegistration(){
        String name = "Tóth Balázs";
        String email = "teszt@teszt.hu";
        String password = "y1X2c3V4";
        SignInPage signInPage = homePage.clickLogInButton();
        RegistrationPage registrationPage =signInPage.clickCreateAccount();
        registrationPage.typeToField("name", name);
        registrationPage.typeToField("email", email);
        registrationPage.typeToField("password", password);
        registrationPage.clickCreateButton();

    }

}
