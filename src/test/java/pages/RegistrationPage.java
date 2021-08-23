package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    protected WebDriver driver;

    final By USER_NAME_FIELD = By.id("ap_customer_name");
    final By USER_EMAIL_FIELD = By.id("ap_email");
    final By USER_PASSWORD_FIELD = By.id("ap_password");
    final By CREATE_BUTTON = By.id("a-autoid-0");
    final By ALERT_FIELD = By.id("auth-warning-message-box");


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;

    }

    public void typeToField(String field, String name){
        if (field.contains("name")) driver.findElement(USER_NAME_FIELD).sendKeys(name);
        else if (field.contains("email")) driver.findElement(USER_EMAIL_FIELD).sendKeys(name);
        else if (field.contains("password")){
            driver.findElement(USER_PASSWORD_FIELD).sendKeys(name);

        }
    }

    public void clickCreateButton(){
        driver.findElement(CREATE_BUTTON).click();
    }

    public Boolean isThereAlertField(){
        try {
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(ALERT_FIELD));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public String alertText(){
        return driver.findElement(ALERT_FIELD).getText();
    }

}
