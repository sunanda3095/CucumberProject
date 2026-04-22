package pages;

import hooks.Hooks;
import locators.AddEmployeeLocators;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.EmployeeEmailAndId;
import utilities.SeleniumHelperMethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AddEmployeePage extends AddEmployeeLocators {
    WebDriver driver;
    SeleniumHelperMethod utils;
    EmployeeEmailAndId RandomData = Hooks.testData;

    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
        this.utils = new SeleniumHelperMethod(driver);
    }

    public void movingToEmployeeModuleAndClickingOnAddEmployee() throws IOException {
        utils.click(By.xpath(employeemodule));
        //Adding Employee
        utils.click(By.xpath(addemployeeBtn));
    }


    public void enterFirstname(String firstnameValue) throws IOException {
        utils.sendKeys(By.name(firstname), firstnameValue);
    }

    public void enterLastname(String lastnameValue) throws IOException {
        utils.sendKeys(By.name(lastname), lastnameValue);
    }

    public void enterEmployeeId(String empIdValue) throws IOException {
        utils.sendKeys(By.id(empId), empIdValue);
    }

    public void enterEmail(String emailValue) throws IOException {
        utils.sendKeys(By.name(email), emailValue);
    }

    public void selectRole(String roleValue) throws IOException {
        utils.dropDown(By.id(role), roleValue);
    }

    public void enterPersonalMail(String PersonalMail) throws IOException {
        utils.sendKeys(By.name(personalEmail), PersonalMail);
    }

    public void enterPassword(String PasswordValue) throws IOException {
        utils.sendKeys(By.name(password), PasswordValue);
    }

    public void enterDOB(String dobValue) throws IOException {
        utils.sendKeys(By.name(dob), dobValue);
    }

    public void enterDOJ(String dojValue) throws IOException {
        utils.sendKeys(By.name(doj), dojValue);
    }

    public void enterPastExperience(String experience) throws IOException {
        utils.sendKeys(By.name(pastexperience), experience);
    }

    public void selectQualification(String qualificationValue) throws IOException {
        utils.dropDown(By.id(qualification), qualificationValue);
    }

    public void enterDepartment(String deptValue) throws IOException {
        utils.sendKeys(By.name(dept), deptValue);

    }

    public void selectGender(String genderValue) throws IOException {
        utils.dropDown(By.id(gender), genderValue);
    }

    public void enterMobileNo(String mobileNoValue) throws IOException {
        utils.sendKeys(By.name(mobileNo), mobileNoValue);
    }

    public void selectBloodGroup(String bloogGroupValue) throws IOException {
        utils.dropDown(By.id(bloodgroup), bloogGroupValue);
    }

    public void enterDesignation(String designationValue) throws IOException {
        utils.sendKeys(By.name(designation), designationValue);
    }

    public void enterSalary(String salaryValue) throws IOException {
        utils.sendKeys(By.id(salary), salaryValue);
    }

    public void enterLoaction(String locationValue) throws IOException {
        utils.sendKeys(By.name(loaction), locationValue);
    }

    public void selectToReporting(String reportingToValue) throws IOException {
        utils.dropDown(By.id(reportingTo), reportingToValue);
    }

    public void selectCertificates(String certificatesValue) throws IOException {
        utils.dropDown(By.className(certifiactes), certificatesValue);

    }

    public void enterEmployeeDetails(io.cucumber.datatable.DataTable dataTable) throws IOException {

        Map<String, String> data = new HashMap<>();

        for (Map<String, String> row : dataTable.asMaps(String.class, String.class)) {
            data.put(row.get("fields").toLowerCase(), row.get("values"));
        }

        for (String key : data.keySet()) {

            switch (key) {

                case "firstname":
                    enterFirstname(data.get(key));
                    break;

                case "lastname":
                    enterLastname(data.get(key));
                    break;

                case "empid":

                    if ((data.get(key).equalsIgnoreCase("random"))) {
                        enterEmployeeId(RandomData.getEmpId());
                    } else {
                        enterEmployeeId(data.get(key));
                    }
                    break;

                case "email":
                    if ((data.get(key).equalsIgnoreCase("random"))) {
                        enterEmail(RandomData.getEmail());
                    } else {
                        enterEmail(data.get(key));
                    }
                    break;

                case "role":
                    selectRole(data.get(key));
                    break;

                case "personalemail":
                    enterPersonalMail(data.get(key));
                    break;

                case "passwordemp":
                    enterPassword(data.get(key));
                    break;

                case "dob":
                    enterDOB(data.get(key));
                    break;

                case "doj":
                    enterDOJ(data.get(key));
                    break;

                case "experience":
                    enterPastExperience(data.get(key));
                    break;

                case "qualification":
                    selectQualification(data.get(key));
                    break;

                case "dept":
                    enterDepartment(data.get(key));
                    break;

                case "gender":
                    selectGender(data.get(key));
                    break;

                case "mobileno":
                    enterMobileNo(data.get(key));
                    break;

                case "bloodgroup":
                    selectBloodGroup(data.get(key));
                    break;

                case "designation":
                    enterDesignation(data.get(key));
                    break;

                case "salary":
                    enterSalary(data.get(key));
                    break;

                case "location":
                    enterLoaction(data.get(key));
                    break;

                case "reportingto":
                    selectToReporting(data.get(key));
                    break;

                default:
                    System.out.println("No matching field: " + key);
            }
        }
    }

    public void addBtn() throws IOException {
        utils.click(By.xpath(addBtn));
    }

    public void validatingSavedMessage() throws IOException {
        utils.valiadation(By.xpath(savedsuccessfully), "Saved Successfully");
    }


}
