package ua.ithillel.javapro.util;

import org.junit.jupiter.api.Test;
import ua.ithillel.javapro.StringListProcessor;

import static org.junit.jupiter.api.Assertions.*;

class CountUpperCaseUtilTest {
    @Test
    void countUpperCaseUtil_shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> CountUpperCaseUtil.countUpperCaseUtil("", StringListProcessor::countUpperCase), "String is empty");
    }
}