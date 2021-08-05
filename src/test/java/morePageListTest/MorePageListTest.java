package morePageListTest;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AdvancedSearchPage;

import java.util.List;

public class MorePageListTest extends BaseTests {

    @Test
    @DisplayName("TC5")
    public void morePageListTest(){
        String searchedThing = "godfather";
        AdvancedSearchPage advancedSearchPage = homePage.clickAdvancedSearch();
        advancedSearchPage.clickAdvancedTitleSearch();
        advancedSearchPage.typeToTitleField(searchedThing);
        advancedSearchPage.clickSearchButton();
        List<List<String>> listFromAllPage = advancedSearchPage.listFromAllPage();
        for (int pageNumber = 1; pageNumber < listFromAllPage.size(); pageNumber++){
            List<String> pages = listFromAllPage.get(pageNumber-1);
            utils.printListText("List of " + searchedThing + ":\n" +
                    pageNumber + ". page\n", pages);

        }
        Assertions.assertFalse(listFromAllPage.size() < 2);

    }
}
