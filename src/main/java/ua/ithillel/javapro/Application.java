package ua.ithillel.javapro;

import ua.ithillel.javapro.util.BinarySearchGenericUtil;
import ua.ithillel.javapro.util.BinarySearchUtil;
import ua.ithillel.javapro.util.MergeSortGenericUtil;
import ua.ithillel.javapro.util.MergeSortUtil;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        // create an array and fill it with random numbers
        int[] array = IntStream.range(0, 10).map(_ -> (int) (Math.random() * 100)).toArray();
        printResult("Unsorted array is: " + Arrays.toString(array));
        // create an Integer array for methods with generic
        Integer[] arrayInteger = Arrays.stream(array).boxed().toArray(Integer[]::new);


        // sort array by mergeSort
        MergeSortUtil.mergeSort(array);
        printResult("Sorted array is: " + Arrays.toString(array));
        // sort generic array mergeSortGeneric
        MergeSortGenericUtil.mergeSortGeneric(arrayInteger);
        printResult("Sorted generic array is: " + Arrays.toString(arrayInteger));


        // search target in int array by binarySearch
        int target = array[2];
        printResult("Target number is: " + target);
        Optional<Integer> resultBinarySearch = BinarySearchUtil.binarySearch(array, target);
        resultBinarySearch.ifPresent(integer -> printResult("Binary search result is: " + integer));

        // search target int Integer array by binarySearchGeneric
        Optional<Integer> resultBinarySearchGeneric = BinarySearchGenericUtil.binarySearchGeneric(arrayInteger, target);
        resultBinarySearchGeneric.ifPresent(integer -> printResult("Binary search result is: " + integer));
    }

    private static void printResult(String result) {
        System.out.println(result);
    }
}
