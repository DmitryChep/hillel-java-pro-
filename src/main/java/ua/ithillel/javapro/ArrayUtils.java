package ua.ithillel.javapro;

import java.util.OptionalInt;

public class ArrayUtils {
    @Author(name = "Dmytro", surname = "Chepruko")
    @MethodInfo(methodName = "secondHigherNumberForSmallArrays", returnType = "int",
            methodDescription = "The method returns the second-smallest number in the array.")
    public static OptionalInt secondSmallestNumber(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }
        if (array.length < 2) {
            return OptionalInt.empty();
        }
        int firstMinimalElement = array[0];
        int secondMinimalElement = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < firstMinimalElement) {
                secondMinimalElement = firstMinimalElement;
                firstMinimalElement = array[i];
            } else if (array[i] < secondMinimalElement && array[i] != firstMinimalElement) {
                secondMinimalElement = array[i];
            }
        }
        if (secondMinimalElement != Integer.MAX_VALUE) {
            return OptionalInt.of(secondMinimalElement);
        } else {
            return OptionalInt.of(-1);
        }
    }
}

