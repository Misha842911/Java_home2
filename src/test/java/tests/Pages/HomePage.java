package test.java.tests.Pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.utils.PropertyLoader;


public class HomePage extends BasePage{
    private Logger logger = LogManager.getLogger(HomePage.class);
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement SearchField;
//    By SearchFieldBy = By.xpath("//input[@id='twotabsearchtextbox']");

    public HomePage(WebDriver driver){
        logger.trace("HOME PAGE was initialized");
        this.driver = driver;
        wait = new WebDriverWait(driver, 10, 500);
        PageFactory.initElements(driver,this);
    }

    @Step("Home Page open")
    public HomePage open(){
        logger.info("Open HOME PAGE");
        driver.get(PropertyLoader.loadProperty("url"));
        wait.until(d -> d.findElements(By.xpath("//div[@id='nav-xshop']/a")).size() == 6);
        return this;
    }

    @Step("Click on Search field")
    public HomePage clickSearchField(){
        logger.info("Click 'Search field'");
        SearchField.click();
        return this;
    }

    @Step("Enter text in Search field {textToSearch}")
    public HomePage enterTextInSearchField(String textToSearch){
        logger.info("Input text in the Search field and Press 'Enter'");
        SearchField.click();
        SearchField.sendKeys(textToSearch);
        return this;
    }
}
