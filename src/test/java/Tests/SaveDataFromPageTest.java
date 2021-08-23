package Tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import pages.AdvancedSearchPage;
import pages.DVDPage;
import pages.ReleasePage;

import java.util.ArrayList;
import java.util.List;

public class SaveDataFromPageTest extends RepeatedAndSequentialDataEntryFromDataSourceTest{

    private String fileName;

    @RepeatedTest(3)
    @DisplayName("TC10")
    @Severity(SeverityLevel.MINOR)
    public void testSaveDataToFileAdvancedSearch(){
        //1. Kattintsunk az "Advanced Search"-re
        AdvancedSearchPage advancedSearchPage = homePage.clickAdvancedSearch();
        //2. Kattintsunk az "Advanced Title Search"-re
        advancedSearchPage.clickAdvancedTitleSearch();
        List<String> listTitleFromFile = new ArrayList<>();
        //3. Olvassuk be a "searchFilm" file-ból a filmcímeket
        fileUtils.readFromFileAndAddToList("Files/searchFilm.txt", listTitleFromFile);
        List<List<String>> foundedFilmsByTitle = new ArrayList<>();
        for (String title : listTitleFromFile){
            //4. Soronként írjuk be a filmcímet a kereső mezőbe
            advancedSearchPage.typeToTitleField(title);
            //5. Kattintsunk a "Search" gombra
            advancedSearchPage.clickSearchButton();
            List<String> listFromPage = advancedSearchPage.listFromPage();
            //6. Mentsük el az oldalon található filmek listáját
            foundedFilmsByTitle.add(listFromPage);
            //7. Mentsük el a filmcímeket egy file-ba, aminek a neve "keresett filmcím".txt
            fileName = title + ".txt";
            fileUtils.createFile(fileName);
            for (String films : listFromPage){
                fileUtils.writeToFile(fileName, films);

            }
            //8. Ellenőrizzük, hogy a txt file-ban szerepelnek e a filmcímek
            Assertions.assertTrue(isListInFile());
            //9. Lépjünk vissza a keresőoldalra
            windowManager.goBack();
            //10. Ismételjük a 4. ponttól a lépéseket, amíg van filmcím
        }
    }

    @RepeatedTest(3)
    @DisplayName("TC13")
    public void testSaveDataToFileDVD(){
        String title = "DVD_films";
        DVDPage dvdPage = homePage.clickDVD();
        List<String> filmTitles = dvdPage.listOfPage();
        utils.printListText("List of films:", filmTitles);
        fileName = title + ".txt";
        fileUtils.createFile(fileName);
        for (String films : filmTitles){
            fileUtils.writeToFile(fileName, films);
        }
        Assertions.assertTrue(isListInFile());
    }

    @RepeatedTest(1)
    @DisplayName("TC14")
    public void testSaveDataToFileRelease(){
        String title = "Release_films";
        ReleasePage releasePage = homePage.clickRelease();
        List<String> filmTitles = releasePage.listOfPage();
        utils.printListText("List of films:", filmTitles);
        fileName = title + ".txt";
        fileUtils.createFile(fileName);
        for (String films : filmTitles){
            fileUtils.writeToFile(fileName, films);
        }
        Assertions.assertTrue(isListInFile());
    }

    public Boolean isListInFile(){
        List<String> listFromFile = new ArrayList<>();
        fileUtils.readFromFileAndAddToList(fileName, listFromFile);
        if (listFromFile.size() > 0) return true;
        else return false;
    }


}
