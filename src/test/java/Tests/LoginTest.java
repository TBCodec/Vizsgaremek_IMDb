package Tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class LoginTest extends BaseTests {

    @RepeatedTest(3)
    @DisplayName("TC1")
    @Severity(SeverityLevel.CRITICAL)
    public void testSuccessfulLoginWithRegisteredUser(){

        String accountName = "Test";
        loginPage.login(username,password);
        String logInUser = homePage.getUserName();
        Assertions.assertEquals(accountName,logInUser);
        homePage.clickLogOutButton();
    }

    @RepeatedTest(3)
    @DisplayName("TC11")
    @Severity(SeverityLevel.CRITICAL)
    public void testSuccessfulLoginWithNotRegisteredUser(){
        loginPage.login("test","test");
        Assertions.assertTrue(loginPage.isThereWarningMessage());
    }

    @RepeatedTest(3)
    @DisplayName("TC2")
    @Severity(SeverityLevel.NORMAL)
    public void testSuccessfulLogout(){

        loginPage.login(username,password);
        homePage.clickLogOutButton();
        String logInUser = homePage.getUserFieldText();
        Assertions.assertEquals(logInUser, "Sign In");

    }

}
