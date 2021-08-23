package Tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import pages.AdvancedSearchPage;

import java.util.ArrayList;
import java.util.List;

//Ismételt és sorozatos adatbevitel adatforrásból
public class RepeatedAndSequentialDataEntryFromDataSourceTest extends BaseTests{

    public List<List<String>> foundedFilmsByTitle;

    public void repeatedSearchFilmByTitleFromFile(){
        AdvancedSearchPage advancedSearchPage = homePage.clickAdvancedSearch();
        advancedSearchPage.clickAdvancedTitleSearch();
        List<String> listTitleFromFile = new ArrayList<>();
        fileUtils.readFromFileAndAddToList("Files/searchFilm.txt", listTitleFromFile);
        foundedFilmsByTitle = new ArrayList<>();
        for (String title : listTitleFromFile){
            advancedSearchPage.typeToTitleField(title);
            advancedSearchPage.clickSearchButton();
            List<String> listFromPage = advancedSearchPage.listFromPage();
            utils.printListText("Films with title " + title, listFromPage);
            foundedFilmsByTitle.add(listFromPage);
            windowManager.goBack();
        }
    }

    @RepeatedTest(3)
    @DisplayName("TC7")
    @Severity(SeverityLevel.NORMAL)
    public void testRepeatedSearchFilmByTitleFromFileTest(){
        repeatedSearchFilmByTitleFromFile();
        Assertions.assertTrue(foundedFilmsByTitle.size() > 1);
    }


}
