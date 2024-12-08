package ua.ithillel.javapro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

class ArrayUtilsTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void secondSmallestNumber_shouldReturnSmallestNumber_whenArrayDoesNotEmpty() {
        int[] array = {1, 3, 2};
        assertEquals(OptionalInt.of(2), ArrayUtils.secondSmallestNumber(array));
    }

    @Test
    void secondSmallestNumber_shouldThrowIllegalArgumentException_whenArrayIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> ArrayUtils.secondSmallestNumber(new int[0]));
    }
}