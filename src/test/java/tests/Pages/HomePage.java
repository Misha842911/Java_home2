package test.java.tests.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    By SearchFieldBy = By.xpath("//input[@id='twotabsearchtextbox']");


    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
    }

    public HomePage open(){
        driver.get("https://www.amazon.com/");
        wait.until(d -> d.findElements(By.xpath("//div[@id='nav-xshop']/a")).size() == 6);
        return this;
    }

    public HomePage clickSearchField(){
        driver.findElement(SearchFieldBy).click();
        return this;
    }

    public HomePage enterTextInSearchField(String textToSearch){
        WebElement SearchField = driver.findElement(SearchFieldBy);
        SearchField.click();
        SearchField.sendKeys(textToSearch);
        return this;
    }
}
