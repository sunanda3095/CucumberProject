package pages;

import hooks.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.GetProperty;
import utilities.SeleniumHelperMethod;
import locators.LoginAndLogoutLocators;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LoginAndLogoutPage extends LoginAndLogoutLocators {
    WebDriver driver;
    SeleniumHelperMethod utils;
    //LoginAndLogoutPage login= Hooks.loginpage;
    GetProperty property = new GetProperty();
    public LoginAndLogoutPage(WebDriver driver) {
        this.driver=driver;
        this.utils=new SeleniumHelperMethod(driver);
    }

    public void enterUsername(String email) throws IOException {
        utils.sendKeys(By.id(username), email);
    }

    public void enterPassword(String password) throws IOException {
        utils.sendKeys(By.id(passwordLogin), password);
    }
    public void enterCredentials(io.cucumber.datatable.DataTable dataTable) throws IOException {
        List<Map<String, String>> datamap = dataTable.asMaps();
        for (Map<String, String> data : datamap) {
             enterUsername(data.get("username"));
             enterPassword(data.get("password"));
        }
    }
    public void enterFields() throws IOException {
        enterUsername(property.getKeyValue("username"));
        enterPassword(property.getKeyValue("passwordAdmin"));
    }

    public void loginBtn() throws IOException {
        utils.click(By.xpath(login_Btn));
    }

    public void validatingWelcomePage() {

        Assert.assertEquals(driver.getTitle(), "urBuddi");
    }

    public void Logout() throws IOException {
        utils.click(By.className(logout_Btn));
    }
    public void LogoutConfirmation() throws IOException {
        utils.click(By.xpath(logoutConfirmation));
    }
}
