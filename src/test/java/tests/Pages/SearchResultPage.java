package test.java.tests.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
    WebDriver driver;
    WebDriverWait wait;
    By brandListBy = By.xpath("//div[@id='brandsRefinements']//*[@class='a-spacing-micro']");
    By seeMoreBy = By.xpath("(//i[@class='a-icon a-icon-extender-expand'])[2]");
    By goodsListBy = By.xpath("//div[@class='a-section a-spacing-medium']");

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
    };

    public SearchResultPage clickCheckBox(By checkBox){
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkBox));
        driver.findElement(checkBox).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(goodsListBy));
        return this;
    }
    public SearchResultPage unClickCheckBox(By checkBox){
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkBox));
        driver.findElement(checkBox).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(goodsListBy));
        return this;
    }

    public SearchResultPage clickSeeMore(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(seeMoreBy));
        driver.findElement(seeMoreBy).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(brandListBy));
        return this;
    }
}
