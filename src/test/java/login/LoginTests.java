package login;

import Base.BaseTests;
import Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import util.ReadData;
import verifications.LoginVerification;

import java.io.IOException;

public class LoginTests extends BaseTests {
    public static ExtentTest test;
    public static ExtentReports report;

    @BeforeTest
    public void startReport() throws IOException {
        report = new ExtentReports(System.getProperty("user.dir") + "/test-output/LoginExtentReport.html", true);
        ReadData.setData("resources");
    }

    @Test
    public void testFailedattempt() {
        test = report.startTest("LoginTests");
        LoginPage loginPage = homePage.clickSignIn();
        test.log(LogStatus.INFO, "Click on sign in from Upper menu bar to open sign in page");
        loginPage.setEmail(ReadData.BadEmail);
        test.log(LogStatus.INFO, "Insert Bad email");
        loginPage.setPassword(ReadData.Password);
        test.log(LogStatus.INFO, "Insert Password");
        loginPage.clickSignInBtn();
        test.log(LogStatus.INFO, "Click Sign in");
        LoginVerification.verifyValidationMsg(loginPage.getValidationMsg());
        test.log(LogStatus.PASS, "User can not login with invalid cred and error message is displayed");
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
