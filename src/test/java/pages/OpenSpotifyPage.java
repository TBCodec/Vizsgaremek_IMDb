package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OpenSpotifyPage {

    //private By userName = By.xpath("//*[@id=\"main\"]//figure//parent::button//span");
    private By searchField = By.xpath("//a[@href=\"/search\"]");
    private By welcomeField = By.xpath("//*[@id=\"main\"]//h1");
    private By premiumButton = By.xpath("/html/body//button[@class=\"Button-qlcn5g-0 hRXuMV\"]");


    private WebDriver driver;
    private WebDriverWait wait;

    public OpenSpotifyPage(WebDriver driver) {
            this.driver = driver;
    }

    public String getWebpageURL(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.getCurrentUrl();
    }

    public String getUserName(){
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(premiumButton));
        driver.findElement(premiumButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        driver.findElement(searchField).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeField));
        return driver.findElement(welcomeField).getText();
    }
}
