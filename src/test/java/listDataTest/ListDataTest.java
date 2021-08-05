package listDataTest;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.TopBoxOfficePage;

import java.util.List;

public class ListDataTest extends BaseTests {

    @Test
    @DisplayName("TC4")
    public void listDataTest(){
        TopBoxOfficePage topBoxOfficePage = homePage.clickTopBox();
        List<String> filmTitles = topBoxOfficePage.listOfPage();
        utils.printListText("List of films:", filmTitles);
        Assertions.assertTrue(filmTitles.size() > 1);
    }

}
