package test.java.tests.HWlesson13;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.tests.Pages.HomePage;
import test.java.tests.Pages.SearchResultPage;
import test.java.tests.TestBaseSetUp;

import java.util.List;

import static org.testng.Assert.assertTrue;

@Epic("Epic 1")
@Feature("Feature third")
public class LaptopTest3 extends TestBaseSetUp {
    HomePage homePage;
    SearchResultPage searchResultPage;
    String inputItemName = "laptop\n";

    @BeforeMethod
    public void pageinitialize(){
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    //    @Story("AAA-1")
    @Stories({
            @Story("AAA-6"),
            @Story("AAA-7")
    })
    @Links({
            @Link("https://google.com"),
            @Link("https://google.com")
    })

    @TmsLinks({
            @TmsLink("BBB-1"),
            @TmsLink("BBB-2")
    })
    @Issues({
            @Issue("JIRA-1"),
            @Issue("JIRA-2")
    })
    @Description("Some detailed description")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void LaptopTest(String comparisonItemName, By checkBox) {
        System.out.println("TEST PARAMRTRIZED WITH: " + comparisonItemName + " AND " + checkBox);
        homePage.open();
        homePage.enterTextInSearchField(inputItemName);

        searchResultPage.clickSeeMore();
        searchResultPage.clickCheckBox(checkBox);

        List<WebElement> allItems = searchResultPage.getSearchResultItemText();
        for (WebElement item : allItems) {
            assertTrue(item.getText().replace("_", " ").toLowerCase().contains(comparisonItemName));
        }
    }
}
