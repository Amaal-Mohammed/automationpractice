package verifications;


import static org.testng.Assert.assertTrue;

public class LoginVerification {
    public static void verifyValidationMsg(String validationmsg) {
        try {
            assertTrue(validationmsg.contains("Authentication failed."),
                    "Alert text is incorrect");
        } catch (AssertionError e) {
            throw new RuntimeException("Validation Message is not displayed!");
        }
    }

}
