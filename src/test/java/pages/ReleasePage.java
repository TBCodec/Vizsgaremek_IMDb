package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ReleasePage {

    public WebDriver driver;

    private By FILM_TITLES = By.xpath("//*[@id=\"pagecontent\"]//span[@class=\"h4\"]");

    public ReleasePage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> listOfPage(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(FILM_TITLES));
        List<WebElement> elements = driver.findElements(FILM_TITLES);
        List<String> listOfPageFilmsTitle = new ArrayList<>();
        for (WebElement element : elements){
            listOfPageFilmsTitle.add(element.getText());
        }

        return listOfPageFilmsTitle;
    }

}
