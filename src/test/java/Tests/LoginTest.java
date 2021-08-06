package Tests;

import Tests.BaseTests;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SignInPage;

public class LoginTest extends BaseTests {

    @DisplayName("TC1")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testSuccessfulLogin(){
        SignInPage signInPage = homePage.clickLogInButton();
        LoginPage loginPage = signInPage.clickSignInWithImdb();
        loginPage.setUserNameField("litro@freemail.hu");
        loginPage.setPasswordField("Bw330405");
        HomePage homePage = loginPage.clickSignInButton();
        String logInUser = homePage.getUserName();
        Assertions.assertEquals(logInUser, "Test");
    }

    @DisplayName("TC2")
    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testSuccessfulLogout(){
        testSuccessfulLogin();
        homePage.clickLogOutButton();
        String logInUser = homePage.getUserFieldText();
        Assertions.assertEquals(logInUser, "Sign In");

    }

}
