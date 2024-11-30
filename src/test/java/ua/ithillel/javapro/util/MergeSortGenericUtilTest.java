package ua.ithillel.javapro.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortGenericUtilTest {

    @Test
    void mergeSortGeneric_shouldSortArray_whenArrayDoesNotEmpty() {
        Integer[] array = {4,3,2,1};
        Integer[] expected = {1,2,3,4};
        MergeSortGenericUtil.mergeSortGeneric(array);
        assertEquals(Arrays.toString(expected), Arrays.toString(array));
    }

    @Test
    void mergeSortGeneric_shouldThrowIllegalArgumentException_whenArrayIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> MergeSortGenericUtil.mergeSortGeneric(new Integer[]{}), "Array is empty");
    }
}
