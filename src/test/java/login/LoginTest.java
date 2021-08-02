package login;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignInPage;
import utils.AddCookie;

public class LoginTest extends BaseTests {

    @Test
    public void testSuccessfulLogin(){
        SignInPage signInPage = homePage.clickLogInButton();
        LoginPage loginPage = signInPage.clickSignInWithImdb();
        loginPage.setUserNameField("litro@freemail.hu");
        loginPage.setPasswordField("Bw330405");
        HomePage homePage = loginPage.clickSignInButton();
        String logInUser = homePage.getUserName();
        Assertions.assertEquals(logInUser, "Test");
    }

}
