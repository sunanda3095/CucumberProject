package utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



import java.io.IOException;

public class SeleniumHelperMethod extends wait {
    public WebDriver driver;
    public SeleniumHelperMethod(WebDriver driver) {
        this.driver=driver;
    }
    public WebElement findElement(By locator) {
        return driver.findElement(locator);

    }
    public void sendKeys(By locator,String value) throws IOException {
        WebElement element=driver.findElement(locator);
        waitUntilVisble(driver, locator);
        element.isEnabled();
        element.click();
        element.clear();
        element.sendKeys(value);

    }
    public void click(By locator) throws IOException
    {
        WebElement element=driver.findElement(locator);
        waitUntilVisble(driver, locator);
        waitUntilClickable(driver, element);
        element.click();
    }


   public void dropDown(By locator,String text) throws IOException {
        WebElement element=driver.findElement(locator);
        waitUntilVisble(driver,locator);
        Select dropdown=new Select(element);
       dropdown.selectByVisibleText(text);
   }
    public void valiadation(By locator, String text) throws IOException {
        WebElement element=driver.findElement(locator);
        waitUntilVisble(driver, locator);
        String act_text=element.getText();
        Assert.assertEquals(act_text, text);

    }


}
