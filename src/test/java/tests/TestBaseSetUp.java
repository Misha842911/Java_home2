package test.java.tests;

import com.beust.jcommander.Parameter;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import test.java.utils.Screenshots;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;


public class TestBaseSetUp {
    public WebDriver driver;

    @BeforeMethod
    public void initializeBrowser(ITestContext iTestContext){
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//
//        driver = new ChromeDriver(chromeOptions);

        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions ffOptions = new FirefoxOptions();
        try {
            MutableCapabilities options = System.getProperty("browser").equals("chrome")
                    ? chromeOptions
                    : ffOptions;
            driver = new RemoteWebDriver(new URL("ec2-52-15-114-152.us-east-2.compute.amazonaws.com:4444/wd/hub"), options);
//            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().window().maximize();
        iTestContext.setAttribute("driver", driver);
    }

    @AfterMethod
    public void finalizeBrowser(){
        attachText();
        attachScreen();
        driver.quit();
    }

    @Attachment
    public String attachText(){
        return "Text attachment";
    }

    @Attachment
    private byte[] attachScreen(){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }
}

