package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;
    private By signin = By.className("login");

    public HomePage(WebDriver driver) {
        this.driver = driver;

    }

    public LoginPage clickSignIn() {
        driver.findElement(signin).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return new LoginPage(driver);
    }

}
