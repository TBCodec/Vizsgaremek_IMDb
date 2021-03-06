package Tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import pages.RegistrationPage;
import pages.SignInPage;


public class RegistrationTests extends BaseTests {

    @RepeatedTest(3)
    @DisplayName("TC0")
    @Severity(SeverityLevel.BLOCKER)
    public void testSuccessfulRegistration(){
        String name = "Tóth Balázs";
        String email = "teszt2@teszt.hu";
        String password = "y1X2c3V4";
        SignInPage signInPage = homePage.clickLogInButton();
        RegistrationPage registrationPage =signInPage.clickCreateAccount();
        registrationPage.typeToField("name", name);
        registrationPage.typeToField("email", email);
        registrationPage.typeToField("password", password);
        registrationPage.clickCreateButton();
        if (registrationPage.isThereAlertField()){
            String expectedResult = "account already exists with the email address teszt@teszt.hu";
            System.out.println(registrationPage.alertText());
            Assertions.assertTrue(registrationPage.alertText().contains(expectedResult));
        }
    }

}
