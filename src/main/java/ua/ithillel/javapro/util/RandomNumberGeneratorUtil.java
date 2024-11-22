package ua.ithillel.javapro.util;

import java.util.function.Supplier;

public class RandomNumberGeneratorUtil {
    public static int getRandomNumber(Supplier<Integer> supplier) {
        return supplier.get();
    }
}
