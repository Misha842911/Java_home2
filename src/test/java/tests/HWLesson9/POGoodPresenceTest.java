package test.java.tests.HWLesson9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import test.java.tests.TestBaseSetUp;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class POGoodPresenceTest extends TestBaseSetUp {
    By SearchFieldBy = By.xpath("//input[@id='twotabsearchtextbox']");
    By GoodsListBy = By.xpath("//div[@class='a-section a-spacing-medium']");


    @Test(dataProvider = "dp")
    public void goodPresenceTest(String InputGoodName, String ExpectedGoodName, By CheckBox) throws InterruptedException {
        driver.get("https://www.amazon.com/");
        WebElement SearchField = driver.findElement(SearchFieldBy);
        SearchField.click();
        SearchField.sendKeys(InputGoodName);

        WebElement GoodsList = (new WebDriverWait(driver, 10,500))
                .until(ExpectedConditions.presenceOfElementLocated(GoodsListBy));
        WebElement ItemCheckBox = driver.findElement(CheckBox);
        ItemCheckBox.click();

        List<WebElement> allGoods = driver.findElements(GoodsListBy);

        for (WebElement good: allGoods) {
            assertEquals ((good.getText().contains(ExpectedGoodName.toLowerCase())), true);
        }
    }
}

