package runner;

import org.apache.commons.lang3.RandomStringUtils;

public class TestUtils {

    public static String getRandomNameStr(int length) {
        return RandomStringUtils.random(length,
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }

    public static String getRandomNameStr() {
        return getRandomNameStr(15);
    }

    public static String getRandomCodeStr(int length) {
        return RandomStringUtils.random(length,
                "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
    }

    public static String getRandomCodeStr() {
        return getRandomCodeStr(15);
    }

    // погуглить метод для рандомного количества чисел для поля Deposit и Withdrawal
    // или то что ниже

    public static String getRandomInt(int length) {
        return RandomStringUtils.random(length,
                "0123456789");
    }

    public static String getRandomInt() {
        return getRandomInt(6);
    }
}
