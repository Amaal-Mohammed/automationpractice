package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    private WebDriver driver;
    private By loggeduser= By.xpath("//a[@title='View my customer account']");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        return title;
    }
    public String getLoggedUserName(){
        String getloggeduser="";
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)");
         getloggeduser=driver.findElement(loggeduser).getText();
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Can't find \"logged user\" field");

        }
        return getloggeduser;
    }

}


