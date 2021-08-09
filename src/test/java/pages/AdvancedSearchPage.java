package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Javascript;

import java.util.ArrayList;
import java.util.List;

public class AdvancedSearchPage {

    private WebDriver driver;
    private WebDriverWait wait;


    protected By ADVANCED_TITLE_SEARCH = By.xpath("//a[@href=\"/search/title\"]");
    protected By TITLE_FIELD = By.xpath("//input[@name='title']");
    protected By SEARCH_BUTTON = By.xpath("//*[@id=\"main\"]//button");
    protected By LIST_OF_SEARCHED = By.xpath("//h3[@class]");
    protected By NEXT_BUTTON = By.xpath("//*[@id=\"main\"]//a[text()='Next »']");

    public AdvancedSearchPage(WebDriver driver){
        this.driver = driver;
    }

    public void webdriverWaitByBy(By by){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    public void clickAdvancedTitleSearch(){
        webdriverWaitByBy(ADVANCED_TITLE_SEARCH);
        driver.findElement(ADVANCED_TITLE_SEARCH).click();
    }

    public void typeToTitleField(String text){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.HOME).build().perform();
        webdriverWaitByBy(TITLE_FIELD);
        driver.findElement(TITLE_FIELD).clear();
        driver.findElement(TITLE_FIELD).sendKeys(text);

    }


    public void clickSearchButton(){
        Javascript javascript = new Javascript(driver);
        javascript.goToByWithJavascript(SEARCH_BUTTON);
        driver.findElement(SEARCH_BUTTON).click();
    }


    public List<String> listFromPage(){
        List<WebElement> elements = driver.findElements(LIST_OF_SEARCHED);
        List<String> listOfPageFilmsTitle = new ArrayList<>();
        for (WebElement element : elements){
            listOfPageFilmsTitle.add(element.getText());
        }

        return listOfPageFilmsTitle;
    }

    //Lista minden oldalról, amíg van "next" gomb
    public List<List<String>> listFromAllPage(){
        List<List<String>> listFromAllPage = new ArrayList<>();
        while (isThereNextButton())
        {
            listFromAllPage.add(listFromPage());
            driver.findElement(NEXT_BUTTON).click();

        }
        return listFromAllPage;
    }

    //Keresi a "next" gombot az aktuális oldalon
    public Boolean isThereNextButton(){
        try {
            return driver.findElement(NEXT_BUTTON).isDisplayed();
        }
        catch (Exception e){
            return false;
        }
    }

}
