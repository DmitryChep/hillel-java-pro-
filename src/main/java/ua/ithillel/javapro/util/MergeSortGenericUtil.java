package ua.ithillel.javapro.util;

import java.util.Arrays;


public class MergeSortGenericUtil {
    public static <T extends Comparable<T>> void mergeSortGeneric(T[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        int length = array.length;

        // base case
        if (length == 1) return;

        // davide the original array into two parts
        int middle = length / 2;
        // copy left side of origin array[] to left[] subarray ;
        T[] left = Arrays.copyOfRange(array, 0, middle);
        // copy right side of original array[] to right[] subarray;
        T[] right = Arrays.copyOfRange(array, middle, length);


        mergeSortGeneric(left);
        mergeSortGeneric(right);
        merge(array, left, right);
    }

    private static <T extends Comparable<T>> void merge(T[] array, T[] leftArray, T[] rightArray) {
        int leftArrayLength = leftArray.length;
        int rightArrayLength = rightArray.length;
        int leftElement = 0;
        int rightElement = 0;
        int index = 0;
        while (leftElement < leftArrayLength && rightElement < rightArrayLength) {

            // compare elements left[] subarray and right[] subarray
            if (leftArray[leftElement].compareTo(rightArray[rightElement]) < 0) {
                // add elements to the sorted array[] from left[] subarray
                array[index++] = leftArray[leftElement++];
            } else {
                // add elements to the sorted array[] from right[] subarray
                array[index++] = rightArray[rightElement++];
            }
        }
        // add the remnants of left[] subarray to the sorted array[], if any
        while (leftElement < leftArrayLength) {
            array[index++] = leftArray[leftElement++];
        }
        // add the remnants of right[] subarray to the sorted array[], if any
        while (rightElement < rightArrayLength) {
            array[index++] = rightArray[rightElement++];
        }
    }
}
