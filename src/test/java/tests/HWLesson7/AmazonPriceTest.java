package test.java.tests.HWLesson7;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class AmazonPriceTest {
    @Test
    public static void priceCheck() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("window-size=1000,1000");
//        chromeOptions.addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");
        Thread.sleep(5000);

        By bytodaysDeal = By.xpath("//a[@href='/international-sales-offers/b/?ie=UTF8&node=15529609011&ref_=nav_cs_gb_intl']");
        WebElement todaysDealsBtn = driver.findElement(bytodaysDeal);
        todaysDealsBtn.click();
        Thread.sleep(5000);

        By byFirstElement = By.xpath("((//a[@id='dealTitle'])[1]/span)[1]");
        WebElement FirstElement = driver.findElement(byFirstElement);
        FirstElement.click();

        By byitemName = By.xpath("(//span[@class='a-size-base a-color-base'])[1]");
        WebElement itemname = driver.findElement(byitemName);
        String itemNameString = itemname.getText();
        System.out.println("THE ITEM NAME IS: " + itemNameString);

        By byOldprice = By.xpath("(//span[@class='a-size-mini a-color-tertiary octopus-widget-strike-through-price a-text-strike'])[1]");
        WebElement oldPrice = driver.findElement(byOldprice);
        String oldPriceString = oldPrice.getText();
        System.out.println("The old price is: " + oldPriceString.substring(1));

        By byNewPriceFirst = By.xpath("(//span[@class='a-price-whole'])[1]");
        WebElement NewPriceFirst = driver.findElement(byNewPriceFirst);
        String NewPriceFirstString = NewPriceFirst.getText();

        By byNewPriceSecond = By.xpath("(//span[@class='a-price-fraction'])[1]");
        WebElement NewPriceSecond = driver.findElement(byNewPriceSecond);
        String NewPriceSecondString = NewPriceSecond.getText();

        System.out.println("The new price is: " + NewPriceFirstString + "." + NewPriceSecondString);
        Thread.sleep(5000);
        driver.close();
    }
}
