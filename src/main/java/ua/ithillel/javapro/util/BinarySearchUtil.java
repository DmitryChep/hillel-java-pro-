package ua.ithillel.javapro.util;

import java.util.Optional;

public class BinarySearchUtil {
    public static Optional<Integer> binarySearch(int[] array, int target) {
        if (array.length == 0) {
            throw new IllegalArgumentException("array is empty");
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2  ; // Find the central element
            if (array[middle] == target) { //If the target is found, return it
                return Optional.of(middle);
            } else if (target < array[middle]) { // If target greater, ignore left half
                right = middle - 1;
            } else {  // If target is smaller, ignore right half
                left = middle + 1;
            }
        }
        // If the target is not found, return -1
        return Optional.of(-1);
    }
}

