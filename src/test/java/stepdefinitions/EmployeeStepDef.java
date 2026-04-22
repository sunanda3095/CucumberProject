package stepdefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AddEmployeePage;
import pages.LoginAndLogoutPage;

import java.io.IOException;

import static hooks.Hooks.driver;

public class EmployeeStepDef {
    LoginAndLogoutPage login = Hooks.loginpage;
    AddEmployeePage addEmployee = Hooks.addemployee;

    @Given("admin in login page")
    public void admin_in_login_page() {
        System.out.println("Login As Admin");
    }

    @When("admin enter username and password")
    public void admin_enter_username_and_password(io.cucumber.datatable.DataTable dataTable) throws IOException {
        login.enterCredentials(dataTable);
    }

    @And("clicks login button")
    public void clicks_login_button() throws IOException {
        login.loginBtn();
    }

    @Then("urBuddi home page displayed")
    public void ur_buddi_home_page_displayed() {
        Assert.assertEquals(driver.getTitle(), "urBuddi");
    }

    @Given("Admin moving to employee module")
    public void admin_moving_to_employee_module() throws IOException {
        addEmployee.movingToEmployeeModuleAndClickingOnAddEmployee();
    }

    @When("admin enter fields values")
    public void admin_enter_fields_values(io.cucumber.datatable.DataTable dataTable) throws IOException {
        addEmployee.enterEmployeeDetails(dataTable);
    }

    @And("click add employee button")
    public void click_add_employee_button() throws IOException {
        addEmployee.addBtn();
    }

    @Then("Successfully employee added message dispalyed")
    public void successfully_employee_added_message_dispalyed() throws IOException {
        addEmployee.validatingSavedMessage();
    }


}
