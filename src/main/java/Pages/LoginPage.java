package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private By emailaddress = By.id("email");
    private By password = By.id("passwd");
    private By signinbutton = By.id("SubmitLogin");
    private By createemail = By.xpath("//input[@id='email_create']");
    private By submitemailbtn = By.id("SubmitCreate");
    private By validationmsg = By.xpath("//li[contains(text(),'Authentication failed.')]");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String email) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(emailaddress)));
            driver.findElement(emailaddress).click();
            driver.findElement(emailaddress).sendKeys(email);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Can't find \"Email\" field");

        }
    }

    public void setPassword(String passwd) {
        try {
            driver.findElement(password).sendKeys(passwd);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Can't find \"Password\" field");

        }
    }

    public void clickSignInBtn() {
        try {
            driver.findElement(signinbutton).click();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Can't find \"Sign In\" button");
        }
    }

    public String getValidationMsg() {
        String msg = "";
        try {
            msg = driver.findElement(validationmsg).getText();

        } catch (NoSuchElementException e) {
            throw new RuntimeException("Can't find \"tooltip\" ");

        }
        return msg;
    }

    public void setCreateEmail(String randomemail) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(createemail)));
            driver.findElement(createemail).click();
            driver.findElement(createemail).sendKeys(randomemail);

        } catch (NoSuchElementException e) {
            throw new RuntimeException("Can't find \"create email address\" field");

        }
    }

    public RegisterPage clickSubmitEmailBtn() {
        try {
            driver.findElement(submitemailbtn).click();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Can't find \"create email \" button");

        }
        return new RegisterPage(driver);
    }
}
