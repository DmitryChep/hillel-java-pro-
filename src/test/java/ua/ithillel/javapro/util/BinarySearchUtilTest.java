package ua.ithillel.javapro.util;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchUtilTest {

    @Test
    void binarySearch_shouldReturnTarget_whenArrayDoesNotEmpty() {
        int[] array = {1, 2, 3};
        int target = 2;
        assertEquals(Optional.of(1), BinarySearchUtil.binarySearch(array, target));
    }

    @Test
    void binarySearch_shouldThrowIllegalArgumentException_whenArrayIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> BinarySearchUtil.binarySearch(new int[0], 0));
    }

    @Test
    void binarySearch_shouldReturnErrorNumb_whenTargetDoesNotFound() {
        int[] array = {1, 2, 3};
        int target = 4;
        assertEquals(Optional.of(-1), BinarySearchUtil.binarySearch(array, target));
    }
}