package test.java.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertEquals;

public class TestBaseSetUp {
    public WebDriver driver;
    WebDriverWait wait;
    By AppleCheckBoxBy = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[1]");
    By SamsungCheckBoxBy = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[2]");


    @DataProvider(name = "dp")
    public Object[][] dataprovider(){
        return new Object[][]{
                {"iPhone\n", "iphone", AppleCheckBoxBy},
                {"Samsung\n", "samsung", SamsungCheckBoxBy}
        };
    }

    @BeforeMethod
    public void initializeBrowser(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void finalizeBrowser(){
        driver.quit();
    }


}

