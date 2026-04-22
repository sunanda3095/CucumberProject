package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginAndLogoutPage;
import java.io.IOException;
import static hooks.Hooks.applyleave;
import static hooks.Hooks.driver;

public class ApplyLeaveStepDef {
    LoginAndLogoutPage login = Hooks.loginpage;

    @Given("we are in login page")
    public void we_are_in_login_page() {
        System.out.println("Employee in login Page");
    }

    @When("user enter employee credentials")
    public void user_enter_employee_credentials(io.cucumber.datatable.DataTable dataTable) throws IOException {
        login.enterCredentials(dataTable);
    }

    @And("clicks login")
    public void clicks_login() throws IOException {
        login.loginBtn();
    }

    @Then("logins to account homepage is displayed")
    public void logins_to_account_homepage_is_displayed() {

        Assert.assertEquals(driver.getTitle(), "urBuddi");
    }

    @Given("employee in homepage moves to leavemanagement module")
    public void employee_in_homepage_moves_to_leavemanagement_module() throws IOException {
        applyleave.moveToLeaveMangement();
        applyleave.validatingLeaveToManagement();
    }

    @When("employee clicks apply leave and fills form")
    public void employee_clicks_apply_leave_and_fills_form() throws IOException {
        applyleave.applyLeave();
        applyleave.fillLeaveForm();

    }

    @When("click apply leave button")
    public void click_apply_leave_button() throws IOException {
        applyleave.submitBtn();

    }

    @Then("leave is applied successfully")
    public void leave_is_applied_successfully() throws IOException {
        applyleave.leaveappliedValidation();
    }


}
