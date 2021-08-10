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
    final By LOGIN_BUTTON = By.xpath("//*[@id=\"imdbHeader\"]//a[@href=\"/registration/signin?ref=nv_generic_lgin\"]");
    final By USER_NAME_FIELD = By.xpath("//*[@id=\"imdbHeader\"]//div[@class=\"ipc-button__text\"]/span[contains(@class,\"account\")]");
    final By PRIVACY_POLICY = By.xpath("//a[contains(@href,'/privacy')]");
    final By MENU_BUTTON = By.id("imdbHeader-navDrawerOpen--desktop");
    final By MENU_LIST = By.xpath("//*[@id=\"imdbHeader\"]//a");
    final By SEARCH_CATEGORY_BUTTON = By.xpath("//*[@id=\"nav-search-form\"]/div[contains(@class,\"SearchCat\")]");
    final By ADVANCED_SEARCH_BUTTON = By.xpath("//a[@href='https://www.imdb.com/search/']");
    final By ACCOUNT_SETTINGS_BUTTON = By.xpath("//*[@id=\"navUserMenu-contents\"]//a[contains(@href,\"account\")]");
    final By SEARCH_FIELD = By.id("suggestion-search");

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
            //System.out.println(element.getText());
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

    public AccountSettingPage clickAccountSetting(){
        webdriverWait(ACCOUNT_SETTINGS_BUTTON);
        clickElement(ACCOUNT_SETTINGS_BUTTON);
        return new AccountSettingPage(driver);
    }

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
        clickUserNameButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("navUserMenu-contents")));
        List<WebElement> listOfProfile = driver.findElements(By.xpath("//*[@id=\"navUserMenu-contents\"]//a"));
        for (WebElement element : listOfProfile){
            if (element.getText().contains("Sign out")){
                element.click();
            }
        }
    }

    public void clickUserNameButton(){
        webdriverWait(USER_NAME_FIELD);
        clickElement(USER_NAME_FIELD);
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

    //Kereső mezőbe írás
    //public

}
