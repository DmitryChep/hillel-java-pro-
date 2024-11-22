package ua.ithillel.javapro.util;

import java.util.function.Function;

public class CountUpperCaseUtil {
    public static int countUpperCaseUtil(String string, Function<String, Integer> function) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("String is empty");
        }
        return function.apply(string);
    }
}
