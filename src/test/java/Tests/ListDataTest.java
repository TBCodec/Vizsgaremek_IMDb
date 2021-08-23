package Tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import pages.TopBoxOfficePage;

import java.util.List;

//Adatok listázása
public class ListDataTest extends BaseTests {

    @RepeatedTest(3)
    @DisplayName("TC4")
    @Severity(SeverityLevel.MINOR)
    public void testListDataFromTopBox(){
        TopBoxOfficePage topBoxOfficePage = homePage.clickTopBox();
        List<String> filmTitles = topBoxOfficePage.listOfPage();
        utils.printListText("List of films:", filmTitles);
        Assertions.assertTrue(filmTitles.size() > 1);
    }

}
