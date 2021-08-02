package pages;

import org.openqa.selenium.By;
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
    private By cookiesAcceptButton = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");
    private By menuButton = By.xpath("//*[@id=\"preview-menu-container\"]");
    private By logInButton = By.xpath("//*[@id=\"imdbHeader\"]//a[@href=\"/registration/signin?ref=nv_generic_lgin\"]");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickMenuButton(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuButton));
        driver.findElement(menuButton).click();
    }

    public SignInPage clickLogInButton(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(logInButton));
        driver.findElement(logInButton).click();
        return new SignInPage(driver);

    }


    public LoginPage clickProfile(){
        clickLogInButton();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(profileButton));
        driver.findElement(profileButton).click();

        return new LoginPage(driver);
    }

    public RegistrationPage clickRegistration(){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(registrationButton));
        driver.findElement(registrationButton).click();
        return new RegistrationPage(driver);
    }

    public void clickCookies(){
        wait = new WebDriverWait(driver, 20);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"onetrust-policy\"]")));
        By onetrustGroup = By.xpath("//*[@id=\"onetrust-group-container\"]/parent::div/div");
        getId(onetrustGroup);

        By oneTrustGroupParent = By.xpath("//*[@id=\"onetrust-group-container\"]/parent::div/parent::div");
        getId(oneTrustGroupParent);

        By oneTrustGroupParentParent = By.xpath("//*[@id=\"onetrust-group-container\"]/parent::div/parent::div/parent::div");
        getId(oneTrustGroupParentParent);

        By oneTrustAll = By.xpath("//*[@id=\"onetrust-group-container\"]/parent::div/parent::div/parent::div/parent::div");
        getId(oneTrustAll);

        wait.until(ExpectedConditions.visibilityOfElementLocated(cookiesAcceptButton));
        /*
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
        driver.findElement(cookiesAcceptButton).click();
    }

    public void getId(By field){

        wait.until(ExpectedConditions.visibilityOfElementLocated(field));
        List<WebElement> listOneTrustGroup = driver.findElements(field);
        for (WebElement element : listOneTrustGroup){
            System.out.println();
            System.out.println(field);
            System.out.println(element.getAttribute("id"));
            System.out.println(element.getAttribute("class"));
            System.out.println(element.getText());
            System.out.println();
        }
    }
}
