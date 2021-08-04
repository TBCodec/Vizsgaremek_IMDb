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
        TopBoxOfficePage topBoxOfficePage = homePage.clickFanFavorites();
        List<String> filmTitles = topBoxOfficePage.listOfPage();
        System.out.println("-----------------------------------");
        System.out.println("List of films:");
        for (String films : filmTitles){
            System.out.println(films);
        }
        System.out.println("-----------------------------------");
        Assertions.assertTrue(isThereALotOfFilm(filmTitles));
    }

    public Boolean isThereALotOfFilm(List<String> list){
        return list.size() > 1;
    }


}
