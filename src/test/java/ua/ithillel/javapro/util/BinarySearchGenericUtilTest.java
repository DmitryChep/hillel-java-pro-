package ua.ithillel.javapro.util;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchGenericUtilTest {

    @Test
    void binarySearchGeneric_shouldReturnTarget_whenArrayDoesNotEmpty() {
        Integer[] array = {1, 2, 3};
        Integer target = 2;
        assertEquals(Optional.of(1), BinarySearchGenericUtil.binarySearchGeneric(array, target));
    }

    @Test
    void binarySearchGeneric_shouldThrowIllegalArgumentException_whenArrayIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> BinarySearchGenericUtil.binarySearchGeneric(new Integer[0], 0));
    }

    @Test
    void binarySearchGeneric_shouldReturnErrorNumb_whenTargetDoesNotFound() {
        Integer[] array = {1, 2, 3};
        Integer target = 4;
        assertEquals(Optional.of(-1), BinarySearchGenericUtil.binarySearchGeneric(array, target));
    }
}