package Pages;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RegisterPage {
    private WebDriver driver;
    private ExtentTest test;
    private ExtentReports report;
    private By customerfirstname = By.id("customer_firstname");
    private By customerlastname = By.id("customer_lastname");
    private By customerpassword = By.id("passwd");
    private By firstname = By.id("firstname");
    private By lastname = By.id("lastname");
    private By address = By.id("address1");
    private By city = By.id("city");
    private By zipcode = By.id("postcode");
    private By state = By.id("id_state");
    private By mobilephone = By.id("phone_mobile");
    private By addressalias = By.id("alias");
    private By validationmessage = By.xpath("//div[@class='alert alert-danger']/ol/li");
    private By registerbtn = By.id("submitAccount");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;

    }

    public void setCustomerFirstname(String firstname) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(customerfirstname)));
            driver.findElement(customerfirstname).sendKeys(firstname);

        } catch (NoSuchElementException e) {
            throw new RuntimeException("Can't find \"Customer Firstname\" field");

        }
    }

    public void setCustomerLastname(String lastname) {
        try {
            driver.findElement(customerlastname).sendKeys(lastname);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Can't find \"Customer Lastname\" field");

        }
    }

    public void setCustomerPassword(String password) {
        try {
            driver.findElement(customerpassword).sendKeys(password);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Can't find \"Customer Password\" field");

        }
    }

    public void setFirstName(String firsttname) {
        try {
            driver.findElement(firstname).sendKeys(firsttname);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Can't find \"First Name\" field");

        }
    }

    public void setLastName(String lasttname) {
        try {
            driver.findElement(lastname).sendKeys(lasttname);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Can't find \"Last Name\" field");

        }
    }

    public void setAddress(String address1) {
        try {
            driver.findElement(address).sendKeys(address1);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Can't find \"Address\" field");

        }
    }

    public void setCity(String citty) {
        try {
            driver.findElement(city).sendKeys(citty);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Can't find \"City\" field");

        }
    }

    public void setState(String statevalue) {
        try {
            driver.findElement(state).click();
            Select mydropdown = new Select(driver.findElement(state));
            mydropdown.selectByVisibleText(statevalue);

        } catch (NoSuchElementException e) {
            throw new RuntimeException("Can't find \"State\" Dropdown");

        }
    }

    public void setZipCode(String postcode) {
        try {
            driver.findElement(zipcode).sendKeys(postcode);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Can't find \"Zip Code\" field");

        }
    }

    public void setMobilePhone(String cellphone) {
        try {
            driver.findElement(mobilephone).sendKeys(cellphone);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Can't find \"Mobile Phone\" field");

        }
    }

    public void setAddressAlias(String alias) {
        try {
            driver.findElement(addressalias).sendKeys(alias);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Can't find \"Address Alias\" field");

        }
    }

    public List<WebElement> getValidationMsg() {
        List<WebElement> list;
        try {
            list = driver.findElements(validationmessage);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Can't find \"validation messages for mandatory fields\" field");
        }
        return list;
    }

    public MyAccountPage clickRegisterBtn() {
        try {
            driver.findElement(registerbtn).click();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Can't find \"Register Button\" field");

        }
        return new MyAccountPage(driver);
    }


}
