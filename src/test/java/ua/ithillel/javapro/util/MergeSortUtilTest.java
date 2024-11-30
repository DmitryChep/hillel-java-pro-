package ua.ithillel.javapro.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
class MergeSortUtilTest {

    @Test
    void mergeSort_shouldSortArray_whenArrayDoesNotEmpty() {
        int[] array = {4,3,2,1};
        int[] expected = {1,2,3,4};
        MergeSortUtil.mergeSort(array);
        assertEquals(Arrays.toString(expected), Arrays.toString(array));
    }
    @Test
    void mergeSort_shouldThrowIllegalArgumentException_whenArrayIsEmpty() {

        assertThrows(IllegalArgumentException.class, () -> MergeSortUtil.mergeSort(new int[]{}), "Array is empty");
    }
}