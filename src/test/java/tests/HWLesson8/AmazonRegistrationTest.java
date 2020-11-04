package test.java.tests.HWLesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class AmazonRegistrationTest {
    WebDriver driver;
    By CreateAccountFirstBtnBy = By.xpath("//a[@id='createAccountSubmit']");
    By YourNameBy = By.xpath("//input[@id='ap_customer_name']");
    By EmailBy = By.xpath("//input[@id='ap_email']");
    By PasswordBy = By.xpath("//input[@id='ap_password']");
    By ReEnterPassowrdBy = By.xpath("//input[@id='ap_password_check']");
    By CreateAccountSecondBtnBy = By.xpath("//input[@id='continue']");
    By HelloSignInBy = By.xpath("//a[@id='nav-link-accountList']");

    @BeforeMethod
    public void initializeBrowser(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @Test
    public void createAccountWithEmtyFieldsCheck() throws InterruptedException {
        driver.get("https://www.amazon.com/");

        WebElement HelloSignIn = driver.findElement(HelloSignInBy);
        HelloSignIn.click();

        WebElement CreateAccountFirstBtn = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(CreateAccountFirstBtnBy));
        CreateAccountFirstBtn.click();

        WebElement CreateAccountSecondBtn = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(CreateAccountSecondBtnBy));
        CreateAccountSecondBtn.click();
        Thread.sleep(5000);

        WebElement YourNameField = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(YourNameBy));
        WebElement EmailField = driver.findElement(EmailBy);
        WebElement PasswordField = driver.findElement(PasswordBy);

        String expectedNameFieldColor = "rgb(221, 0, 0)";
        String expectedEmailFieldColor = "rgb(221, 0, 0)";
        String expectedPasswordFieldColor = "rgb(221, 0, 0)";

        String actualNameFieldColor = driver.findElement(YourNameBy).getCssValue("border-color");
        String actualEmailFieldColor = driver.findElement(EmailBy).getCssValue("border-color");
        String actualPasswordFieldColor = driver.findElement(PasswordBy).getCssValue("border-color");

        assertEquals(actualNameFieldColor, expectedNameFieldColor);
        assertEquals(actualEmailFieldColor, expectedEmailFieldColor);
        assertEquals(actualPasswordFieldColor, expectedPasswordFieldColor);

        Actions actions = new Actions(driver);
        actions.moveToElement(HelloSignIn);
    }

    @Test
    public void createAccountWithFilledNameEmailPasswordCheck() throws InterruptedException {
        driver.get("https://www.amazon.com/");

        WebElement HelloSignIn = driver.findElement(HelloSignInBy);
        HelloSignIn.click();

        WebElement CreateAccountFirstBtn = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(CreateAccountFirstBtnBy));
        CreateAccountFirstBtn.click();

        WebElement YourNameField1 = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(YourNameBy));
        YourNameField1.sendKeys("UserName");
        WebElement EmailField1 = driver.findElement(EmailBy);
        EmailField1.sendKeys("example@gmail.com");
        WebElement PasswordField1 = driver.findElement(PasswordBy);
        PasswordField1.sendKeys("qwerty");

        WebElement CreateAccountSecondBtn = driver.findElement(CreateAccountSecondBtnBy);
        CreateAccountSecondBtn.click();

        WebElement YourNameField = (new WebDriverWait(driver, 10, 500))
                .until(ExpectedConditions.presenceOfElementLocated(YourNameBy));
        WebElement EmailField = driver.findElement(EmailBy);
        WebElement PasswordField = driver.findElement(PasswordBy);
        WebElement ReEnterPassowrdField = (new WebDriverWait(driver, 10,500))
                .until(ExpectedConditions.presenceOfElementLocated(ReEnterPassowrdBy));

        String expectedNameFieldColor = "rgb(221, 0, 0)";
        String expectedEmailFieldColor = "rgb(221, 0, 0)";
        String expectedPasswordFieldColor = "rgb(221, 0, 0)";
        String expectedReEnterPassowrdField = "rgb(221, 0, 0)";

        String actualNameFieldColor = driver.findElement(YourNameBy).getCssValue("border-color");
        String actualEmailFieldColor = driver.findElement(EmailBy).getCssValue("border-color");
        String actualPasswordFieldColor = driver.findElement(PasswordBy).getCssValue("border-color");
        String actualReEnterPassowrdField = driver.findElement(ReEnterPassowrdBy).getCssValue("border-color");

        assertNotEquals(actualNameFieldColor, expectedNameFieldColor);
        assertNotEquals(actualEmailFieldColor, expectedEmailFieldColor);
        assertNotEquals(actualPasswordFieldColor, expectedPasswordFieldColor);
        assertEquals(actualReEnterPassowrdField, expectedReEnterPassowrdField);
        driver.findElement(ReEnterPassowrdBy).getCssValue("border-color");
        Actions actions = new Actions(driver);
        actions.moveToElement(HelloSignIn);
    }

    @AfterMethod
    public void finalizeBrowser(){
        driver.quit();
    }

}
