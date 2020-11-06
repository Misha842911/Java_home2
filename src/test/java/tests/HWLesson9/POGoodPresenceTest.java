package test.java.tests.HWLesson9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.tests.Pages.HomePage;
import test.java.tests.Pages.SearchResultPage;
import test.java.tests.TestBaseSetUp;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class POGoodPresenceTest extends TestBaseSetUp {
    HomePage homePage;
    SearchResultPage searchResultPage;

    By AppleCheckBoxBy = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[1]");
    By SamsungCheckBoxBy = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[2]");
    By GoodsListBy = By.xpath("//div[@class='a-section a-spacing-medium']");

    @DataProvider(name = "dp")
    public Object[][] dataprovider(){
        return new Object[][]{
                {"iPhone\n", "iphone", AppleCheckBoxBy},
                {"Samsung\n", "samsung", SamsungCheckBoxBy}
        };
    }

    @BeforeMethod
    public void pageinitialize(){
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    @Test(dataProvider = "dp")
    public void goodPresenceTest(String InputGoodName, String ComparisonItemName, By CheckBox) {

        homePage.open();
        homePage.enterTextInSearchField(InputGoodName);

        searchResultPage.clickCheckBox(CheckBox, GoodsListBy);

        List<WebElement> allGoods = driver.findElements(GoodsListBy);
        for (WebElement good: allGoods) {
            assertEquals ((good.getText().toLowerCase().contains(ComparisonItemName)), true);
        }
    }
}

