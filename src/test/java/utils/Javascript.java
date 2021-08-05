package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Javascript {

    WebDriver driver;

    public Javascript(WebDriver driver){
        this.driver = driver;
    }

    //megkeresi az oldalon az adott By-t
    public void goToByWithJavascript(By by) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        WebElement fanFavorites = driver.findElement(by);
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", fanFavorites);
    }

}
