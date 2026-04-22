package pages;

import locators.ApplyLeaveLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.GetProperty;
import utilities.SeleniumHelperMethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static hooks.Hooks.applyleave;

public class ApplyLeavePage extends ApplyLeaveLocators {
    WebDriver driver;
    SeleniumHelperMethod utils;
    GetProperty property=new GetProperty();
    public ApplyLeavePage(WebDriver driver){
        this.driver=driver;
        this.utils=new SeleniumHelperMethod(driver);
    }

    public void moveToLeaveMangement() throws IOException {
        utils.click(By.xpath(moveToLeaveManagement));
    }

    public void validatingLeaveToManagement() throws IOException {
        utils.valiadation(By.xpath(validatingLeaveManagementModule),"Leave Management");
    }

    public void applyLeave() throws IOException {
        utils.click(By.xpath(applyLeavebtn));
        utils.click(By.xpath(okbutton));
    }

    public void leaveForm(Map<String, String> data) throws IOException {

        utils.sendKeys(By.xpath(fromdate), data.get("fromDate"));
        utils.sendKeys(By.xpath(todate), data.get("toDate"));
        utils.sendKeys(By.name(subject), data.get("subject"));
        utils.sendKeys(By.name(reason), data.get("reason"));

        utils.click(By.id(leaveRadiobtn));
    }
    public void fillLeaveForm() throws IOException {
        Map<String, String> leavedata = new HashMap<>();
        leavedata.put("fromDate", property.getKeyValue("fromdate"));
        leavedata.put("toDate", property.getKeyValue("todate"));
        leavedata.put("subject", property.getKeyValue("subject"));
        leavedata.put("reason", property.getKeyValue("reason"));
        leaveForm(leavedata);
    }

    public void submitBtn() throws IOException{
        utils.click(By.xpath(submitBtn));
    }

    public void leaveappliedValidation() throws IOException {
        utils.valiadation(By.xpath(leaveappliedValidation), "Leave Applied Successfully");
    }

    public void validateLeaveDetails(Map<String, String> data) throws IOException {

        utils.valiadation(By.xpath(status), data.get("status"));
        utils.valiadation(By.xpath(startdateValidating), data.get("startDate"));
        utils.valiadation(By.xpath(enddateValidating), data.get("endDate"));
    }

}
