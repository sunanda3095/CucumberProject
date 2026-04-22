package utilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectBrowser extends GetProperty {
    public WebDriver driver;
    GetProperty property;
    public WebDriver browser() throws IOException {

        property = new GetProperty();
        String url = property.getKeyValue("url");

        // 1. command line (highest priority)
        String browsername = System.getProperty("browser");

        // 2. property file fallback
        if (browsername == null || browsername.isEmpty()) {
            browsername = property.getKeyValue("browser");
        }

        // 3. default fallback
        if (browsername == null || browsername.isEmpty()) {
            browsername = "chrome";
        }

        if (browsername.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();

        } else if (browsername.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        } else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--headless=new");
            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(url);

        return driver;
    }

}