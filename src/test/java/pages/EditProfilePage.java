package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProfilePage {

    WebDriver driver;

    protected By BIO_FIELD = By.xpath("//textarea");
    protected By SAVE_DESCRIPTION_BUTTON = By.xpath("//div[contains(@data-save-redirect,\"account\")]");

    public EditProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void writeToBioField(String text){
        driver.findElement(BIO_FIELD).sendKeys(text);
    }

    public void clickSaveDescription(){
        driver.findElement(SAVE_DESCRIPTION_BUTTON).click();
    }

    public void clearBioField(){driver.findElement(BIO_FIELD).clear();}

    public String getTextFromBio(){
        String text = driver.findElement(BIO_FIELD).getText();
        return text;
    }

}
