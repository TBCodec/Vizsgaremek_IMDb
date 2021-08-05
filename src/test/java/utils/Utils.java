package utils;

import org.openqa.selenium.WebDriver;

import java.util.List;

public class Utils {

    WebDriver driver;

    public Utils(WebDriver driver) {
        this.driver = driver;
    }

    public void printListText(String titleOfList, List<String> list){
        System.out.println("-----------------------------------");
        System.out.println(titleOfList);
        for (String textInList : list){
            System.out.println(textInList);
        }
        System.out.println("-----------------------------------");
    }

}
