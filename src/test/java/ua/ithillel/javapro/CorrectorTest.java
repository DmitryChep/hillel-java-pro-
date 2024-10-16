package ua.ithillel.javapro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CorrectorTest {
    private Corrector corrector;
    private DataProvider dataProvider;

    @BeforeEach
    void setUp() {
        corrector = new Corrector();
        dataProvider = new DataProvider();
    }

    @Test
    void handleData() {
        String expectedResult = "1)orange\n" +
                                "2)plum\n" +
                                "3)tomato\n" +
                                "4)onion\n" +
                                "5)grape\n";
        assertEquals(expectedResult, corrector.handleData(dataProvider.getData()));
    }
}