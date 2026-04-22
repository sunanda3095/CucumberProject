package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessBrowserStepDef {
    public WebDriver driver;
    @Given("open the headless browser")
    public void open_the_headless_browser() {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--headless=new");
       driver=new ChromeDriver(options);
    }
    @When("navigate to application")
    public void navigate_to_application() {
        driver.get("https://dev.urbuddi.com/");
    }
    @Then("get title of application")
    public void get_title_of_application() {
        System.out.println(driver.getTitle());
    }


}
