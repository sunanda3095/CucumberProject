package locators;

public class ApplyLeaveLocators {
    public String moveToLeaveManagement="//p[text()='Leave Management']";
    public String validatingLeaveManagementModule="//p[text()='Dashboard']/../../../../../../div/div/p";
    public String applyLeavebtn="//button[text()='Apply Leave']";
    public String okbutton="//button[text()='Ok']";
    public String fromdate="//input[@placeholder='From']";//xpath
    public String todate="//input[@placeholder='To']";//id
    public String subject="subject";//name
    public String reason="reason";//name
    public String submitBtn="//button[@type='submit']";//xpath
    public String leaveRadiobtn="leave";//id
    public String leaveappliedValidation="//div[text()='Leave Applied Successfully']";//xpath
    public String status="//div[text()='Approved']";
    public String startdateValidating="//div[@col-id='startDate']";
    public String enddateValidating="//div[@col-id=endDate]";
}
