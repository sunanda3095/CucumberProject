package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginAndLogoutPage;
import utilities.GetProperty;

import java.io.IOException;

import static hooks.Hooks.driver;

public class LoginStepDef {
    LoginAndLogoutPage login = Hooks.loginpage;


    @Given("user on login page")
    public void user_on_login_page() throws IOException {
        System.out.println("User is on login page");
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() throws IOException {
        login.enterFields();
    }

    @And("clicks the login button")
    public void clicks_the_login_button() throws IOException {
        login.loginBtn();
    }

    @Then("dashboard should get displayed")
    public void dashboard_should_get_displayed() {
        Assert.assertEquals(driver.getTitle(), "urBuddi");
    }


}
