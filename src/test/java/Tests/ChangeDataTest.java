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

    @RepeatedTest(3)
    @DisplayName("Test8")
    @Severity(SeverityLevel.NORMAL)
    public void testChangeDataInProfileBio(){
        String textToBio = "Test Bio field";
        //1. Lépjünk be a felhasználóval
        loginPage.login(username,password);
        //2. Kattintsunk a felhasználó nevére
        homePage.clickUserNameButton();
        //3. Kattintsunk az "Account Setting"-re
        AccountSettingPage accountSettingPage = homePage.clickAccountSetting();
        //4. Kattintsunk az "Edit Profile"-ra
        EditProfilePage editProfilePage = accountSettingPage.clickEditProfile();
        //5. Töröljük a Bio mezőben lévő adatot
        editProfilePage.clearBioField();
        //6. Írjuk be a "Beírandó szöveg"-et a Bio mezőbe
        editProfilePage.writeToBioField(textToBio);
        //7. Kattintsunk a "Save Description"-re
        editProfilePage.clickSaveDescription();
        //8. Kattintsunk újra az "Edit Profile"-ra
        accountSettingPage.clickEditProfile();
        //9. Ellenőrizzük, hogy csak a "Beírandó szöveg"-et tartalmazza a Bio mező
        Assertions.assertEquals(textToBio,editProfilePage.getTextFromBio());
    }

}
