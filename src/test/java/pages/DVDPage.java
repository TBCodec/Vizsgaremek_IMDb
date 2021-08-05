package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DVDPage {

    public WebDriver driver;

    private By FILM_TITLES = By.xpath("//*[@id=\"chart-content\"]//h4");

    public DVDPage(WebDriver driver){
        this.driver = driver;
    }

    public List<String> listOfPage(){
        List<WebElement> elements = driver.findElements(FILM_TITLES);
        List<String> listOfPageFilmsTitle = new ArrayList<>();
        for (WebElement element : elements){
            listOfPageFilmsTitle.add(element.getText());
        }

        return listOfPageFilmsTitle;
    }

}
