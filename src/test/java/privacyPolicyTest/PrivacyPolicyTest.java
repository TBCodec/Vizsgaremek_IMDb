package privacyPolicyTest;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.PrivacyPolicyPage;

public class PrivacyPolicyTest extends BaseTests {

    @Test
    public void privacyPolicyTest(){
        PrivacyPolicyPage privacyPolicyPage = homePage.clickPrivacy();
        String actualtext = privacyPolicyPage.linesOnPrivacy();
        String expectedText = "IMDb Privacy Notice";
        Assertions.assertTrue(actualtext.startsWith(expectedText));

    }


}
