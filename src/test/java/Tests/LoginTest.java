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

    private String username = "litro@freemail.hu";
    private String password = "Bw330405";

    @DisplayName("TC1")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testSuccessfulLogin(){

        String accountName = "Test";
        loginPage.login(username,password);
        String logInUser = homePage.getUserName();
        Assertions.assertEquals(accountName,logInUser);
        homePage.clickLogOutButton();
    }

    @DisplayName("TC2")
    @Test
    @Severity(SeverityLevel.NORMAL)
    public void testSuccessfulLogout(){

        loginPage.login(username,password);
        homePage.clickLogOutButton();
        String logInUser = homePage.getUserFieldText();
        Assertions.assertEquals(logInUser, "Sign In");

    }

}
