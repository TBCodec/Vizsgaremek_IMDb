package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PrivacyPolicyPage {

    public WebDriver driver;
    public WebDriverWait wait;

    private By PRIVACY_POLICY = By.xpath("//*[@id=\"main\"]");

    public PrivacyPolicyPage(WebDriver driver) {
        this.driver = driver;
    }

    public void webdriverWait(By by){
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public String linesOnPrivacy(){
        webdriverWait(PRIVACY_POLICY);
        return driver.findElement(PRIVACY_POLICY).getText();
    }

}
