package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import utils.FileUtils;
import utils.Utils;
import utils.WindowManager;

import java.util.concurrent.TimeUnit;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;
    public Utils utils;
    public LoginPage loginPage;
    public FileUtils fileUtils;
    public WindowManager windowManager;

    protected String username = "litro@freemail.hu";
    protected String password = "Bw330405";

    @BeforeEach
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");
        options.addArguments("--window-size=1920, 1080");
        options.addArguments("--user-agent='Mozilla/5.0 (Windows Phone 10.0; Android 4.2.1; Microsoft; Lumia 640 XL LTE) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Mobile Safari/537.36 Edge/12.10166'");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.imdb.com/");

        homePage = new HomePage(driver);
        utils = new Utils(driver);
        loginPage = new LoginPage(driver);
        fileUtils = new FileUtils(driver);
        windowManager = new WindowManager(driver);
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
