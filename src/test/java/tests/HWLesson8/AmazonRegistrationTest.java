package test.java.tests.HWLesson8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
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
//
//    @Test
//    public void createAccountWithEmtyFieldsCheck() throws InterruptedException {
//        driver.get("https://www.amazon.com/");
//        Thread.sleep(5000);
//
//        WebElement HelloSignIn = driver.findElement(HelloSignInBy);
//        HelloSignIn.click();
//        Thread.sleep(5000);
//
//        WebElement CreateAccountFirstBtn = driver.findElement(CreateAccountFirstBtnBy);
//        CreateAccountFirstBtn.click();
//        Thread.sleep(5000);
//
//        WebElement CreateAccountSecondBtn = driver.findElement(CreateAccountSecondBtnBy);
//        CreateAccountSecondBtn.click();
//        Thread.sleep(5000);
//
//        WebElement YourNameField = driver.findElement(YourNameBy);
//        WebElement EmailField = driver.findElement(EmailBy);
//        WebElement PasswordField = driver.findElement(PasswordBy);
//
//        String expectedNameFieldColor = "rgb(221, 0, 0)";
//        String expectedEmailFieldColor = "rgb(221, 0, 0)";
//        String expectedPasswordFieldColor = "rgb(221, 0, 0)";
//
//        String actualNameFieldColor = driver.findElement(YourNameBy).getCssValue("border-color");
//        String actualEmailFieldColor = driver.findElement(EmailBy).getCssValue("border-color");
//        String actualPasswordFieldColor = driver.findElement(PasswordBy).getCssValue("border-color");
//
//        assertEquals(actualNameFieldColor, expectedNameFieldColor);
//        assertEquals(actualEmailFieldColor, expectedEmailFieldColor);
//        assertEquals(actualPasswordFieldColor, expectedPasswordFieldColor);

//        Actions actions = new Actions(driver);
//        actions.moveToElement(HelloSignIn);
//    }

    @Test
    public void createAccountWithFilledNameEmailPasswordCheck() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        Thread.sleep(5000);

        WebElement HelloSignIn = driver.findElement(HelloSignInBy);
        HelloSignIn.click();
        Thread.sleep(5000);

        WebElement CreateAccountFirstBtn = driver.findElement(CreateAccountFirstBtnBy);
        CreateAccountFirstBtn.click();
        Thread.sleep(5000);

        WebElement YourNameField = driver.findElement(YourNameBy);
        YourNameField.sendKeys("UserName");
        WebElement EmailField = driver.findElement(EmailBy);
        EmailField.sendKeys("example@gmail.com");
        WebElement PasswordField = driver.findElement(PasswordBy);
        PasswordField.sendKeys("qwerty");

        WebElement CreateAccountSecondBtn = driver.findElement(CreateAccountSecondBtnBy);
        CreateAccountSecondBtn.click();
        Thread.sleep(5000);

        String expectedNameFieldColor = "rgb(221, 0, 0)";
        String expectedEmailFieldColor = "rgb(221, 0, 0)";
        String expectedPasswordFieldColor = "rgb(221, 0, 0)";
        String expectedReEnterPassowrdField = "rgb(221, 0, 0)";

        WebElement ReEnterPassowrdField = driver.findElement(ReEnterPassowrdBy);

        String actualNameFieldColor = driver.findElement(YourNameBy).getCssValue("border-color");
        String actualEmailFieldColor = driver.findElement(EmailBy).getCssValue("border-color");
        String actualPasswordFieldColor = driver.findElement(PasswordBy).getCssValue("border-color");
        String actualReEnterPassowrdField = driver.findElement(PasswordBy).getCssValue("border-color");

        assertNotEquals(actualNameFieldColor, expectedNameFieldColor);
        assertNotEquals(actualEmailFieldColor, expectedEmailFieldColor);
        assertNotEquals(actualPasswordFieldColor, expectedPasswordFieldColor);
        assertEquals(actualReEnterPassowrdField, expectedReEnterPassowrdField);

//        Actions actions = new Actions(driver);
//        actions.moveToElement(HelloSignIn);
    }

//    @AfterMethod
//    public void finalizeBrowser(){
//        driver.quit();
//    }

}
