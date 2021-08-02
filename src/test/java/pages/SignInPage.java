package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SignInPage {

    WebDriver driver;

    By signInList = By.xpath("//div[@id='signin-options']//a[@href]");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickSignInWithImdb(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInList));
        List<WebElement> signInChoose = driver.findElements(signInList);

        signInChoose.get(0).click();
        return new LoginPage(driver);
    }
}
