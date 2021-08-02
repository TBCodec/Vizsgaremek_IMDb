package registration;

import base.BaseTests;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class RegistrationTests extends BaseTests {

    //@Test
    public void testSuccessfulRegistration(){
        RegistrationPage registrationPage = homePage.clickRegistration();
        registrationPage.setIAmNotRobot();

    }

}
