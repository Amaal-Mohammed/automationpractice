package verifications;

import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class RegisterVerification {
    public static void verifyRegisteration(String pagetitle) {
        try {
            assertTrue(pagetitle
                            .contains("My account"),
                    "Alert text is incorrect");
        } catch (AssertionError e) {
            throw new RuntimeException("User registration failed");
        }
    }

    public static void verifyRegisterationWithoutallFields(List<WebElement>list) {
        try {
            for (int i=0;i<list.size();i++){
                assertTrue(list.get(i).isDisplayed());
            }

        } catch (AssertionError e) {
            throw new RuntimeException("User registration passed without all mandatoryfields inserted");
        }
    }

    public static void verifyLoggedUserName(String expected,String actual) {
        try {
            assertTrue(actual.contains(expected),
                    "Logged user  is incorrect");

        } catch (AssertionError e) {
            throw new RuntimeException("Assertion failed");
        }
    }
}
