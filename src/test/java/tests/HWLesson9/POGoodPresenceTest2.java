package test.java.tests.HWLesson9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.annotations.DisabledRetryAnalyzer;
import test.java.tests.Pages.HomePage;
import test.java.tests.Pages.SearchResultPage;
import test.java.tests.TestBaseSetUp;
import java.util.List;
import test.java.utils.RetryAnalyzer;

import static org.testng.Assert.assertTrue;


public class POGoodPresenceTest2 extends TestBaseSetUp {
    HomePage homePage;
    SearchResultPage searchResultPage;

    By AppleCheckBoxBy = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[1]");
    By SamsungCheckBoxBy = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[2]");
    By goodsListBy = By.xpath("//div[@class='a-section a-spacing-medium']");


    @DataProvider(name = "dp")
    public Object[][] dataprovider(){
        return new Object[][]{
//                {"iPhone\n", "iphone", AppleCheckBoxBy},
                {"Samsung\n", "samsung", SamsungCheckBoxBy}
        };
    }

    @BeforeMethod
    public void pageinitialize(){
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

//    @Test(dataProvider = "dp", retryAnalyzer = RetryAnalyzer.class)
    @Test(dataProvider = "dp")
    public void POgoodPresenceTest(String inputGoodName, String comparisonItemName, By checkBox) {

        homePage.open();
        homePage.enterTextInSearchField(inputGoodName);

        searchResultPage.clickCheckBox(checkBox);

        List<WebElement> allGoods = driver.findElements(goodsListBy);
        for (WebElement good: allGoods) {
            assertTrue ((good.getText().toLowerCase().contains(comparisonItemName)));
        }
    }
}

