package ua.ithillel.javapro.util;

import java.util.Comparator;
import java.util.Optional;

public class BinarySearchGenericUtil {
    public static <T extends Comparable<T>> Optional<Integer> binarySearchGeneric(T[] array, T target) {
        if (array.length == 0) {
            throw new IllegalArgumentException("array is null or empty");
        }
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            // Find the central element
            int middle = left + (right - left) / 2;
            //If the target is found, return it
            if (array[middle] == target) {
                return Optional.of( middle);
                // If target greater, ignore left half
            } else if (array[middle].compareTo(target) > 0) {
                right = middle - 1;
                // If target is smaller, ignore right half
            } else {
                left = middle + 1;
            }
        }
        // If the target is not found, return -1
        return Optional.of(-1);
    }

    public static <T> Optional<Integer> binarySearchGeneric(Comparator<T> comparator, T[] array, T target) {
        if (array.length == 0) {
            throw new IllegalArgumentException("array is null or empty");
        }
        int left = 0;
        int right = array.length - 1;


        while (left <= right) {
            int middle = left + (right - left) / 2; // Find the central element
            if (array[middle] == target) { //If the target is found, return it
                return Optional.of(middle);
            } else if (comparator.compare(array[middle], target) > 0) { // If target greater, ignore left half
                right = middle - 1;
            } else {  // If target is smaller, ignore right half
                left = middle + 1;
            }
        }
        // If the target is not found, return -1
        return Optional.of( -1);
    }
}
