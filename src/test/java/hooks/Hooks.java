package hooks;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import io.cucumber.java.After;

import pages.AddEmployeePage;
import pages.ApplyLeavePage;
import utilities.RandomGenerator;
import utilities.SelectBrowser;
import pages.LoginAndLogoutPage;
import utilities.EmployeeEmailAndId;

public class Hooks {

    public static WebDriver driver;
    public static LoginAndLogoutPage loginpage;
    public static EmployeeEmailAndId testData;
    public static AddEmployeePage addemployee;
    public static ApplyLeavePage applyleave;

    @Before(order = 0)
    public void generateTestData() {
        testData = RandomGenerator.generateEmployeeData();
        System.out.println("Test data generated");
        System.out.println(testData.getEmail());
        System.out.println(testData.getEmpId());
    }

    @Before(order = 1)
    public void setupBrowser() throws Exception {

        SelectBrowser selectBrowser = new SelectBrowser();
        driver = selectBrowser.browser();
        loginpage = new LoginAndLogoutPage(driver);
        addemployee = new AddEmployeePage(driver);
        applyleave = new ApplyLeavePage(driver);
        loginpage.validatingWelcomePage();

        System.out.println("Browser opened");
    }

    @AfterStep
    public void takeScreenshotAfterStep(Scenario scenario) {

        if (driver != null) {
            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Step Screenshot");
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed");
        }
    }
}
