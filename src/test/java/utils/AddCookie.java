package utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class AddCookie {

    private WebDriver driver;

    public AddCookie(WebDriver driver) {
        this.driver = driver;
    }

    public void saveCookiesToFile(){
        File file = new File("Cookiefile.data");
        try{
            // Delete old file if already exists
            file.delete();
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter Bwritecookie = new BufferedWriter(fileWriter); //Getting the cookie information

            for(Cookie ck : driver.manage().getCookies()) {
                Bwritecookie.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));
                Bwritecookie.newLine();
            }
            Bwritecookie.close();
            fileWriter.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }


}
