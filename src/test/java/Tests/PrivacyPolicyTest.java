package Tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import pages.PrivacyPolicyPage;

public class PrivacyPolicyTest extends BaseTests {

    @RepeatedTest(3)
    @DisplayName("TC3")
    @Severity(SeverityLevel.CRITICAL)
    public void testPrivacyPolicy(){
        PrivacyPolicyPage privacyPolicyPage = homePage.clickPrivacy();
        String actualtext = privacyPolicyPage.linesOnPrivacy();
        String expectedText = "IMDb Privacy Notice";
        Assertions.assertTrue(actualtext.startsWith(expectedText));

    }


}
