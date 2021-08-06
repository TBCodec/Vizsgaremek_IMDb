package listeners;

import Tests.BaseTests;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestAllureListeners implements ITestListener {

    WebDriver driver;


/*

    @Override
    public void onTestFailure(ITestResult result){

        saveScreenshotOnFailure(baseTests.);
        saveLogs(result.getMethod().getConstructorOrMethod().getName());
    }

    @Attachment(value = "Screenshot", type = "image/plain")
    public byte[] saveScreenshotOnFailure(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Stacktrace",type = "text/plain")
    public static String saveLogs(String message){
        return message;
    }

*/

}
