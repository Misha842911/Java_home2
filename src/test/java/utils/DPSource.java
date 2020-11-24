package test.java.utils;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class DPSource {
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

    @DataProvider
    public Object[][] smoke(){
        return new Object[][]{
                {"jbnmbn", hpCheckBoxBy},
                {"acer", acerCheckBoxBy}
        };
    };
    @DataProvider
    public Object[][] regression(){
        return new Object[][]{
                {"jbnmbn", hpCheckBoxBy},
                {"acer", acerCheckBoxBy},
                {"asus", asusCheckBoxBy},
//                {"lenovo", lenovoCheckBoxBy},
//                {"dell", dellCheckBoxBy},
//                {"microsoft", microsoftCheckBoxBy},
//                {"apple", appleCheckBoxBy},
//                {"chuwi", chuwiCheckBoxBy},
//                {"lg", lgCheckBoxBy},
//                {"jumper", jumperCheckBoxBy}
        };
    };
}
