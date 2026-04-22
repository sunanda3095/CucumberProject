package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginAndLogoutPage;

import java.io.IOException;

import static hooks.Hooks.driver;

public class LoginUsingDataTable {
    LoginAndLogoutPage login = Hooks.loginpage;

    @Given("user present in login page")
    public void user_present_in_login_page() {

        System.out.println("User is On Login Page");
    }

    @When("user enter username and password data from data table")
    public void user_enter_username_and_password_data_from_data_table(io.cucumber.datatable.DataTable dataTable) throws IOException {

        login.enterCredentials(dataTable);
    }

    @And("click loginbtn")
    public void click_loginbtn() throws IOException {
        login.loginBtn();

    }

    @Then("urbuddi home page should get displayed")
    public void urbuddi_home_page_should_get_displayed() {

        Assert.assertEquals(driver.getTitle(), "urBuddi");
    }

}
