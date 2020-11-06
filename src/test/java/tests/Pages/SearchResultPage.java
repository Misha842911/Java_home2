package test.java.tests.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage {
    WebDriver driver;
    WebDriverWait wait;

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
    };

    public SearchResultPage clickCheckBox(By CheckBox, By GoodsListBy){
        wait.until(ExpectedConditions.visibilityOfElementLocated(CheckBox));
        driver.findElement(CheckBox).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(GoodsListBy));
        return this;
    }
}
