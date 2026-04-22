package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static java.time.Duration.*;

public class wait extends GetProperty{
    public int waitSeconds() throws IOException {
        String waitTime=getKeyValue("long");
        int waitSecondsTime=Integer.parseInt(waitTime);
        return waitSecondsTime;

    }

    public void waitUntilVisble(WebDriver driver, By locator) throws IOException{
        int seconds=waitSeconds();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
    public void waitUntilClickable(WebDriver driver,WebElement element) throws IOException {
        int seconds=waitSeconds();
        WebDriverWait wait=new WebDriverWait(driver, ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
