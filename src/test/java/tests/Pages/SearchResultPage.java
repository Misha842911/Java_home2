package test.java.tests.Pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultPage extends BasePage {
    private Logger logger = LogManager.getLogger(HomePage.class);
    WebDriver driver;
    WebDriverWait wait;
    By brandListBy = By.xpath("//div[@id='brandsRefinements']//*[@class='a-spacing-micro']");
    By seeMoreBy = By.xpath("(//i[@class='a-icon a-icon-extender-expand'])[2]");
    By goodsListBy = By.xpath("//div[@class='a-section a-spacing-medium']");
    By laptopBrandsCheckBoxes = By.xpath("(//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-medium'])[3]//*[@class='a-icon a-icon-checkbox']");
    By itemListBy = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");

    public SearchResultPage(WebDriver driver){
        logger.trace("SEARCHRESULT PAGE was initialized");
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
    };

    public SearchResultPage open(){
        logger.info("Open Search result page");
        driver.get("https://www.amazon.com/s?k=laptop&ref=nb_sb_noss");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(goodsListBy));
        return this;
    }

    public SearchResultPage clickCheckBox(By checkBox){
        logger.info("Click Laptop CheckBox");
        logger.error("ERROR!!!");
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkBox));
        driver.findElement(checkBox).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(goodsListBy));
        return this;
    }

    public SearchResultPage clickSeeMore(){
        logger.info("Click 'See more' to open all laptop brands");
        logger.warn("WARN!!!");
        logger.error("ERROR!!!");
        wait.until(ExpectedConditions.visibilityOfElementLocated(seeMoreBy));
        driver.findElement(seeMoreBy).click();
        wait.until(d -> d.findElements(laptopBrandsCheckBoxes).size()==10);
        return this;
    }

    public List<WebElement> getLaptopCheckBoxesBrandList(){
        logger.info("Get list of laptop brand checkboxes");
        logger.error("ERROR!!!");
        wait.until(d -> d.findElements(laptopBrandsCheckBoxes).size()==10);
        return driver.findElements(laptopBrandsCheckBoxes);
    }

    public List<WebElement> getSearchResultItemText(){
        logger.info("Get list of text for items");
        logger.warn("WARN!!!");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(goodsListBy));
        return driver.findElements(itemListBy);
    }

//    public SearchResultPage clickCheckBoxMultipleTimes(By laptopBrandsCheckBoxes ){
//        logger.info("Click Laptop CheckBox");
//        logger.error("ERROR!!!");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(laptopBrandsCheckBoxes));
//        List<WebElement> allCheckboxes = getLaptopCheckBoxesBrandList();
//        for (WebElement brandCheckBox : allCheckboxes) {
//            try {
//                wait.until(ExpectedConditions.presenceOfElementLocated(brandCheckBox));
//                brandCheckBox.click();
//            } catch (Exception e) {
//                System.out.println("can not click");
//            }
//        }
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(goodsListBy));
//
//        return this;
//    }

}
