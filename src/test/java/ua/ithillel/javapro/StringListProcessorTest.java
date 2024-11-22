package ua.ithillel.javapro;

import org.junit.jupiter.api.Test;
import ua.ithillel.javapro.util.CountUpperCaseUtil;

import static org.junit.jupiter.api.Assertions.*;

class StringListProcessorTest {
    static final String TEST_TEXT = "TEST";

    @Test
    void countUpperCase_shouldReturnAmountOfUppercase() {
        assertEquals(4, CountUpperCaseUtil.countUpperCaseUtil(TEST_TEXT, StringListProcessor::countUpperCase));
    }

    @Test
    void countUpperCase_shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> StringListProcessor.countUpperCase(null));
        assertThrows(IllegalArgumentException.class, () -> StringListProcessor.countUpperCase(""));

    }
}