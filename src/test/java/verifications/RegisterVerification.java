package verifications;

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
}
