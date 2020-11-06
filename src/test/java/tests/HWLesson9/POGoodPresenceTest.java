package test.java.tests.HWLesson9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import test.java.tests.Pages.HomePage;
import test.java.tests.Pages.SearchResultPage;
import test.java.tests.TestBaseSetUp;
import java.util.List;

import static org.testng.Assert.assertEquals;


public class POGoodPresenceTest extends TestBaseSetUp {
    HomePage homePage;
    SearchResultPage searchResultPage;
    String searchText = "iPhone\n";
    By AppleCheckBoxBy = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[1]");
    By GoodsListBy = By.xpath("//div[@class='a-section a-spacing-medium']");

    @BeforeClass
    public void pageinitialize(){
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

//    @Test(dataProvider = "dp")
//String InputGoodName, String ExpectedGoodName, By CheckBox
    public void goodPresenceTest() {
        homePage.open();
        homePage.enterTextInSearchField(searchText);

        searchResultPage.clickCheckBox(GoodsListBy, AppleCheckBoxBy);

        List<WebElement> allGoods = driver.findElements(GoodsListBy);
        for (WebElement good: allGoods) {
            assertEquals ((good.getText().contains("iPhone")), true);
        }
    }
}

