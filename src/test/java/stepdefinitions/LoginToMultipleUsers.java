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

public class LoginToMultipleUsers {
    LoginAndLogoutPage login = Hooks.loginpage;
    GetProperty property = new GetProperty();

    @Given("user is on login page")
    public void user_is_on_login_page() throws IOException {
        System.out.println("User is on login page");
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String string, String string2) throws IOException {
        login.enterUsername(string);
        login.enterPassword(string2);

    }

    @And("clicks on login button")
    public void clicks_on_login_button() throws IOException {
        login.loginBtn();
    }

    @Then("home page should get displayed")
    public void home_page_should_get_displayed() {
        Assert.assertEquals(driver.getTitle(), "urBuddi");
    }

}
