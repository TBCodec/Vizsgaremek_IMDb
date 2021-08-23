package pages;

import Tests.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AddCookie;
import java.util.concurrent.TimeUnit;

public class LoginPage {
    private final WebDriver driver;
    final By USER_NAME_FIELD = By.xpath("//*[@id=\"ap_email\"]");
    final By PASSWORD_FIELD = By.xpath("//*[@id=\"ap_password\"]");
    final By SIGNIN_BUTTON = By.id("signInSubmit");
    final By AUTH_WARNING_MESSAGE_BOX = By.id("auth-warning-message-box");

    private WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    public void setUserNameField(String userName){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(USER_NAME_FIELD));
        driver.findElement(USER_NAME_FIELD).click();
        driver.findElement(USER_NAME_FIELD).sendKeys(userName);
    }

    public void setPasswordField(String password){
        driver.findElement(PASSWORD_FIELD).click();
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
    }

    public void clickSignInButton(){
        wait = new WebDriverWait(driver, 10);
        driver.findElement(SIGNIN_BUTTON).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //wait.until(ExpectedConditions.urlContains("https://m.imdb.com/?ref_=m_login"));
        AddCookie addCookie = new AddCookie(driver);
        addCookie.saveCookiesToFile();
        }

    public void login(String userName, String password){
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = homePage.clickLogInButton();
        signInPage.clickSignInWithImdb();
        setUserNameField(userName);
        setPasswordField(password);
        clickSignInButton();
    }

    public boolean isThereWarningMessage(){
        try {
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(AUTH_WARNING_MESSAGE_BOX));
            return true;
        }
        catch (Exception e){
            return false;
        }

    }

}
