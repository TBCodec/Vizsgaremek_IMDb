package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SignInPage {

    WebDriver driver;

    final By SIGIN_LIST = By.xpath("//div[@id='signin-options']//a[@href]");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickChoosedButton(String buttonName){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SIGIN_LIST));
        List<WebElement> signInChoose = driver.findElements(SIGIN_LIST);
        for (WebElement element : signInChoose){
            if (element.getText().contains(buttonName)){
                element.click();
                break;
            }
        }
    }

    public RegistrationPage clickCreateAccount(){
        clickChoosedButton("Account");
        return new RegistrationPage(driver);
    }

    public LoginPage clickSignInWithImdb(){
        clickChoosedButton("IMDb");
        return new LoginPage(driver);
    }
}
