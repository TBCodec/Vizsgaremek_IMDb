package Tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import pages.AdvancedSearchPage;

import java.util.ArrayList;
import java.util.List;

public class SaveDataFromPage extends RepeatedAndSequentialDataEntryFromDataSourceTest{

    @RepeatedTest(3)
    @DisplayName("TC10")
    @Severity(SeverityLevel.MINOR)
    public void saveDataToFile(){
        AdvancedSearchPage advancedSearchPage = homePage.clickAdvancedSearch();
        advancedSearchPage.clickAdvancedTitleSearch();
        List<String> listTitleFromFile = new ArrayList<>();
        fileUtils.readFromFileAndAddToList(listTitleFromFile);
        List<List<String>> foundedFilmsByTitle = new ArrayList<>();
        for (String title : listTitleFromFile){
            advancedSearchPage.typeToTitleField(title);
            advancedSearchPage.clickSearchButton();
            List<String> listFromPage = advancedSearchPage.listFromPage();
            foundedFilmsByTitle.add(listFromPage);
            fileUtils.createFile(title + ".txt");
            for (String films : listFromPage){
                fileUtils.writeToFile(title + ".txt", films);

            }
            windowManager.goBack();
        }
    }


}
