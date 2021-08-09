package Tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.*;

public class NewDataInputTest extends BaseTests{

    private String username = "litro@freemail.hu";
    private String password = "Bw330405";

    @Test
    @DisplayName("TC6")
    @Severity(SeverityLevel.NORMAL)
    public void newDataInputBioTest(){
        String textToBio = "Hello World!";
        loginPage.login(username,password);
        homePage.clickUserNameButton();
        AccountSettingPage accountSettingPage = homePage.clickAccountSetting();
        EditProfilePage editProfilePage = accountSettingPage.clickEditProfile();
        editProfilePage.writeToBioField(textToBio);
        editProfilePage.clickSaveDescription();
        accountSettingPage.clickEditProfile();
        Assertions.assertTrue(editProfilePage.getTextFromBio().contains(textToBio));

    }

    }
