package Pages;

import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        return title;

    }

}


