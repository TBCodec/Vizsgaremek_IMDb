package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.http.protocol.RequestUserAgent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
import utils.AddCookie;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;
    private AddCookie addCookie;

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        /*
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        */
        options.addArguments("--headless");
        options.addArguments("--window-size=1920, 1080");
        options.addArguments("--remote-debugging-port=9222");

        //options.addArguments("--allow-insecure-localhost");
        //options.addArguments("--disable-gpu");

        //options.addArguments("--user-agent='Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.107 Safari/537.36\n'");
        //options.addArguments("--user-agent='Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36'");

        options.addArguments("--user-agent='Mozilla/5.0 (Windows Phone 10.0; Android 4.2.1; Microsoft; Lumia 640 XL LTE) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Mobile Safari/537.36 Edge/12.10166'");
        //options.addArguments("--disable-setuid-sandbox");
        //options.addArguments("--disable-blink-features");
      //  options.addArguments("--disable-blink-features=AutomationControlled");
        //options.addArguments("-incognito");
        options.addArguments("start-maximized");
        //options.setExperimentalOption("excludeSwitches", "[\"enable-automation\"]");
        //options.setExperimentalOption("useAutomationExtension", false);
        //options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        //options.setExperimentalOption("useAutomationExtension", false);
        /*options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");*/
        //options.setExperimentalOption("prefs", {"profile.default_content_settings.cookies": 2});

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.imdb.com/");

        homePage = new HomePage(driver);

        //addCookie = new AddCookie(driver);
        //addCookie.addCookie();
        //homePage.clickCookies();
        //System.out.println(driver.getCurrentUrl());
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
