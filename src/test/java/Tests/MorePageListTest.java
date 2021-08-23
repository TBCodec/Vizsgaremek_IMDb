package Tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import pages.AdvancedSearchPage;

import java.util.List;

public class MorePageListTest extends BaseTests {

    @RepeatedTest(3)
    @DisplayName("TC5")
    @Severity(SeverityLevel.TRIVIAL)
    public void testSearchByTitle(){
        String searchedThing = "godfather";
        AdvancedSearchPage advancedSearchPage = homePage.clickAdvancedSearch();
        advancedSearchPage.clickAdvancedTitleSearch();
        advancedSearchPage.typeToTitleField(searchedThing);
        advancedSearchPage.clickSearchButton();
        List<List<String>> listFromAllPage = advancedSearchPage.listFromAllPage();
        //Lista kiírása
        for (int pageNumber = 1; pageNumber < listFromAllPage.size(); pageNumber++){
            List<String> pages = listFromAllPage.get(pageNumber-1);
            utils.printListText("List of " + searchedThing + ":\n" +
                    pageNumber + ". page\n", pages);

        }
        Assertions.assertFalse(listFromAllPage.size() < 2);

    }
}
