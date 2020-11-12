package test.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import test.java.utils.Screenshots;

import static org.testng.Assert.assertEquals;


public class TestBaseSetUp {
    public WebDriver driver;

    @BeforeMethod
    public void initializeBrowser(ITestContext iTestContext){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        iTestContext.setAttribute("driver", driver);
    }

    @AfterMethod
    public void finalizeBrowser(){
        driver.quit();
    }
}

