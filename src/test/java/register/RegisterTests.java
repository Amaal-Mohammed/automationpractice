package register;

import Base.BaseTests;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.RegisterPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.Helpers;
import util.ReadData;
import verifications.RegisterVerification;

import java.io.IOException;

public class RegisterTests extends BaseTests {
    public ExtentTest test;
    public ExtentReports report;
    RegisterPage registerPage;

    @BeforeTest
    public void startReport() throws IOException {
        report = new ExtentReports(System.getProperty("user.dir") + "/test-output/RegisterExtentReport.html", true);
        ReadData.setData("resources");
    }

    @Test
    public void testRegisterUser() {
        test = report.startTest("RegisterTests");
        String createuseremail = Helpers.generateEmailAddress();
        LoginPage loginPage = homePage.clickSignIn();
        test.log(LogStatus.INFO, "Open Home page and Click Sign in");
        loginPage.setCreateEmail(createuseremail);
        test.log(LogStatus.INFO, "Insert Email to the Create email Field");
        RegisterPage registerPage = loginPage.clickSubmitEmailBtn();
        test.log(LogStatus.INFO, "Click create an account");
        registerPage.setCustomerFirstname(ReadData.Customerfirstname);
        test.log(LogStatus.INFO, "Insert Customer firstname");
        registerPage.setCustomerLastname(ReadData.Customerlastname);
        test.log(LogStatus.INFO, "Insert Customer lastname");
        registerPage.setCustomerPassword(ReadData.Password);
        test.log(LogStatus.INFO, "Insert password");
        registerPage.setFirstName(ReadData.FirstName);
        test.log(LogStatus.INFO, "Insert firstname");
        registerPage.setLastName(ReadData.LastName);
        test.log(LogStatus.INFO, "Insert lastname");
        registerPage.setAddress(ReadData.Address);
        test.log(LogStatus.INFO, "Insert Address");
        registerPage.setCity(ReadData.City);
        test.log(LogStatus.INFO, "Insert city");
        registerPage.setState(ReadData.State);
        test.log(LogStatus.INFO, "Select state");
        registerPage.setZipCode(ReadData.Postal);
        test.log(LogStatus.INFO, "Insert Postal code");
        registerPage.setMobilePhone(ReadData.Mobile);
        test.log(LogStatus.INFO, "Insert Mobile");
        registerPage.setAddressAlias(ReadData.AddressAlias);
        test.log(LogStatus.INFO, "Insert  Address alias");
        MyAccountPage myaccountpage = registerPage.clickRegisterBtn();
        test.log(LogStatus.INFO, "Click Register button");
        RegisterVerification.verifyRegisteration(myaccountpage.getPageTitle());
        test.log(LogStatus.PASS, "User is registered successfully!!");
    }

    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());

            test.log(LogStatus.FAIL, "Test Case Failed is, " + result.getThrowable().getMessage());
        }
    }

    @AfterTest
    public void end() {
        report.flush();
    }


}
