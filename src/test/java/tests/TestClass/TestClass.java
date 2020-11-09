package test.java.tests.TestClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.tests.Pages.HomePage;
import test.java.tests.Pages.SearchResultPage;
import test.java.tests.TestBaseSetUp;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestClass extends TestBaseSetUp {
    HomePage homePage;
    SearchResultPage searchResultPage;

    By itemListBy = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
    String inputItemName = "laptop\n";
    By hpCheckBoxBy = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[1]");
    By acerCheckBoxBy = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[2]");
    By asusCheckBoxBy = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[3]");
    By lenovoCheckBoxBy = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[4]");
    By dellCheckBoxBy = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[5]");
    By microsoftCheckBoxBy = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[6]");
    By appleCheckBoxBy = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[7]");
    By chuwiCheckBoxBy = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[8]");
    By lgCheckBoxBy = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[9]");
    By jumperCheckBoxBy = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[10]");

    By checkBoxBrandListBy = By.xpath("(//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-medium'])[3]//*[@class='a-icon a-icon-checkbox']");

    @DataProvider(name = "dp")
    public Object[][] dataprovider(){
        return new Object[][]{
                {"hp", hpCheckBoxBy},
                {"acer", acerCheckBoxBy},
                {"asus", asusCheckBoxBy},
                {"lenovo", lenovoCheckBoxBy},
                {"dell", dellCheckBoxBy},
                {"microsoft", microsoftCheckBoxBy},
                {"apple", appleCheckBoxBy},
                {"chuwi", chuwiCheckBoxBy},
                {"lg", lgCheckBoxBy},
                {"jumper", jumperCheckBoxBy}
        };
    }

    @BeforeMethod
    public void pageinitialize(){
        homePage = new HomePage(driver);
        searchResultPage = new SearchResultPage(driver);
    }

    @Test(dataProvider = "dp")
    public void LaptopTest(String comparisonItemName, By checkBox) {
        homePage.open();
        homePage.enterTextInSearchField(inputItemName);

        searchResultPage.clickSeeMore();
        List<WebElement> allCheckboxes = driver.findElements(checkBoxBrandListBy);
        for (WebElement brandCheckBox : allCheckboxes) {

            searchResultPage.clickCheckBox(checkBox);
            List<WebElement> allItems = driver.findElements(itemListBy);
            for (WebElement good : allItems) {
                String actualItemName = "";
                String itemText = (good.getText().replace("_", " ").toLowerCase());
                String[] itemTextArr = itemText.split(" ");
                for (String itemWord : itemTextArr) {
                    if(itemWord.contains(comparisonItemName)){
                        actualItemName = itemWord;
                    }
                }
                assertEquals(actualItemName, comparisonItemName);
            }
            searchResultPage.unClickCheckBox(checkBox);
        }

    }
}
