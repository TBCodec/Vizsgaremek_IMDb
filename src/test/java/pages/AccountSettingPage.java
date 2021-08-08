package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountSettingPage {

    WebDriver driver;

    By EDIT_PROFILE_BUTTON = By.xpath("//a[contains(@href,\"edit\")]");

    public AccountSettingPage(WebDriver driver) {
        this.driver = driver;
    }

    public EditProfilePage clickEditProfile(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(EDIT_PROFILE_BUTTON));
        driver.findElement(EDIT_PROFILE_BUTTON).click();
        return new EditProfilePage(driver);
    }

}
