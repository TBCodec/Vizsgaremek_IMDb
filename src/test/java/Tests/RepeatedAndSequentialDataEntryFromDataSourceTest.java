package Tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.AdvancedSearchPage;
import utils.Javascript;

import java.util.ArrayList;
import java.util.List;

//Ismételt és sorozatos adatbevitel adatforrásból
public class RepeatedAndSequentialDataEntryFromDataSourceTest extends BaseTests{


    @RepeatedTest(3)
    @DisplayName("TC7")
    @Severity(SeverityLevel.NORMAL)
    public void repeatedSearchFilmByTitleFromFile(){
        AdvancedSearchPage advancedSearchPage = homePage.clickAdvancedSearch();
        advancedSearchPage.clickAdvancedTitleSearch();
        List<String> listTitleFromFile = new ArrayList<>();
        fileUtils.readFromFileAndAddToList(listTitleFromFile);
        List<List<String>> foundedFilmsByTitle = new ArrayList<>();
        for (String title : listTitleFromFile){
            advancedSearchPage.typeToTitleField(title);
            advancedSearchPage.clickSearchButton();
            List<String> listFromPage = advancedSearchPage.listFromPage();
            utils.printListText("Films with title " + title, listFromPage);
            foundedFilmsByTitle.add(listFromPage);
            windowManager.goBack();
        }
        Assertions.assertTrue(foundedFilmsByTitle.size() > 1);

    }

}
