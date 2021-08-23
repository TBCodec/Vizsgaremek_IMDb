package Tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import pages.AccountSettingPage;
import pages.EditProfilePage;

public class DeleteDataTest extends BaseTests{

    @RepeatedTest(3)
    @DisplayName("TC9")
    @Severity(SeverityLevel.NORMAL)
    public void testDeleteDataFromBio(){
        loginPage.login(username,password);
        homePage.clickUserNameButton();
        AccountSettingPage accountSettingPage = homePage.clickAccountSetting();
        EditProfilePage editProfilePage = accountSettingPage.clickEditProfile();
        editProfilePage.clearBioField();
        editProfilePage.clickSaveDescription();
        accountSettingPage.clickEditProfile();
        Assertions.assertTrue(editProfilePage.getTextFromBio().isEmpty());
    }


}
