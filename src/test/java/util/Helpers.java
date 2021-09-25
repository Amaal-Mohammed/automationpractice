package util;

public class Helpers {

    public static String generateEmailAddress() {
        return "usertest" + (Math.random() * 10000) + "@gmail.com";
    }

}
