package ua.ithillel.javapro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DataProviderTest {
    private DataProvider dataProvider;

    @BeforeEach
    void setUp() {
        dataProvider = new DataProvider();
    }

    @Test
    void getData() {
        String[] expectedResult = {"brange", "plum", "tbmatb", "onibn", "grape"};
        assertArrayEquals(expectedResult, dataProvider.getData());
    }
}