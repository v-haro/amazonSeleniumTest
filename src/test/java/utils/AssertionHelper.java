package utils;

import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class AssertionHelper {

    public static void assertNotEquals(String actual, String expected, String message) {
        Assert.assertNotEquals(actual, expected, message);
    }

    public static void softAssertNotEquals(SoftAssert softAssert, String actual, String expected, String message) {
        softAssert.assertNotEquals(actual, expected, message);
    }
}
