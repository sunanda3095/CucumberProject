package hooks;

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

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed");
        }
    }
}
