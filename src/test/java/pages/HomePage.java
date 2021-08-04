package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By profileButton = By.xpath("//*[@id=\"login-username\"]");
    private By registrationButton = By.xpath("//a[@href='https://www.spotify.com/hu/signup/']");
    private By menuButton = By.xpath("//*[@id=\"preview-menu-container\"]");
    private By logInButton = By.xpath("//*[@id=\"imdbHeader\"]//a[@href=\"/registration/signin?ref=nv_generic_lgin\"]");
    private By USER_NAME_FIELD = By.xpath("//*[@id=\"imdbHeader\"]//div[@class=\"ipc-button__text\"]/span");
    private By PRIVACY_POLICY = By.xpath("//a[contains(@href,'/privacy')]");
    private By TOP_BOX_BUTTON = By.xpath("//*[@id=\"__next\"]//a[@href=\"/chart/boxoffice/?ref_=hm_cht_sm\"]");


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void webdriverWait(By element){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    }

    public TopBoxOfficePage clickFanFavorites(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        WebElement fanFavorites = driver.findElement(TOP_BOX_BUTTON);
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", fanFavorites);
        webdriverWait(TOP_BOX_BUTTON);
        driver.findElement(TOP_BOX_BUTTON).click();
        return new TopBoxOfficePage(driver);
    }

    public PrivacyPolicyPage clickPrivacy(){
        webdriverWait(PRIVACY_POLICY);
        driver.findElement(PRIVACY_POLICY).click();
        return new PrivacyPolicyPage(driver);
    }

    public void clickMenuButton(){
        webdriverWait(menuButton);
        driver.findElement(menuButton).click();
    }

    public SignInPage clickLogInButton(){
        webdriverWait(logInButton);
        driver.findElement(logInButton).click();
        return new SignInPage(driver);

    }
    public void clickLogOutButton(){
        webdriverWait(USER_NAME_FIELD);
        driver.findElement(USER_NAME_FIELD).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("navUserMenu-contents")));
        List<WebElement> listOfProfile = driver.findElements(By.xpath("//*[@id=\"navUserMenu-contents\"]//a"));
        for (WebElement element : listOfProfile){
            if (element.getText().contains("Sign out")){
                element.click();
            }
        }
    }

    public LoginPage clickProfile(){
        clickLogInButton();
        webdriverWait(profileButton);
        driver.findElement(profileButton).click();

        return new LoginPage(driver);
    }

    public RegistrationPage clickRegistration(){
        webdriverWait(registrationButton);
        driver.findElement(registrationButton).click();
        return new RegistrationPage(driver);
    }

    public String getUserName(){
        webdriverWait(USER_NAME_FIELD);
        return driver.findElement(USER_NAME_FIELD).getText();
    }

    public String getUserFieldText(){
        webdriverWait(logInButton);
        return driver.findElement(logInButton).getText();
    }

}
