package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AddCookie;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    private int i = 0;
    private WebDriver driver;
    private By userNameField = By.xpath("//*[@id=\"ap_email\"]");
    private By passwordField = By.xpath("//*[@id=\"ap_password\"]");
    private By signInButton = By.id("signInSubmit");
    private By rememberMe = By.xpath("//label[@class='ng-binding']");
    private By alertWarning = By.xpath("//*[@id=\"app\"]//p[@class]//a");

    private WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    public void setUserNameField(String userName){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        driver.findElement(userNameField).click();
        driver.findElement(userNameField).sendKeys(userName);
    }
    public void setPasswordField(String password){
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(password);
    }

    public HomePage clickSignInButton(){
        wait = new WebDriverWait(driver, 10);
        driver.findElement(signInButton).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.urlContains("https://m.imdb.com/?ref_=m_login"));
        AddCookie addCookie = new AddCookie(driver);
        addCookie.saveCookiesToFile();
        return new HomePage(driver);
    }

}
