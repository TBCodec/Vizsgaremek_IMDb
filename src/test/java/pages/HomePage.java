package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {

    private final WebDriver driver;
    private WebDriverWait wait;
    final By PROFILE_BUTTON = By.xpath("//*[@id=\"login-username\"]");
    final By REGISTRATION_BUTTON = By.xpath("//a[@href='https://www.spotify.com/hu/signup/']");
    final By LOGIN_BUTTON = By.xpath("//*[@id=\"imdbHeader\"]//a[@href=\"/registration/signin?ref=nv_generic_lgin\"]");
    final By USER_NAME_FIELD = By.xpath("//*[@id=\"imdbHeader\"]//div[@class=\"ipc-button__text\"]/span");
    final By PRIVACY_POLICY = By.xpath("//a[contains(@href,'/privacy')]");
    final By TOP_BOX_BUTTON = By.xpath("//*[@id=\"__next\"]//a[@href=\"/chart/boxoffice/?ref_=hm_cht_sm\"]");
    final By MENU_BUTTON = By.id("imdbHeader-navDrawerOpen--desktop");
    final By MENU_LIST = By.xpath("//*[@id=\"imdbHeader\"]//a[@role=\"menuitem\"]");
    final By SEARCH_CATEGORY_BUTTON = By.xpath("//*[@id=\"nav-search-form\"]/div[contains(@class,\"SearchCat\")]");
    final By ADVANCED_SEARCH_BUTTON = By.xpath("//a[@href='https://www.imdb.com/search/']");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickElement(By by){
        driver.findElement(by).click();
    }

    //10 mp-es várakozás az elem megjelenésére
    public void webdriverWait(By element){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    }

    //Megadott szöveget keres a menü listájában és ha talál rákattint
    public void clickSelectedByText(String text){
        webdriverWait(MENU_LIST);
        List<WebElement> menuTitles = driver.findElements(MENU_LIST);
        for (WebElement element : menuTitles){
            System.out.println(element.getText());
            if (element.getText().contains(text)) {
                element.click();
                break;
            }

        }
    }

    //Keresés adott oldalra a menü listájában
    //-----------------------------------------------------
    public TopBoxOfficePage clickTopBox(){
        clickMenuButton();
        clickSelectedByText("Top Box");
        return new TopBoxOfficePage(driver);
    }

    public DVDPage clickDVD(){
        clickMenuButton();
        clickSelectedByText("DVD");
        return new DVDPage(driver);
    }
    //------------------------------------------------------

    //Gomb megnyomása funkciók
    //-------------------------------------------------------
    public AdvancedSearchPage clickAdvancedSearch(){
        webdriverWait(SEARCH_CATEGORY_BUTTON);
        clickElement(SEARCH_CATEGORY_BUTTON);
        webdriverWait(ADVANCED_SEARCH_BUTTON);
        clickElement(ADVANCED_SEARCH_BUTTON);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.urlToBe("https://www.imdb.com/search/"));
        return new AdvancedSearchPage(driver);
    }

    public PrivacyPolicyPage clickPrivacy(){
        webdriverWait(PRIVACY_POLICY);
        clickElement(PRIVACY_POLICY);
        return new PrivacyPolicyPage(driver);
    }

    public void clickMenuButton(){
        webdriverWait(MENU_BUTTON);
        clickElement(MENU_BUTTON);
    }

    public SignInPage clickLogInButton(){
        webdriverWait(LOGIN_BUTTON);
        clickElement(LOGIN_BUTTON);
        return new SignInPage(driver);

    }
    public void clickLogOutButton(){
        webdriverWait(USER_NAME_FIELD);
        clickElement(USER_NAME_FIELD);
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
        webdriverWait(PROFILE_BUTTON);
        clickElement(PROFILE_BUTTON);

        return new LoginPage(driver);
    }

    public RegistrationPage clickRegistration(){
        webdriverWait(REGISTRATION_BUTTON);
        clickElement(REGISTRATION_BUTTON);
        return new RegistrationPage(driver);
    }
    //----------------------------------------------------------

    //Felhasználó neve
    public String getUserName(){
        webdriverWait(USER_NAME_FIELD);
        return driver.findElement(USER_NAME_FIELD).getText();
    }


    public String getUserFieldText(){
        webdriverWait(LOGIN_BUTTON);
        return driver.findElement(LOGIN_BUTTON).getText();
    }

}
