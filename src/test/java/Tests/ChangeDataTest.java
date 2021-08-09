package Tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import pages.AccountSettingPage;
import pages.EditProfilePage;

public class ChangeDataTest extends BaseTests{

    private String username = "litro@freemail.hu";
    private String password = "Bw330405";

    @RepeatedTest(3)
    @DisplayName("Test8")
    @Severity(SeverityLevel.NORMAL)
    public void changeDataInProfileBio(){
        String textToBio = "Test Bio field";
        loginPage.login(username,password);
        homePage.clickUserNameButton();
        AccountSettingPage accountSettingPage = homePage.clickAccountSetting();
        EditProfilePage editProfilePage = accountSettingPage.clickEditProfile();
        editProfilePage.clearBioField();
        editProfilePage.writeToBioField(textToBio);
        editProfilePage.clickSaveDescription();
        accountSettingPage.clickEditProfile();
        Assertions.assertEquals(textToBio,editProfilePage.getTextFromBio());
    }

}
